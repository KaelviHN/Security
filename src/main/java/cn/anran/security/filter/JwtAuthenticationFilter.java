package cn.anran.security.filter;

import cn.anran.security.Domain.dao.UmsSysUser;
import cn.anran.security.config.IConstants;
import cn.anran.security.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: KaelviHN
 * @created: 2024/11/13
 * @description:
 **/
@Log4j2
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private JwtUtil jwtUtil;

    /**
     * 该方法会被doFilter掉用
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter) throws ServletException, IOException {
        // 从请求头获取token
        String token = request.getHeader(IConstants.TOKEN_HEADER);
        log.info("token: {}", token);
        // 如果没有token(是login)，直接放行
        if (token == null) {
            doFilter(request, response, filter);
            return;
        }
        // 解析token
        Claims claims;
        try {
            claims = jwtUtil.parseToken(token);
            log.info("claims: {}", claims);
        } catch (Exception e) {
            // 需要返回401，重新登陆
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("验签失败！！！");
            return;
        }
        // 将获取到的数据放回user中
        Long id = claims.get("id", Long.class);
        String username = claims.get("username", String.class);
        String avatar = claims.get("avatar", String.class);
        List<?> permissions = claims.get("permission", ArrayList.class);
        // 将信息放到User类中
        UmsSysUser user = new UmsSysUser();
        user.setId(id);
        user.setUsername(username);
        user.setAvatar(avatar);
        user.setPermissions(permissions.stream().map(Object::toString).collect(Collectors.toSet()));
        // 把信息放到SecurityContext中
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        doFilter(request, response, filter);
    }
}

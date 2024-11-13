package cn.anran.security.service;

import cn.anran.security.Domain.dao.UmsMenu;
import cn.anran.security.Domain.dao.UmsRole;
import cn.anran.security.Domain.dao.UmsSysUser;
import cn.anran.security.Domain.dto.LoginParams;
import cn.anran.security.repository.UmsMenuRepository;
import cn.anran.security.repository.UmsSysUserRepository;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Collections.addAll;

/**
 * @author: KaelviHN
 * @created: 2024/11/12
 * @description:
 **/
@Log4j2
@Service
public class UmsSysUserService implements UserDetailsService {

    @Resource
    private UmsSysUserRepository userRepository;

//    @Resource
//    private AuthenticationManager authenticationManager;

    @Resource
    private UmsMenuRepository menuRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loading user , username {}", username);
        UmsSysUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("username not found"));
        log.info("load user success , userId {}", user.getId());
        // 获取角色id
        Set<Long> roleIds = user.getUmsRoles().stream().map(UmsRole::getId).collect(Collectors.toSet());
        // 获取菜单
        Set<UmsMenu> menus = menuRepository.findByIdIn(roleIds);
        // 补充权限
        Set<String> permissions = user.getPermissions();
        permissions.addAll(menus.stream().map(UmsMenu::getPerms).toList());

        return user;
    }

    public String login(LoginParams params) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(params.getUsername(),
                params.getPassword());
        // 调用loaderUserByUsername
//        Authentication authenticate = authenticationManager.authenticate(token);
//        UserDetails principal = (UserDetails) authenticate.getPrincipal();
//        return principal.toString();
        return UUID.randomUUID().toString();
    }
}

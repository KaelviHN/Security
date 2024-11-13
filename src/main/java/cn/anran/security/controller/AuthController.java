package cn.anran.security.controller;

import cn.anran.security.Domain.dto.LoginParams;
import cn.anran.security.service.UmsSysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KaelviHN
 * @created: 2024/11/12
 * @description:
 **/

@RestController
@RequestMapping("auth")
public class AuthController {
    @Resource
    private UmsSysUserService userService;

    /**
     * 登录
     * @param params
     * @return
     */
    @PostMapping("login")
    public String login(@RequestBody LoginParams params) {
        return userService.login(params);
    }
}

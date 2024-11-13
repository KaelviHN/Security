package cn.anran.security.Domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author: KaelviHN
 * @created: 2024/11/12
 * @description:
 **/
@Data
public class LoginParams {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}

package cn.anran.security.Domain.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.awt.font.ShapeGraphicAttribute;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "ums_sys_user")
public class UmsSysUser implements Serializable , UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "nickname", nullable = false, length = 30)
    private String nickname;

    @ColumnDefault("''")
    @Column(name = "email", length = 50)
    private String email;

    @ColumnDefault("''")
    @Column(name = "mobile", length = 11)
    private String mobile;

    @ColumnDefault("0")
    @Column(name = "sex")
    private Integer sex;

    @ColumnDefault("''")
    @Column(name = "avatar", length = 100)
    private String avatar;

    @ColumnDefault("''")
    @Column(name = "password", length = 100)
    private String password;

    @ColumnDefault("0")
    @Column(name = "status")
    private Integer status;

    @ColumnDefault("1")
    @Column(name = "creator")
    private Long creator;

    @Column(name = "create_time")
    private Instant createTime;

    @ColumnDefault("1")
    @Column(name = "updater")
    private Long updater;

    @Column(name = "update_time")
    private Instant updateTime;

    @Column(name = "remark", length = 500)
    private String remark;

    @ColumnDefault("0")
    @Column(name = "deleted")
    private Byte deleted;

    @Transient
    private Set<UmsRole> umsRoles = new HashSet<>();

    @Transient
    private Set<String> permissions = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (permissions!=null && !permissions.isEmpty())
            return permissions.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
package cn.anran.security.Domain.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ums_menu")
public class UmsMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Size(max = 255)
    @Column(name = "menu_name")
    private String menuName;

    @ColumnDefault("0")
    @Column(name = "sort")
    private Integer sort;

    @Column(name = "menu_type")
    private Integer menuType;

    @Size(max = 255)
    @Column(name = "perms")
    private String perms;

    @Size(max = 255)
    @Column(name = "icon")
    private String icon;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_time")
    private Instant updateTime;

}
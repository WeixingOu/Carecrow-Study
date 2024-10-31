package com.std.carecrow.domain.entity;

import com.std.carecrow.domain.enumtype.MenuType;
import com.std.carecrow.domain.enumtype.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long parentId;

    @Column(nullable = false, length = 255)
    private String menuName;

    private Integer sort;

    @Enumerated(EnumType.ORDINAL)
    private MenuType menuType;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(nullable = false, length = 255)
    private String path;

    @Column(nullable = false, length = 255)
    private String componentPath;

    @Column(nullable = false, length = 255)
    private String perms;

    @Column(nullable = false, length = 255)
    private String icon;

    private Boolean deleted = false;

    @Column(nullable = false, length = 30)
    private String creator;

    @Column(nullable = false, length = 30)
    private String updater;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime updateTime;

    @ManyToMany(mappedBy = "menus")
    private Set<Role> roles = new HashSet<>();
}

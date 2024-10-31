package com.std.carecrow.domain.entity;

import com.std.carecrow.domain.dto.record.AddSysUserDTO;
import com.std.carecrow.domain.enumtype.Sex;
import com.std.carecrow.domain.enumtype.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 30)
    private String nickname;

    @Column(length = 50)
    private String email;

    @Column(length = 11)
    private String mobile;

    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    @Column(length = 100)
    private String avatar;

    @Column(length = 100)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(nullable = false, length = 30)
    private String creator;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column(nullable = false, length = 30)
    private String updater;

    @Column(nullable = false)
    private LocalDateTime updateTime;

    @Column(length = 500)
    private String remark;

    private Boolean deleted;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @PrePersist
    public void prePersist() {
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateTime = LocalDateTime.now();
    }

    public static SysUser fromDTO(AddSysUserDTO dto) {
        return SysUser.builder()
            .username(dto.username())
            .nickname(dto.nickname())
            .email(dto.email())
            .mobile(dto.mobile())
            .sex(dto.sex())
            .avatar(dto.avatar())
            .password(dto.password())
            .status(dto.status())
            .creator(dto.creator())
            .updater(dto.updater())
            .remark(dto.remark())
            .deleted(false)
            .roles(new HashSet<>())
            .build();
    }
}

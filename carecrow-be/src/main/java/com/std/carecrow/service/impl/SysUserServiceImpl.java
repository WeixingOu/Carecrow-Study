package com.std.carecrow.service.impl;

import com.std.carecrow.domain.dto.record.AddSysUserDTO;
import com.std.carecrow.domain.entity.SysUser;
import com.std.carecrow.repository.SysUserRepository;
import com.std.carecrow.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    private final SysUserRepository sysUserRepository;

    @Autowired
    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public void addSysUser(AddSysUserDTO addSysUserDTO) {
        SysUser sysUser = SysUser.fromDTO(addSysUserDTO);
        sysUserRepository.save(sysUser);
    }
}

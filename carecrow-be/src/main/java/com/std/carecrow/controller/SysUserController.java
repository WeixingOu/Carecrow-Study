package com.std.carecrow.controller;

import com.std.carecrow.domain.dto.record.AddSysUserDTO;
import com.std.carecrow.exception.response.ApiResponse;
import com.std.carecrow.service.SysUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SysUserController {
    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PostMapping("/sysusers")
    public ResponseEntity<ApiResponse<Void>> addSysUser(@Valid @RequestBody AddSysUserDTO addSysUserDTO) {
        try {
            sysUserService.addSysUser(addSysUserDTO);
            return new ResponseEntity<>(ApiResponse.success(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

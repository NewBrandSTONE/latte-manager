package com.ztc.latte.service.realms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ztc.latte.api.SysResourceInfoService;
import com.ztc.latte.api.SysUserInfoService;
import com.ztc.latte.model.SysResourceInfo;
import com.ztc.latte.model.SysUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LatteRealm extends AuthorizingRealm {

    @Reference
    private SysResourceInfoService sysResourceInfoService;

    @Reference
    private SysUserInfoService sysUserInfoService;

    /**
     * 授权，判断当前用户具有什么权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUserInfo sysUserInfo = (SysUserInfo) principalCollection.getPrimaryPrincipal();
        // 根据sysUserInfo查询这个用户在系统中有什么权限
        List<String> permission = new ArrayList<>();
        List<SysResourceInfo> resourceInfoList = sysResourceInfoService.findByUserUuid(sysUserInfo.getSysUserUid());
        resourceInfoList.forEach(x -> permission.add(x.getSysResourceName()));
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permission);
        return info;
    }

    /**
     * 认证，判断当前用户身份的合法性
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        SysUserInfo userInfo = sysUserInfoService.findByUserName(usernamePasswordToken.getUsername());
        if (userInfo == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(userInfo, userInfo.getSysPwd().toCharArray(), ByteSource.Util.bytes(userInfo.getSysPwd()), getName());
    }
}

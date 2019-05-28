package com.ztc.latte.service.realms;

import com.ztc.latte.api.SysResourceInfoService;
import com.ztc.latte.api.SysUserInfoService;
import com.ztc.latte.model.SysResourceInfo;
import com.ztc.latte.model.SysUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class LatteRealm extends AuthorizingRealm {

    @Autowired
    private SysResourceInfoService sysResourceInfoService;

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

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
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
        return null;
    }
}

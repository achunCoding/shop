package top.wycfight.shop.bo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.wycfight.shop.entity.UmsAdmin;
import top.wycfight.shop.entity.UmsPermission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-09-15 19:25
 * @modify By:
 **/
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionList;

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> result = new ArrayList<>();
        for (UmsPermission umsPermission : permissionList) {
            if (umsPermission.getValue() != null) {
                result.add(new SimpleGrantedAuthority(umsPermission.getValue()));
            }

        }
        return result;
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}

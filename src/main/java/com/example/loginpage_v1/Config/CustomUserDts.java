package com.example.loginpage_v1.Config;

import com.example.loginpage_v1.Model.UserDts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**Interface UserDetails trong Spring Security đại diện cho thông tin chi tiết về một người dùng trong hệ thống.
 * Nó chứa các thông tin như tên người dùng, mật khẩu, vai trò và quyền hạn của người dùng đó.
 * Chức năng chính của interface UserDetails là cung cấp thông tin về người dùng cho Spring Security để thực hiện quá trình xác thực và
 * kiểm soát truy cập.

 Interface UserDetails định nghĩa các phương thức sau:

 getAuthorities(): Trả về danh sách các quyền hạn (GrantedAuthority) của người dùng. Quyền hạn mô tả các hành động cụ thể
 mà người dùng được phép thực hiện trong hệ thống.

 getPassword(): Trả về mật khẩu đã được mã hóa của người dùng.

 getUsername(): Trả về tên người dùng.

 isAccountNonExpired(): Xác định xem tài khoản người dùng có hợp lệ không hết hạn.

 isAccountNonLocked(): Xác định xem tài khoản người dùng có bị khóa không.

 isCredentialsNonExpired(): Xác định xem các thông tin xác thực của người dùng (mật khẩu) có hợp lệ không hết hạn.

 isEnabled(): Xác định xem tài khoản người dùng có được kích hoạt hay không.

 Các lớp triển khai của UserDetails được sử dụng để cung cấp thông tin người dùng cụ thể cho Spring Security.
 Thông thường, các lớp triển khai sẽ lưu trữ thông tin người dùng trong cơ sở dữ liệu hoặc các nguồn dữ liệu khác và triển khai các
 phương thức của UserDetails để truy xuất và trả về thông tin người dùng.*/

public class CustomUserDts implements UserDetails {

    private UserDts userDts;

    public CustomUserDts(UserDts userDts) {
        this.userDts = userDts;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userDts.getRole());
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return userDts.getPassword();
    }

    @Override
    public String getUsername() {
        return userDts.getEmail();
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
        return true;
    }
}

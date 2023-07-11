package com.example.loginpage_v1.Config;

import com.example.loginpage_v1.Model.UserDts;
import com.example.loginpage_v1.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**Interface UserDetailsService trong Spring Security được sử dụng để cung cấp thông tin chi tiết về người dùng,
 * bao gồm tên người dùng, mật khẩu và vai trò của họ. Chức năng chính của UserDetailsService là tìm kiếm và truy xuất thông tin người dùng
 * từ nguồn dữ liệu như cơ sở dữ liệu, hệ thống LDAP hoặc bất kỳ nguồn dữ liệu nào khác.

 Interface UserDetailsService định nghĩa một phương thức duy nhất là loadUserByUsername(String username),
 mà các lớp triển khai cần thực hiện. Phương thức này nhận vào tên người dùng và trả về một đối tượng UserDetails,
 chứa thông tin chi tiết về người dùng. UserDetails bao gồm tên người dùng, mật khẩu đã được mã hóa, danh sách vai trò và
 quyền hạn của người dùng.

 Khi một người dùng cố gắng đăng nhập vào hệ thống, UserDetailsService được sử dụng để xác minh danh tính của người dùng
 bằng cách tìm kiếm thông tin người dùng dựa trên tên người dùng. Nếu tìm thấy người dùng, UserDetails được trả về và Spring Security sẽ
 kiểm tra tính hợp lệ của mật khẩu và quyền hạn.*/

@Service
public class UserDtsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDts userDts = userRepo.findByEmail(email);
        if (userDts != null){
            return new CustomUserDts(userDts);
        }
        return null;
    }
}


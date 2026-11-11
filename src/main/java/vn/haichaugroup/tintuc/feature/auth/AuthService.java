package vn.haichaugroup.tintuc.feature.auth;

import vn.haichaugroup.tintuc.feature.auth.dto.LoginRequest;
import vn.haichaugroup.tintuc.feature.auth.dto.LoginResponse;
import vn.haichaugroup.tintuc.feature.auth.dto.RegisterRequest;
import vn.haichaugroup.tintuc.feature.auth.dto.RegisterResponse;
import vn.haichaugroup.tintuc.feature.user.dto.UserResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request, String deviceInfo, String ipAddress);

    RegisterResponse register(RegisterRequest request);

    LoginResponse refresh(String rawRefreshToken);

    void logout(String rawRefreshToken);

    UserResponse getMe(String email);
}

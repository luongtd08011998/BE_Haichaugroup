package vn.haichaugroup.tintuc.qlkh.auth;

import vn.haichaugroup.tintuc.qlkh.auth.dto.CustomerLoginRequest;
import vn.haichaugroup.tintuc.qlkh.auth.dto.CustomerLoginResponse;
import vn.haichaugroup.tintuc.qlkh.auth.dto.RefreshTokenRequest;
import vn.haichaugroup.tintuc.qlkh.auth.dto.TokenResponse;

public interface QlkhAuthService {

    TokenResponse login(CustomerLoginRequest request);

    TokenResponse refresh(RefreshTokenRequest request);

    void logout(String authHeader);

    CustomerLoginResponse getCustomer(String authHeader);
}

package vn.haichaugroup.tintuc.feature.auth.dto;

public record LoginResponse(
        String accessToken,
        String refreshToken
) {
}

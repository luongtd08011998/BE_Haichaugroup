package vn.haichaugroup.tintuc.feature.auth.dto;

import vn.haichaugroup.tintuc.feature.user.User;
import vn.haichaugroup.tintuc.util.constant.GenderEnum;

import java.time.Instant;

public record RegisterResponse(
        Long id,
        String name,
        String email,
        Integer age,
        GenderEnum gender,
        String address,
        Instant createdAt
) {
    public static RegisterResponse fromEntity(User user) {
        return new RegisterResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge(),
                user.getGender(),
                user.getAddress(),
                user.getCreatedAt()
        );
    }
}

package vn.haichaugroup.tintuc.feature.user.dto;

import vn.haichaugroup.tintuc.util.constant.GenderEnum;

public record UserFilterRequest(
        String keyword,
        String name,
        String email,
        String address,
        Integer ageFrom,
        Integer ageTo,
        GenderEnum gender,
        String roleName,
        Boolean isActive) {
}

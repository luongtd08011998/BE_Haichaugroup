package vn.haichaugroup.tintuc.feature.tag.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTagRequest(
        @NotBlank(message = "Tên tag không được để trống") String name,
        String description
) {
}

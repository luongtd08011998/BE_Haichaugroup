package vn.haichaugroup.tintuc.feature.media.dto;

public record MediaFilterRequest(
        String title,
        String fileType,
        Long folderId,
        Boolean rootOnly) {
}

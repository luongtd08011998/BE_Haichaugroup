package vn.haichaugroup.tintuc.feature.file;

import org.springframework.web.multipart.MultipartFile;

import vn.haichaugroup.tintuc.feature.file.dto.FileUploadResponse;

public interface FileService {

    FileUploadResponse upload(MultipartFile file, String folder);
}

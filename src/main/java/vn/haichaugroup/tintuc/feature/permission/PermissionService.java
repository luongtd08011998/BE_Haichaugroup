package vn.haichaugroup.tintuc.feature.permission;

import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.feature.permission.dto.CreatePermissionRequest;
import vn.haichaugroup.tintuc.feature.permission.dto.PermissionFilterRequest;
import vn.haichaugroup.tintuc.feature.permission.dto.PermissionResponse;
import vn.haichaugroup.tintuc.feature.permission.dto.UpdatePermissionRequest;
import org.springframework.data.domain.Pageable;

public interface PermissionService {

    PermissionResponse create(CreatePermissionRequest request);

    PermissionResponse update(UpdatePermissionRequest request);

    PermissionResponse getById(Long id);

    ResultPaginationDTO filter(PermissionFilterRequest filter, Pageable pageable);

    void delete(Long id);
}

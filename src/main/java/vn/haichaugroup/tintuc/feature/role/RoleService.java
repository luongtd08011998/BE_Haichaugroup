package vn.haichaugroup.tintuc.feature.role;

import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.feature.role.dto.CreateRoleRequest;
import vn.haichaugroup.tintuc.feature.role.dto.RoleFilterRequest;
import vn.haichaugroup.tintuc.feature.role.dto.RoleResponse;
import vn.haichaugroup.tintuc.feature.role.dto.UpdateRoleRequest;
import org.springframework.data.domain.Pageable;

public interface RoleService {

    RoleResponse create(CreateRoleRequest request);

    RoleResponse update(UpdateRoleRequest request);

    RoleResponse getById(Long id);

    ResultPaginationDTO filter(RoleFilterRequest filter, Pageable pageable);

    void delete(Long id);
}

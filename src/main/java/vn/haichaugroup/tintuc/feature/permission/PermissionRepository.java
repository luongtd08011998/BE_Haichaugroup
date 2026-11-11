package vn.haichaugroup.tintuc.feature.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {

    boolean existsByApiPathAndMethod(String apiPath, String method);

    boolean existsByApiPathAndMethodAndIdNot(String apiPath, String method, Long id);
}

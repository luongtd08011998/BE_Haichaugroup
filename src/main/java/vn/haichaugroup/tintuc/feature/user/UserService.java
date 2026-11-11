package vn.haichaugroup.tintuc.feature.user;

import org.springframework.data.domain.Pageable;

import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.feature.user.dto.CreateUserRequest;
import vn.haichaugroup.tintuc.feature.user.dto.UpdateUserRequest;
import vn.haichaugroup.tintuc.feature.user.dto.UserFilterRequest;
import vn.haichaugroup.tintuc.feature.user.dto.UserResponse;

public interface UserService {

    UserResponse create(CreateUserRequest request);

    UserResponse update(UpdateUserRequest request);

    UserResponse getById(Long id);

    ResultPaginationDTO filter(UserFilterRequest filter, Pageable pageable);

    void delete(Long id);
}

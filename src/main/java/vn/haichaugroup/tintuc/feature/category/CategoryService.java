package vn.haichaugroup.tintuc.feature.category;

import org.springframework.data.domain.Pageable;
import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.feature.category.dto.CategoryResponse;
import vn.haichaugroup.tintuc.feature.category.dto.CategoryTreeResponseDTO;
import vn.haichaugroup.tintuc.feature.category.dto.CreateCategoryRequest;
import vn.haichaugroup.tintuc.feature.category.dto.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {

    CategoryResponse create(CreateCategoryRequest request);

    CategoryResponse update(UpdateCategoryRequest request);

    CategoryResponse getById(Long id);

    ResultPaginationDTO filter(vn.haichaugroup.tintuc.feature.category.dto.CategoryFilterRequest filter, Pageable pageable);

    void delete(Long id);

    List<CategoryResponse> searchByName(String keyword);

    List<CategoryResponse> getByParentId(Long parentId);

    List<CategoryResponse> getRootCategories();

    CategoryResponse getBySlug(String slug);

    CategoryTreeResponseDTO getCategoryTree(Long id);

    List<CategoryTreeResponseDTO> getAllAsTree(String keyword);
}

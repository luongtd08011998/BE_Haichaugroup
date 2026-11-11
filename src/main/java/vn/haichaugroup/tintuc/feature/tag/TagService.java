package vn.haichaugroup.tintuc.feature.tag;

import org.springframework.data.domain.Pageable;

import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.feature.tag.dto.CreateTagRequest;
import vn.haichaugroup.tintuc.feature.tag.dto.TagFilterRequest;
import vn.haichaugroup.tintuc.feature.tag.dto.TagResponse;
import vn.haichaugroup.tintuc.feature.tag.dto.UpdateTagRequest;

public interface TagService {

    TagResponse create(CreateTagRequest request);

    TagResponse update(UpdateTagRequest request);

    TagResponse getById(Long id);

    ResultPaginationDTO filter(TagFilterRequest filter, Pageable pageable);

    void delete(Long id);
}

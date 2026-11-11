package vn.haichaugroup.tintuc.feature.document;

import org.springframework.data.domain.Pageable;

import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.feature.document.dto.CreateDocumentRequest;
import vn.haichaugroup.tintuc.feature.document.dto.DocumentFilterRequest;
import vn.haichaugroup.tintuc.feature.document.dto.DocumentResponse;
import vn.haichaugroup.tintuc.feature.document.dto.UpdateDocumentRequest;

import java.util.List;

public interface DocumentService {

    DocumentResponse create(CreateDocumentRequest request);

    DocumentResponse update(UpdateDocumentRequest request);

    DocumentResponse getById(Long id);

    ResultPaginationDTO filter(DocumentFilterRequest filter, Pageable pageable);

    List<DocumentResponse> getByArticleId(Long articleId);

    void delete(Long id);
}

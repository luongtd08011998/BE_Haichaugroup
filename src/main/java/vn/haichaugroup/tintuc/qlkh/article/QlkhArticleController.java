package vn.haichaugroup.tintuc.qlkh.article;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.haichaugroup.tintuc.dto.ApiResponse;
import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.feature.article.ArticleService;

@RestController
@RequestMapping("/api/v1/qlkh")
public class QlkhArticleController {

    private final ArticleService articleService;

    public QlkhArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Danh sách bài viết bảo trì cấp nước (tag "BaoTri-CupNuoc").
     */
    @GetMapping("/customer/articles/maintenance")
    public ResponseEntity<ApiResponse<ResultPaginationDTO>> getMaintenanceArticles(
            @ParameterObject Pageable pageable) {
        ResultPaginationDTO result = articleService.getArticlesByTagName("BaoTri-CupNuoc", pageable);
        return ResponseEntity.ok(ApiResponse.success("Lấy danh sách bài viết bảo trì cấp nước thành công", result));
    }

    @GetMapping("/customer/articles/featured")
    public ResponseEntity<ApiResponse<ResultPaginationDTO>> getFeaturedArticles(
            @ParameterObject Pageable pageable) {
        ResultPaginationDTO result = articleService.getFeaturedArticles(pageable);
        return ResponseEntity.ok(ApiResponse.success("Lấy danh sách bài viết nổi bật thành công", result));
    }
}

# BE HaiChauGroup — Website Tin tức & Tra cứu Hóa đơn

Backend RESTful API cho **HaiChauGroup**, xây dựng trên nền tảng **Spring Boot 4**, **Spring Security 7 (OAuth2 Resource Server JWT)** và **Spring Data JPA (Multi-DataSource MySQL)**.

- **Package gốc**: `vn.haichaugroup.tintuc`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **Tài khoản Admin mặc định (Seed Data)**: `admin@haichaugroup.vn` / `12345678`

---

## Cấu trúc Phân hệ

1. **Website Tin tức & Quản trị (`vn.haichaugroup.tintuc.feature`)**:
   - Quản lý bài viết (`article`), danh mục đa cấp (`category`), thẻ (`tag`), tài liệu đính kèm (`document`), thư viện `media` & upload `file`.
   - Quản trị người dùng (`user`), vai trò (`role`), phân quyền động (`permission`), công ty (`company`), thống kê (`dashboard`) và nhật ký hoạt động (`log`).
2. **Tra cứu Hóa đơn & Thanh toán (`vn.haichaugroup.tintuc.qlkh`)**:
   - Đăng nhập khách hàng (`auth`), tra cứu chỉ số & hóa đơn tiền nước / hóa đơn bán hàng (`invoice`), xem & tải hóa đơn điện tử VNPT XML/PDF (`vnpt`).
   - Tra cứu lịch sử thanh toán (`payment`), tạo mã QR thanh toán VietQR (`qrpayment`) và Payoo Paybill (`paybill`), quản trị danh sách hóa đơn & tuyến đường (`invoiceadmin`, `road`).

---

## Danh sách toàn bộ API đang hoạt động (20 Controllers — 79 Endpoints)

### PHẦN I: WEBSITE TIN TỨC & QUẢN TRỊ HỆ THỐNG (`feature`)

#### 1. Xác thực Quản trị viên (`AuthController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/auth/login` | Public | Đăng nhập quản trị viên / nhân viên |
| `POST` | `/api/v1/auth/register` | Public | Đăng ký tài khoản mới |
| `POST` | `/api/v1/auth/refresh` | Public | Làm mới Access Token bằng Refresh Token |
| `POST` | `/api/v1/auth/logout` | JWT | Đăng xuất & thu hồi Refresh Token |
| `GET` | `/api/v1/auth/me` | JWT | Lấy thông tin tài khoản đang đăng nhập |

#### 2. Bài viết Tin tức (`ArticleController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/articles` | Public | Lọc & phân trang danh sách bài viết |
| `GET` | `/api/v1/articles/{id}` | Public | Xem chi tiết bài viết theo ID |
| `GET` | `/api/v1/articles/slug/{slug}` | Public | Xem chi tiết bài viết theo Slug |
| `POST` | `/api/v1/articles/slug/{slug}/view` | Public | Tăng lượt xem bài viết theo Slug |
| `GET` | `/api/v1/articles/search` | Public | Tìm kiếm bài viết theo từ khóa |
| `GET` | `/api/v1/articles/{id}/related` | Public | Lấy danh sách bài viết liên quan |
| `POST` | `/api/v1/articles` | RBAC | Tạo bài viết mới |
| `PUT` | `/api/v1/articles` | RBAC | Cập nhật bài viết |
| `DELETE` | `/api/v1/articles/{id}` | RBAC | Xóa bài viết |

#### 3. Danh mục Tin tức (`CategoryController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/categories` | Public | Lọc & phân trang danh mục |
| `GET` | `/api/v1/categories/roots` | Public | Lấy danh sách danh mục gốc (cấp 1) |
| `GET` | `/api/v1/categories/tree` | Public | Lấy toàn bộ cây danh mục đa cấp |
| `GET` | `/api/v1/categories/{id}` | Public | Lấy chi tiết danh mục theo ID |
| `GET` | `/api/v1/categories/{id}/tree` | Public | Lấy cây danh mục con từ một ID |
| `GET` | `/api/v1/categories/{id}/children` | Public | Lấy danh mục con trực tiếp (1 cấp) |
| `GET` | `/api/v1/categories/parent/{parentId}` | Public | Lấy danh mục con trực tiếp theo `parentId` |
| `GET` | `/api/v1/categories/{id}/articles` | Public | Lấy bài viết thuộc danh mục (bao gồm cả cây con) |
| `GET` | `/api/v1/categories/slug/{slug}` | Public | Lấy thông tin danh mục theo Slug |
| `GET` | `/api/v1/categories/slug/{slug}/articles` | Public | Lấy bài viết theo Slug danh mục |
| `GET` | `/api/v1/categories/search` | Public | Tìm kiếm danh mục theo tên |
| `POST` | `/api/v1/categories` | RBAC | Tạo danh mục mới |
| `PUT` | `/api/v1/categories` | RBAC | Cập nhật danh mục |
| `DELETE` | `/api/v1/categories/{id}` | RBAC | Xóa danh mục |

#### 4. Thẻ / Tags (`TagController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/tags` | Public | Lọc & phân trang danh sách Tag |
| `GET` | `/api/v1/tags/{id}` | Public | Chi tiết Tag theo ID |
| `GET` | `/api/v1/tags/{id}/articles` | Public | Lấy danh sách bài viết gắn Tag |
| `POST` | `/api/v1/tags` | RBAC | Tạo Tag mới |
| `PUT` | `/api/v1/tags` | RBAC | Cập nhật Tag |
| `DELETE` | `/api/v1/tags/{id}` | RBAC | Xóa Tag |

#### 5. Tài liệu đính kèm bài viết (`DocumentController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/documents` | RBAC | Lọc & phân trang tài liệu |
| `GET` | `/api/v1/documents/article/{articleId}` | RBAC | Lấy tài liệu đính kèm theo bài viết |
| `GET` | `/api/v1/documents/{id}` | RBAC | Xem chi tiết tài liệu |
| `POST` | `/api/v1/documents` | RBAC | Thêm tài liệu mới |
| `PUT` | `/api/v1/documents` | RBAC | Cập nhật tài liệu |
| `DELETE` | `/api/v1/documents/{id}` | RBAC | Xóa tài liệu |

#### 6. Thư viện Media & Upload File (`MediaController` & `FileController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/media` | Public | Danh sách file trong thư viện Media |
| `GET` | `/api/v1/media/{id}` | Public | Chi tiết 1 file Media |
| `POST` | `/api/v1/media` | RBAC | Upload file vào thư viện Media |
| `DELETE` | `/api/v1/media/{id}` | RBAC | Xóa file Media |
| `PATCH` | `/api/v1/media/move` | JWT | Di chuyển file Media sang thư mục khác |
| `GET` | `/api/v1/media/folders` | JWT | Lấy danh sách thư mục Media |
| `POST` | `/api/v1/media/folders` | JWT | Tạo thư mục Media mới |
| `PUT` | `/api/v1/media/folders/{id}` | JWT | Đổi tên/cập nhật thư mục Media |
| `DELETE` | `/api/v1/media/folders/{id}` | JWT | Xóa thư mục Media |
| `POST` | `/api/v1/files` | RBAC | Upload file trực tiếp theo thư mục (`avatars`, `logos`, `thumbnails`, `media`) |

#### 7. Quản lý Người dùng, Vai trò, Quyền hạn, Công ty & Dashboard
| Controller | Endpoints |
| :--- | :--- |
| `UserController` | `GET / POST / PUT /api/v1/users`, `GET / DELETE /api/v1/users/{id}` |
| `RoleController` | `GET / POST / PUT /api/v1/roles`, `GET / DELETE /api/v1/roles/{id}` |
| `PermissionController` | `GET / POST / PUT /api/v1/permissions`, `GET / DELETE /api/v1/permissions/{id}` |
| `CompanyController` | `GET / POST / PUT /api/v1/companies`, `GET / DELETE /api/v1/companies/{id}` |
| `DashboardController` | `GET /api/v1/dashboard` |

---

### PHẦN II: TRA CỨU HÓA ĐƠN & THANH TOÁN (`qlkh`)

#### 1. Xác thực Khách hàng tra cứu (`QlkhAuthController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/qlkh/auth/login` | Public | Khách hàng đăng nhập bằng Mã KH (`digiCode`) + SĐT |
| `POST` | `/api/v1/qlkh/auth/refresh` | Public | Làm mới token khách hàng |
| `POST` | `/api/v1/qlkh/auth/logout` | Public | Đăng xuất khách hàng |
| `GET` | `/api/v1/qlkh/customers/me` | JWT KH | Xem thông tin khách hàng đang đăng nhập |

#### 2. Tra cứu Hóa đơn & Hóa đơn điện tử VNPT (`QlkhInvoiceController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/qlkh/month-invoices/readings` | Public | Tra cứu chỉ số nước theo kỳ (`yearMonth`) |
| `GET` | `/api/v1/qlkh/month-invoices/consumption-history` | Public | Lịch sử sản lượng tiêu thụ theo mã KH |
| `GET` | `/api/v1/qlkh/invoices` | JWT KH | Danh sách hóa đơn tiền nước của khách hàng |
| `GET` | `/api/v1/qlkh/invoices/{invoiceId}` | JWT KH | Chi tiết hóa đơn tiền nước |
| `GET` | `/api/v1/qlkh/invoices/by-fkey` | JWT KH | Tra cứu hóa đơn theo `fkey` |
| `GET` | `/api/v1/qlkh/invoices/by-root-key` | JWT KH | Tra cứu hóa đơn theo `rootKey` |
| `GET` | `/api/v1/qlkh/invoices/{invoiceId}/e-invoice-view` | JWT KH | Xem chi tiết hóa đơn điện tử VNPT |
| `GET` | `/api/v1/qlkh/invoices/{invoiceId}/e-invoice-download` | JWT KH | Tải file XML/ZIP hóa đơn điện tử VNPT |
| `GET` | `/api/v1/qlkh/invoices/{invoiceId}/e-invoice-download-pdf` | JWT KH | Tải file PDF hóa đơn điện tử VNPT |
| `GET` | `/api/v1/qlkh/invoices/e-invoice-list` | JWT KH | Lấy danh sách hóa đơn điện tử từ VNPT Portal |
| `GET` | `/api/v1/qlkh/sales-invoices` | JWT KH | Danh sách hóa đơn bán hàng/lắp đặt |
| `GET` | `/api/v1/qlkh/sales-invoices/{salesInvoiceId}` | JWT KH | Chi tiết hóa đơn bán hàng |
| `GET` | `/api/v1/qlkh/vnpt/health` | JWT KH | Kiểm tra kết nối SOAP VNPT PortalService |

#### 3. Tra cứu Lịch sử Thanh toán & Tạo mã QR (`QlkhPaymentController`, `PaybillQrController`, `ExternalQrController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/qlkh/payments/my-history` | JWT KH | Lịch sử thanh toán của khách hàng |
| `GET` | `/api/v1/qlkh/admin/payments/lines` | RBAC | Admin tra cứu lịch sử giao dịch thanh toán |
| `POST` | `/api/v1/qlkh/paybill/qr` | Public | Tạo mã QR thanh toán qua Payoo Paybill |
| `POST` | `/api/v1/external/qr-payment/generate` | API Key | Tạo mã VietQR thanh toán cho hệ thống tích hợp ngoài |

#### 4. Quản trị Hóa đơn, Tuyến đường & Bài viết KH (`InvoiceAdminController`, `RoadAdminController`, `QlkhArticleController`)
| Method | Endpoint | Quyền | Mô tả |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/admin/invoices` | RBAC | Admin tra cứu & lọc danh sách hóa đơn theo kỳ, tuyến đường, trạng thái thanh toán (kèm link VietQR) |
| `GET` | `/api/v1/admin/roads` | RBAC | Lấy danh sách tuyến đường (`SupportingTable`) phục vụ bộ lọc hóa đơn |
| `GET` | `/api/v1/qlkh/customer/articles/maintenance` | Public | Lấy danh sách bài viết thông báo bảo trì / cúp nước |
| `GET` | `/api/v1/qlkh/customer/articles/featured` | Public | Lấy danh sách bài viết nổi bật cho khách hàng |

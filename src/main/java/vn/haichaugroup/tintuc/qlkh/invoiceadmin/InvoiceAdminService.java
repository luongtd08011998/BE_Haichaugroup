package vn.haichaugroup.tintuc.qlkh.invoiceadmin;

import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import org.springframework.data.domain.Pageable;
import vn.haichaugroup.tintuc.qlkh.invoiceadmin.dto.AdminInvoiceFilterRequest;

public interface InvoiceAdminService {
    ResultPaginationDTO getAll(AdminInvoiceFilterRequest filter, Pageable pageable);
}

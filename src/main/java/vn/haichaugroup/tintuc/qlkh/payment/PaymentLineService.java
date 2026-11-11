package vn.haichaugroup.tintuc.qlkh.payment;

import org.springframework.data.domain.Pageable;
import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.qlkh.customer.Customer;

public interface PaymentLineService {

    /**
     * Lấy lịch sử thanh toán của khách hàng hiện tại (phân trang).
     */
    ResultPaginationDTO getPaymentHistory(Customer customer, Pageable pageable);

    /**
     * Tra cứu danh sách dòng thanh toán cho Admin (phân trang, lọc theo customerId, yearMonth).
     */
    ResultPaginationDTO getAdminPaymentLines(Integer customerId, String yearMonth, Pageable pageable);
}

package vn.haichaugroup.tintuc.qlkh.invoiceadmin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.qlkh.invoice.MonthInvoiceRepository;
import vn.haichaugroup.tintuc.qlkh.invoiceadmin.dto.AdminInvoiceFilterRequest;
import vn.haichaugroup.tintuc.qlkh.invoiceadmin.dto.AdminInvoiceResponse;
import vn.haichaugroup.tintuc.qlkh.qrpayment.VietQrService;

import java.util.Collections;
import java.util.List;

@Service
public class InvoiceAdminServiceImpl implements InvoiceAdminService {

    private final MonthInvoiceRepository monthInvoiceRepository;
    private final VietQrService vietQrService;

    public InvoiceAdminServiceImpl(MonthInvoiceRepository monthInvoiceRepository,
                                   VietQrService vietQrService) {
        this.monthInvoiceRepository = monthInvoiceRepository;
        this.vietQrService = vietQrService;
    }

    @Override
    public ResultPaginationDTO getAll(AdminInvoiceFilterRequest filter, Pageable pageable) {
        String yearMonth = (filter != null && filter.getYearMonth() != null) ? filter.getYearMonth().trim() : null;

        if (yearMonth == null || yearMonth.isBlank()) {
            ResultPaginationDTO.Meta meta = new ResultPaginationDTO.Meta(
                    pageable.getPageNumber() + 1,
                    pageable.getPageSize(),
                    0,
                    0);
            return new ResultPaginationDTO(meta, Collections.emptyList());
        }

        Integer paymentStatus = (filter != null) ? filter.getPaymentStatus() : null;
        String keyword = (filter != null) ? filter.getDigiCode() : null;
        if (keyword == null || keyword.isEmpty()) {
            keyword = (filter != null) ? filter.getCustomerName() : null;
        }
        Integer remindStatus = (filter != null) ? filter.getRemindStatus() : null;
        Integer roadId = (filter != null) ? filter.getRoadId() : null;
        Integer invoiceNotifyStatus = (filter != null) ? filter.getInvoiceNotifyStatus() : null;
        Integer paymentNotifyStatus = (filter != null) ? filter.getPaymentNotifyStatus() : null;
        Integer invStatus = (filter != null) ? filter.getInvStatus() : null;

        List<Integer> emptyIds = List.of(-1);

        Page<AdminInvoiceResponse> page = monthInvoiceRepository.findAdminInvoices(
                yearMonth,
                paymentStatus,
                keyword,
                remindStatus,
                roadId,
                emptyIds,
                emptyIds,
                emptyIds,
                emptyIds,
                invoiceNotifyStatus,
                invStatus,
                emptyIds,
                paymentNotifyStatus,
                pageable);

        List<AdminInvoiceResponse> content = page.getContent();
        for (AdminInvoiceResponse res : content) {
            res.setIsReminded(false);
            res.setIsOverdue(false);
            res.setIsWaterCutoff(false);
            res.setIsInvoiceNotified(false);
            res.setIsPaymentNotified(false);

            if (res.getPaymentStatus() != null && res.getPaymentStatus() != 2
                    && res.getTotalAmount() != null && res.getTotalAmount() > 0) {
                res.setQrUrl(vietQrService.buildQrUrl(
                        res.getDigiCode(), res.getYearMonth(), res.getTotalAmount()));
            }
        }

        return ResultPaginationDTO.fromPage(page);
    }
}

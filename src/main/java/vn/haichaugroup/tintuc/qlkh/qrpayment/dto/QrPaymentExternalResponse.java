package vn.haichaugroup.tintuc.qlkh.qrpayment.dto;

public record QrPaymentExternalResponse(
    String fkey,
    String customerCode,
    String yearMonth,
    Double totalAmount,
    String qrUrl,
    String addInfo
) {}

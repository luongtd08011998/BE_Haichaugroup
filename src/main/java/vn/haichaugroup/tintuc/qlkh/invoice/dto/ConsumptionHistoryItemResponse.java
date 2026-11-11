package vn.haichaugroup.tintuc.qlkh.invoice.dto;

public record ConsumptionHistoryItemResponse(
        String yearMonth,
        Integer oldVal,
        Integer newVal,
        Integer consumptionM3) {
}

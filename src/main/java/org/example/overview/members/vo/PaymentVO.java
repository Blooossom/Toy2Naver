package org.example.overview.members.vo;

import java.util.Objects;

public class PaymentVO {
    String oId = "";
    String orderType = "";
    String orderDate = "";
    String amount = "";
    String get_nPoint = "";
    String use_nPoint = "";

    public PaymentVO(){
    }

    public PaymentVO(String oId, String orderType, String orderDate, String amount, String get_nPoint, String use_nPoint) {
        this.oId = oId;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.amount = amount;
        this.get_nPoint = get_nPoint;
        this.use_nPoint = use_nPoint;
    }

    public String getoId() {
        return oId;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getAmount() {
        return amount;
    }

    public String getGet_nPoint() {
        return get_nPoint;
    }

    public String getUse_nPoint() {
        return use_nPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentVO paymentVO = (PaymentVO) o;
        return Objects.equals(oId, paymentVO.oId) && Objects.equals(orderType, paymentVO.orderType) && Objects.equals(orderDate, paymentVO.orderDate) && Objects.equals(amount, paymentVO.amount) && Objects.equals(get_nPoint, paymentVO.get_nPoint) && Objects.equals(use_nPoint, paymentVO.use_nPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, orderType, orderDate, amount, get_nPoint, use_nPoint);
    }

    @Override
    public String toString() {
        return "PaymentVO{" +
                "oId='" + oId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", amount='" + amount + '\'' +
                ", get_nPoint='" + get_nPoint + '\'' +
                ", use_nPoint='" + use_nPoint + '\'' +
                '}';
    }
}

package org.example.overview.members.dto;

import org.example.overview.members.entity.Payment;
import org.example.overview.members.vo.PaymentVO;

public class PaymentDTO {
    String oId = "";
    String orderType = "";
    String orderDate = "";
    String amount = "";
    String get_nPoint = "";
    String use_nPoint = "";

    public PaymentDTO(){
    }

    public PaymentDTO(String oId, String orderType, String orderDate, String amount, String get_nPoint, String use_nPoint) {
        this.oId = oId;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.amount = amount;
        this.get_nPoint = get_nPoint;
        this.use_nPoint = use_nPoint;
    }
    public PaymentVO toVO(){
        return new PaymentVO(oId,orderType,orderDate,amount,get_nPoint,use_nPoint);
    }
    public Payment toEntity(){
        return new Payment(oId,orderType,orderDate,amount,get_nPoint,use_nPoint);
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGet_nPoint() {
        return get_nPoint;
    }

    public void setGet_nPoint(String get_nPoint) {
        this.get_nPoint = get_nPoint;
    }

    public String getUse_nPoint() {
        return use_nPoint;
    }

    public void setUse_nPoint(String use_nPoint) {
        this.use_nPoint = use_nPoint;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "oId='" + oId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", amount='" + amount + '\'' +
                ", get_nPoint='" + get_nPoint + '\'' +
                ", use_nPoint='" + use_nPoint + '\'' +
                '}';
    }
}

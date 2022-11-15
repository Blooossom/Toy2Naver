package org.example.overview.members.entity;

import org.example.overview.members.controller.login.PayhomeController;
import org.example.overview.members.dto.PaymentDTO;

public class Payment {
    String oId = "";
    String orderType = "";
    String orderDate = "";
    String amount = "";
    String get_nPoint = "";
    String user_nPoint = "";

    public Payment(){
    }

    public Payment(String oId, String orderType, String orderDate, String amount, String get_nPoint, String user_nPoint) {
        this.oId = oId;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.amount = amount;
        this.get_nPoint = get_nPoint;
        this.user_nPoint = user_nPoint;
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

    public String getUser_nPoint() {
        return user_nPoint;
    }
    public PaymentDTO toDTO(){
        return new PaymentDTO(oId,orderType,orderDate,amount,get_nPoint,user_nPoint);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "oId='" + oId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", amount='" + amount + '\'' +
                ", get_nPoint='" + get_nPoint + '\'' +
                ", user_nPoint='" + user_nPoint + '\'' +
                '}';
    }
}

package org.example.overview.members.dao;

import org.example.overview.members.database.JDBCMgr;
import org.example.overview.members.entity.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PaymentDAO implements IPaymentDAO{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String PAYMENT_SELECT = "select * from payment where oId = ?";
    private static final String PAYMENT_DELETE = "delete payment where oId=?";

    @Override
    public Payment select(String Id){
        Payment payment = null;
        try{
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PAYMENT_SELECT);
            stmt.setString(1,Id);

            rs=stmt.executeQuery();
            if(rs.next()){
                String oId = rs.getString("oId");
                String orderType = rs.getString("orderType");
                String orderDate = rs.getString("orderDate");
                String amount = rs.getString("amount");
                String get_nPoint=rs.getNString("get_nPoint");
                String use_nPoint = rs.getNString("use_nPoint");
                payment=new Payment(oId,orderType,orderDate,amount,get_nPoint,use_nPoint);
            }
            conn.commit();
        }catch (SQLException err){
            err.printStackTrace();
        }catch (Exception err){
            err.printStackTrace();
        }finally {
            JDBCMgr.close(rs,stmt,conn);
        }
        return payment;
    }
    @Override
    public int delete(String id){
        int res = 0;
        try{
            conn = JDBCMgr.getConnection();
            stmt= conn.prepareStatement(PAYMENT_DELETE);
            stmt.setString(1,id);
            res=stmt.executeUpdate();
            conn.commit();
        }catch (SQLException err){
            err.printStackTrace();
        }catch (Exception err){
            err.printStackTrace();
        }finally {
            JDBCMgr.close(rs,stmt,conn);
        }
        return res;
    }
}

package org.example.overview.members.dao;

import org.example.overview.members.database.JDBCMgr;
import org.example.overview.members.entity.Prod;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ProdDAO implements IProdDAO{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String PROD_SELECT_ALL="select * from PRODUCT where uId=?";
    private static final String PROD_SELECT = "select * from PRODUCT where oId=?";
    private static final String PROD_SEARCH_DATE = "select*from PRODUCT where orderDate between cast(? as DATE)and cast(? as DATE)";
    private static final String PROD_INSERT="insert into PRODUCT values?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String PROD_DELETE = "?";
    private static final String PROD_DELETE_ALL = "?";

    @Override
    public List<Prod> selectAll(String uId){
        List<Prod> prodList = new LinkedList<>();

        try{
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_SELECT_ALL);
            stmt.setString(1,uId);

            rs = stmt.executeQuery();
            while(rs.next()){
                prodList.add(new Prod(
                        rs.getString("oId"),
                        rs.getString("uId"),
                        rs.getString("orderDate"),
                        rs.getString("productName"),
                        rs.getString("amount"),
                        rs.getString("status"),
                        rs.getString("company"),
                        rs.getString("companyTel")));
            }
        }catch (SQLException err){
            err.printStackTrace();
    }finally {
            JDBCMgr.close(rs,stmt,conn);
        }
        return prodList;
        }
}

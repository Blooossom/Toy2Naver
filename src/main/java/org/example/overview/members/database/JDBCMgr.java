package org.example.overview.members.database;
import java.sql.*;
public class JDBCMgr {
    private JDBCMgr(){}
    public static Connection getConnection(){
        Connection conn = null;

        try{
            DriverManager.registerDriver((new org.h2.Driver()));
            conn=DriverManager.getConnection("jdbc:h2~/NaverPayTeam2","sa","");
        }catch (SQLException err){
            err.printStackTrace();
        }
        return conn;
    }
    public static void close(PreparedStatement stmt, Connection conn){
        try{
            stmt.close();
        }catch (SQLException err){
            err.printStackTrace();
        }
        try{
            conn.close();
        }catch (SQLException err){
            err.printStackTrace();
        }
    }
    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn){
        try{
            rs.close();
        }catch (SQLException err){
            err.printStackTrace();
        }
        close(stmt,conn);
    }
}

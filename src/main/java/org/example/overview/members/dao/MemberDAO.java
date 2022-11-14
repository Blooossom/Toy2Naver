package org.example.overview.members.dao;

import org.example.overview.members.database.JDBCMgr;
import org.example.overview.members.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MemberDAO implements IMemberDAO{
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;

    private static final String MEMBER_SELECT="select * from MEMBER where uId=?";
    private static final String MEMBER_SELECT_ALL = "select * from MEMBER";
    private static final String MEMBER_INSERT = "insert into MEMBER value(?,?,?,?)";

    public Member select(String inputId){
        Member member = null;
        try{
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setString(1, inputId);

            rs=stmt.executeQuery();
            if(rs.next()){
                String uId = rs.getString("uId");
                String uPw = rs.getString("uEmail");
                String uEmail = rs.getString("uEmail");
                String uPhoneNumber = rs.getString("uPhoneNumbmer");
                member = new Member(uId,uPw,uEmail,uPhoneNumber);
            }
        }catch (SQLException err){
            err.printStackTrace();
        }finally{
            JDBCMgr.close(rs,stmt,conn);
        }
        return member;
    }

    public List<Member> selectAll(){
        List<Member> members = new LinkedList<>();
        try{
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT_ALL);

            rs=stmt.executeQuery();
            while(rs.next()){
                String uId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");
                String uPhoneNumber = rs.getString("uPhoneNumber");
                members.add(new Member(uId,uPw,uEmail,uPhoneNumber));
            }
        }catch (SQLException err){
            err.printStackTrace();
        }finally{
            JDBCMgr.close(rs,stmt,conn);
        }
        return members;
    }
    public int insert(Member member){
        int count = 0;
        try{
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);

            stmt.setString(1, member.getuId());
            stmt.setString(2, member.getuPw());
            stmt.setString(3, member.getuEmail());
            stmt.setString(4,member.getuPhoneNumber());
            count = stmt.executeUpdate();
        }catch (SQLException err){
            err.printStackTrace();;
        }finally {
            JDBCMgr.close(stmt,conn);
        }
        return count;
    }
}

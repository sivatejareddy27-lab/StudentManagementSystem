package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public int addStudent(StudentBean sb) 
    		throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement("insert into Students values(?,?,?,?,?,?)");
        ps.setString(1, sb.getSid());
        ps.setString(2, sb.getSname());
        ps.setString(3, sb.getEmail());
        ps.setLong(4, sb.getPhno());
        ps.setString(5, sb.getCourse());
        ps.setString(6, sb.getAddr());
        return ps.executeUpdate();
    }

    public List<StudentBean> viewStudents() throws Exception {
        Connection con = DBConnection.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Students");
        List<StudentBean> list = new ArrayList<>();
        while(rs.next()) {
            StudentBean sb = new StudentBean();
            sb.setSid(rs.getString(1));
            sb.setSname(rs.getString(2));
            sb.setEmail(rs.getString(3));
            sb.setPhno(rs.getLong(4));
            sb.setCourse(rs.getString(5));
            sb.setAddr(rs.getString(6));
            list.add(sb);
        }
        return list;
    }

    public int deleteStudent(String sid) throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(
            "delete from Students where sid=?");
        ps.setString(1, sid);
        return ps.executeUpdate();
    }

    public int updateStudent(StudentBean sb) throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(
            "update Students set sname=?,email=?,phone=?,course=?,addr=? where sid=?");
        ps.setString(1, sb.getSname());
        ps.setString(2, sb.getEmail());
        ps.setLong(3, sb.getPhno());
        ps.setString(4, sb.getCourse());
        ps.setString(5, sb.getAddr());
        ps.setString(6, sb.getSid());
        return ps.executeUpdate();
    }


	}
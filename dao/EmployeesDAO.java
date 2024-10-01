/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.EmployeesPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rj851
 */
public class EmployeesDAO {
    public static boolean addNewEmp(EmployeesPOJO emp)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employees values(?,?,?,?)");
        ps.setInt(1,emp.getEmpNo());
        ps.setString(2, emp.getEmpName());
        ps.setDouble(3, emp.getEmpSal());
        ps.setInt(4, emp.getDeptno());
        int ans =ps.executeUpdate();
        return ans==1;
        
    }
    public static EmployeesPOJO getEmployeebyempno(int emNO)throws SQLException{
        Connection conn  =DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("select *from employees where empno=?");
        ps.setInt(1, emNO);
        ResultSet rs =ps.executeQuery();
        EmployeesPOJO emp=null;
        if(rs.next()){
            emp=new EmployeesPOJO();
            emp.setEmpNo(rs.getInt(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpSal(rs.getDouble(3));
            emp.setDeptno(rs.getInt(4));

        }
        return  emp;
    }
    public static List<EmployeesPOJO> getAllEmp()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from employees");
        List<EmployeesPOJO> emplist =new ArrayList<>();
        while (rs.next()) {            
            EmployeesPOJO emp =new EmployeesPOJO();
            emp.setEmpNo(rs.getInt(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpSal(rs.getDouble(3));
            emp.setDeptno(rs.getInt(4));
            emplist.add(emp);
        }
        return emplist;
    }
    public static boolean updateEmp(EmployeesPOJO emp)throws SQLException{
        Connection conn =DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("Update employees set ename =?,sal=?,deptno=? where empno =? ");
         ps.setString(1,emp.getEmpName());
         ps.setDouble(2, emp.getEmpSal());
         ps.setInt(3, emp.getDeptno());
         ps.setInt(4, emp.getEmpNo());
         int ans =ps.executeUpdate();
         return ans==1;
    }
    public static boolean delete(int empNO)throws SQLException{
        Connection conn =DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("delete from employees where empno =? ");
         ps.setInt(1,empNO);
         int ans =ps.executeUpdate();
         return ans==1;
    }
}

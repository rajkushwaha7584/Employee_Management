/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author rj851
 */
public class EmployeesPOJO {

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public EmployeesPOJO() {
    }

    public EmployeesPOJO(int empNo, String empName, double empSal, int deptno) {
        this.empNo = empNo;
        this.empName = empName;
        this.empSal = empSal;
        this.deptno = deptno;
    }
    private int empNo;
    private String empName;
    private double empSal;
    private int deptno;
    
}

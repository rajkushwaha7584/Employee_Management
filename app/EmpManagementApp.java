/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.app;

import empmgmt.dao.EmployeesDAO;
import empmgmt.pojo.EmployeesPOJO;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rj851
 */
public class EmpManagementApp {
  static Scanner kb;
    public static void main(String[] args) {
       kb =new Scanner(System.in);
        int choice;
        do{ 
            System.out.println("1. Add new emp\n2. search employees\n3. Show all enp\n4. update emp\n5. Delete emp\n6. Quit");
            System.out.println("Select an option");
            choice =kb.nextInt();
            switch(choice){
                case 1:
                    addNewEmp();
                    break;
                case 2:
                    searchEmp();
                    break;
                case 3:
                    showAllEmp();
                    break;
                case 4:
                    updateEmp();
                    break;
                case 5:
                    deleteEmp();
                    break;
                case 6:
                    System.out.println("Thank you for using the app");
                    System.out.println("===========================>");
                    break;
                default:
                    System.out.println("Wrong choice ! try again ....");
                    System.out.println("========================>");
            }
        }while(choice!=6);
    }
    public static void addNewEmp(){
      
        try {
            System.out.println("Enter empno : ");
            int eno=kb.nextInt();
            
            System.out.println("Enter employees name : ");
            kb.nextLine();
            String ename =kb.nextLine();
            
            System.out.println("Enter salary : ");
            Double sal=kb.nextDouble();
            
            System.out.println("Enter Deptno: ");
            int dno=kb.nextInt();
            
            EmployeesPOJO emp=new EmployeesPOJO(eno,ename,sal,dno);
            boolean result = EmployeesDAO.addNewEmp(emp);
            System.out.println(result==true?"Recorde inserted ":"Recorde not Inserted");
            System.out.println("===================");
        } catch (SQLException ex) {
            System.out.println("Exception cannt add the rec :"+ex.getMessage());
            
        }
    }

    private static void searchEmp() {
        try {
            System.out.println("Enter empno for Searching : ");
            int eno =kb.nextInt();
            EmployeesPOJO emp= EmployeesDAO.getEmployeebyempno(eno);
            if (emp==null) {
                System.out.println("No record  of employee no :"+ eno+" found in the DB: ");
            } else {
                System.out.println("Empno:"+emp.getEmpNo());
                System.out.println("EmpName:"+emp.getEmpName());
                System.out.println("Salary:"+emp.getEmpSal());
                System.out.println("DempNo:"+emp.getDeptno());
                System.out.println("===========================");
            }
        } catch (Exception e) {
            System.out.println("Exception cannot added the rec :"+e.getMessage());
        }
    }

    private static void showAllEmp() {
        try {
            List <EmployeesPOJO> empList=EmployeesDAO.getAllEmp();
            if (empList.size()==0) {
                System.out.println("Sorry ! No rec in the DB: ");
                
            } else {
                for(EmployeesPOJO emp:empList){
                    System.out.print("Empno:"+emp.getEmpNo());
                    System.out.print(" EmpName:"+emp.getEmpName());
                    System.out.print(" Salary:"+emp.getEmpSal());
                    System.out.println(" DempNo:"+emp.getDeptno());
                    System.out.println("==============================================================================");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception cannot added the rec :"+e.getMessage());
        }
    }

    private static void updateEmp() {
        try {
            System.out.println("Enter empno whose rec is to be updated : ");
            int eno=kb.nextInt();
            
            System.out.println("Enter NEW employees name : ");
            kb.nextLine();
            String ename =kb.nextLine();
            
            System.out.println("Enter NEW salary : ");
            Double sal=kb.nextDouble();
            
            System.out.println("Enter NEW Deptno: ");
            int dno=kb.nextInt();
            
             EmployeesPOJO emp=new EmployeesPOJO(eno,ename,sal,dno);
             boolean result = EmployeesDAO.updateEmp(emp);
            System.out.println(result==true?"Recorde updated ":"Recorde not found");
            System.out.println("==============================================================");
        } catch (Exception e) {
            System.out.println("Exception cannot update the rec :"+e.getMessage());
        }
    }

    private static void deleteEmp() {
            try {
            System.out.println("Enter empno whose rec is to be deleted : ");
            int eno=kb.nextInt();
          
            boolean result = EmployeesDAO.delete(eno);
            System.out.println(result==true?"Recorde deleted ":"Recorde not found");
            System.out.println("=================>");
            } catch (Exception e) {
            System.out.println("Exception cannot deleted the rec :"+e.getMessage());
        }
    }
}


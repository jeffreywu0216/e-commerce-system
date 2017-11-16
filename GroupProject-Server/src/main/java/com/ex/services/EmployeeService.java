package com.ex.services;

//import com.jeff.data.dao.Dao;
//import com.jeff.data.dao.impl.EmployeeDao;
//import com.jeff.domain.Employee;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.sql.SQLException;
//import java.util.List;

public class EmployeeService {
//    private Dao<Employee, Integer> dao = new EmployeeDao();
//    private  final Logger logger = LogManager.getLogger(EmployeeService.class);
//
//    public Employee findOne(Integer id) {
//        logger.trace("Entering EmployeeService findOne()");
//        if (id == null) {
//            return null;
//        }
//        try {
//            return dao.findOne(id);
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting EmployeeService findOne()");
//        }
//        return null;
//    }
//
//    public List<Employee> getAll() {
//        logger.trace("Entering EmployeeService getAll()");
//        List<Employee> list = null;
//        try {
//            list = dao.getAll();
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting EmployeeService findOne()");
//        }
//        return list;
//    }
//
//
//    public boolean updateInfo(int empId, String lastName, String firstName, String address, String phone, String email, String pswd) {
//        logger.trace("Entering EmployeeService getAll()");
//        try {
//            if (lastName == null && firstName == null && address == null && phone == null && email == null && pswd == null){
//                logger.trace("Invalid Input: All null values ");
//                return false;
//            }
//            ((EmployeeDao)dao).updateInfo(empId, lastName, firstName, address, phone, email, pswd);
//        } catch (SQLException e) {
//            logger.error(e);
//
//            return false;
//        } finally {
//            logger.trace("Exiting EmployeeService findOne()");
//        }
//        return true;
//    }
//
//    public Employee login(String email, String pswd) {
//        logger.trace("Entering EmployeeService login()");
//        if (email == null || pswd == null) {
//            return null;
//        }
//        try {
//            Employee emp = ((EmployeeDao)dao).login(email, pswd);
//            return emp;
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting EmployeeService login()");
//        }
//        return null;
//    }
}

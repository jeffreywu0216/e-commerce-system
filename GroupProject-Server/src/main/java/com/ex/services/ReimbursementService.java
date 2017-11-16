package com.ex.services;

//import com.jeff.data.dao.Dao;
//import com.jeff.data.dao.impl.ReimbursementDao;
//import com.jeff.domain.Employee;
//import com.jeff.domain.Reimbursement;
//import com.jeff.domain.ReimbursementType;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.sql.SQLException;
//import java.util.List;

public class ReimbursementService {
//    private Dao<Reimbursement, Integer> dao = new ReimbursementDao();
//    private final Logger logger = LogManager.getLogger(ReimbursementService.class);
//
//    public List<Reimbursement> getAll() {
//        logger.trace("Entering ReimbursementService getAll()");
//        try {
//            return dao.getAll();
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting ReimbursementService getAll()");
//        }
//        return null;
//    }
//
//    public Reimbursement findOne(Integer id) {
//        logger.trace("Entering ReimbursementService findOne(" + id + ")");
//
//        try {
//            if (id == null) {
//                return null;
//            }
//            return dao.findOne(id);
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting ReimbursementService findOne(" + id + ")");
//        }
//        return null;
//    }
//
//    public List<Reimbursement> getReimbursementByEmpId(int empId) {
//        logger.trace("Entering ReimbursementService getReimbursementByEmpId(" + empId + ")");
//
//        try {
//            return ((ReimbursementDao)dao).getReimbursementByEmpId(empId);
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting ReimbursementService getReimbursementByEmpId(" + empId + ")");
//        }
//        return null;
//    }
//
//    public List<Reimbursement> getPendingReimbursement() {
//        logger.trace("Entering ReimbursementService getPendingReimbursement()");
//
//        try {
//            return ((ReimbursementDao)dao).getPendingReimbursement();
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting ReimbursementService getPendingReimbursement()");
//        }
//        return null;
//    }
//
//    public List<Reimbursement> getPendingReimbursement(int empId) {
//        logger.trace("Entering ReimbursementService getPendingReimbursement(" + empId + ")");
//
//        try {
//            return ((ReimbursementDao)dao).getPendingReimbursement(empId);
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting ReimbursementService getPendingReimbursement(" + empId + ")");
//        }
//        return null;
//    }
//
//    public List<Reimbursement> getResolvedReimbursement() {
//        logger.trace("Entering ReimbursementService getResolvedReimbursement()");
//
//        try {
//            return ((ReimbursementDao)dao).getResolvedReimbursement();
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting ReimbursementService getResolvedReimbursement()");
//        }
//        return null;
//    }
//
//    public List<Reimbursement> getResolvedReimbursement(int empId) {
//        logger.trace("Entering ReimbursementService getResolvedReimbursement(" + empId + ")");
//
//        try {
//            return ((ReimbursementDao)dao).getResolvedReimbursement(empId);
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            logger.trace("Exiting ReimbursementService getResolvedReimbursement(" + empId + ")");
//        }
//        return null;
//    }
//
//    public boolean resolveReimbursement(int managerId, int id, int statusId) {
//        logger.trace("Entering ReimbursementService resolveReimbursement()");
//
//        try {
//            if (statusId != 2 && statusId != 3) {
//                logger.error("Wrong Status Id");
//                return false;
//            }
//
//            Employee emp = new EmployeeService().findOne(managerId);
//            if (emp == null || !emp.getTitle().equals("Manager")) {
//                logger.error("Wrong Manager Id");
//                return false;
//            }
//
//            Reimbursement re = findOne(id);
//            if (re == null || re.getReimbStatus() != 1) {
//                logger.error("Wrong Reimbursement Id");
//                return false;
//            }
//            ((ReimbursementDao)dao).resolveReimbursement(managerId, id, statusId);
//        } catch (SQLException e) {
//            logger.error(e);
//            return false;
//        } finally {
//            logger.trace("Exiting ReimbursementService resolveReimbursement()");
//
//        }
//        return true;
//    }
//
//    public boolean submitReimbursement(int empId, double amount, int typeId, String reason) {
//        logger.trace("Entering ReimbursementService submitReimbursement()");
//        try {
//            Employee emp = new EmployeeService().findOne(empId);
//            if (emp == null) {
//                logger.error("Wrong Employee Id");
//                return false;
//            }
//            if (amount <= 0) {
//                logger.error("Invalid amount");
//                return false;
//            }
//            ReimbursementType rt = new ReimbursementTypeService().findOne(typeId);
//            if (rt == null) {
//                logger.error("Error");
//                return false;
//            }
//            if (reason == null) {
//                reason = "";
//            }
//            return ((ReimbursementDao)dao).submitReimbursement(empId, amount, typeId, reason);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            logger.trace("Exiting ReimbursementService submitReimbursement()");
//        }
//    }
}

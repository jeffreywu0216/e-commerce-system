package com.ex.web;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jeff.domain.Reimbursement;
//import com.jeff.services.ReimbursementService;
//import com.jeff.web.utils.PrepareHttpReq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/reimbursement/*"})
public class ReimbursementServlet extends HttpServlet{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String[] arr = (String[]) req.getAttribute("urlParts");
//        if (arr[arr.length - 1].equals("pending") || (arr.length > 2 && arr[arr.length - 2].equals("pending"))) {
//            getPendingReimbursement(req, resp);
//        } else if (arr[arr.length - 1].equals("resolved") || (arr.length > 2 && arr[arr.length - 2].equals("resolved"))) {
//            getResolvedReimbursement(req, resp);
//        } else if(arr[arr.length - 1].equals("reimbursement") ||
//                arr[arr.length - 2].equals("reimbursement") ||
//                arr[arr.length - 2].equals("employee-id")){
//            getReimbursement(req, resp);
//        } else {
//            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        }
//    }
//
//    protected void getReimbursement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String[] arr = (String[]) req.getAttribute("urlParts");
//        ObjectMapper mapper = new ObjectMapper();
//
//        if(arr[arr.length - 1].equals("reimbursement")){
//            List<Reimbursement> list = new ReimbursementService().getAll();
//
//            resp.setStatus(HttpServletResponse.SC_OK);
//            resp.setHeader("Content-Type", "application/json");
//            resp.getWriter().write(mapper.writeValueAsString(list));
//
//        } else if (arr[arr.length - 2].equals("reimbursement")) {
//            try {
//                int id = Integer.parseInt(arr[arr.length - 1]);
//                Reimbursement reimbursement = new ReimbursementService().findOne(id);
//                if (reimbursement == null) {
//                    throw new Exception("Invalid Reimbursement Id Number");
//                }
//
//                resp.setStatus(HttpServletResponse.SC_OK);
//                resp.setHeader("Content-Type", "application/json");
//                resp.getWriter().write(mapper.writeValueAsString(reimbursement));
//            } catch (Exception e) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                int id = Integer.parseInt(arr[arr.length - 1]);
//                List<Reimbursement> list = new ReimbursementService().getReimbursementByEmpId(id);
//
//                resp.setStatus(HttpServletResponse.SC_OK);
//                resp.setHeader("Content-Type", "application/json");
//                resp.getWriter().write(mapper.writeValueAsString(list));
//            } catch (Exception e) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                e.printStackTrace();
//            }
//        }
//    }
//
//    protected void getPendingReimbursement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String[] arr = (String[]) req.getAttribute("urlParts");
//        ObjectMapper mapper = new ObjectMapper();
//
//        if(arr[arr.length - 1].equals("pending")){
//            List<Reimbursement> list = new ReimbursementService().getPendingReimbursement();
//
//            resp.setStatus(HttpServletResponse.SC_OK);
//            resp.setHeader("Content-Type", "application/json");
//            resp.getWriter().write(mapper.writeValueAsString(list));
//
//        } else {
//            try {
//                int id = Integer.parseInt(arr[arr.length - 1]);
//                List<Reimbursement> list = new ReimbursementService().getPendingReimbursement(id);
//
//                resp.setStatus(HttpServletResponse.SC_OK);
//                resp.setHeader("Content-Type", "application/json");
//                resp.getWriter().write(mapper.writeValueAsString(list));
//            } catch (Exception e) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                e.printStackTrace();
//            }
//        }
//    }
//
//    protected void getResolvedReimbursement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String[] arr = (String[]) req.getAttribute("urlParts");
//        ObjectMapper mapper = new ObjectMapper();
//
//        if(arr[arr.length - 1].equals("resolved")){
//            List<Reimbursement> list = new ReimbursementService().getResolvedReimbursement();
//
//            resp.setStatus(HttpServletResponse.SC_OK);
//            resp.setHeader("Content-Type", "application/json");
//            resp.getWriter().write(mapper.writeValueAsString(list));
//
//        } else {
//            try {
//                int id = Integer.parseInt(arr[arr.length - 1]);
//                List<Reimbursement> list = new ReimbursementService().getResolvedReimbursement(id);
//
//                resp.setStatus(HttpServletResponse.SC_OK);
//                resp.setHeader("Content-Type", "application/json");
//                resp.getWriter().write(mapper.writeValueAsString(list));
//            } catch (Exception e) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String[] arr = (String[]) req.getAttribute("urlParts");
//        ObjectMapper mapper = new ObjectMapper();
//        BufferedReader bufferedReader = req.getReader();
//        String[] data = PrepareHttpReq.bufferReaderToString(bufferedReader);
//
//        if (arr[arr.length - 1].equals("resolve")) {
//            try {
//                int managerId = Integer.parseInt(data[0].split(":")[1]);
//                int id = Integer.parseInt(data[1].split(":")[1]);
//                int statusId = Integer.parseInt(data[2].split(":")[1]);
//
//                if (new ReimbursementService().resolveReimbursement(managerId, id, statusId)) {
//                    resp.setStatus(HttpServletResponse.SC_OK);
//                } else {
//                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                }
//            } catch (NumberFormatException e) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            }
//        } else if (arr[arr.length - 1].equals("submit")) {
//            try {
//                int empId = Integer.parseInt(data[0].split(":")[1]);
//                double amount = Double.parseDouble(data[1].split(":")[1]);
//                int typeId = Integer.parseInt(data[2].split(":")[1]);
//                String reason = data[3].split(":")[1];
//
//                if (new ReimbursementService().submitReimbursement(empId, amount, typeId, reason)) {
//                    resp.setStatus(HttpServletResponse.SC_OK);
//                } else {
//                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                }
//            } catch (NumberFormatException e) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            }
//        } else {
//            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        }
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrepareHttpReq.prepareReq(req, resp);
//        super.service(req, resp);
//    }
}

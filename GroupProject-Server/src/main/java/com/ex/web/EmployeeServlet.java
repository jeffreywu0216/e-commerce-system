package com.ex.web;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jeff.domain.Employee;
//import com.jeff.services.EmployeeService;
//import com.jeff.web.utils.PrepareHttpReq;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/employee/*"})
public class EmployeeServlet extends HttpServlet{
//    private  final Logger logger = LogManager.getLogger(EmployeeService.class);
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String[] arr = (String[]) req.getAttribute("urlParts");
//        ObjectMapper mapper = new ObjectMapper();
//
//        if(arr[arr.length - 1].equals("employee")){
//            List<Employee> list = new EmployeeService().getAll();
//
//            resp.setStatus(HttpServletResponse.SC_OK);
//            resp.setHeader("Content-Type", "application/json");
//            resp.getWriter().write(mapper.writeValueAsString(list));
//
//        } else {
//            try {
//                int id = Integer.parseInt(arr[arr.length - 1]);
//                Employee employee = new EmployeeService().findOne(id);
//                if (employee == null) {
//                    throw new Exception("invalid id");
//                }
//                resp.setStatus(HttpServletResponse.SC_OK);
//                resp.setHeader("Content-Type", "application/json");
//                resp.getWriter().write(mapper.writeValueAsString(employee));
//            } catch (Exception e) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String[] arr = (String[]) req.getAttribute("urlParts");
//            int empId = Integer.parseInt(arr[arr.length - 1]);
//            BufferedReader bufferedReader = req.getReader();
//            String[] data = PrepareHttpReq.bufferReaderToString(bufferedReader);
//
//            String lastName = data[0].split(":")[1];
//            String firstName = data[1].split(":")[1];
//            String address = data[2].split(":")[1];
//            String phone = data[3].split(":")[1];
//            String email = data[4].split(":")[1];
//            String pswd = data[5].split(":")[1].equals("unchanged") ? null : data[5].split(":")[1];
//
//            if (new EmployeeService().updateInfo(empId, lastName, firstName, address, phone, email, pswd)) {
//                resp.setStatus(HttpServletResponse.SC_OK);
//            } else {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            }
//        } catch (NumberFormatException e) {
//            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            logger.error(e);
//        }
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrepareHttpReq.prepareReq(req, resp);
//        super.service(req, resp);
//    }
}

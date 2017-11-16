package com.ex.web;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jeff.domain.Employee;
//import com.jeff.services.EmployeeService;
//import com.jeff.web.utils.PrepareHttpReq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login/*"})
public class LoginServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            BufferedReader bufferedReader = req.getReader();
//            String[] data = PrepareHttpReq.bufferReaderToString(bufferedReader);
//
//            String email = data[0].split(":")[1];
//            String pswd = data[1].split(":")[1];
//
//            Employee emp = new EmployeeService().login(email, pswd);
//            if ( emp != null) {
//                resp.setContentType("application/json");
//                resp.getWriter().write(mapper.writeValueAsString(emp));
//                resp.setStatus(HttpServletResponse.SC_OK);
//            } else {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            }
//        } catch (NumberFormatException e) {
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

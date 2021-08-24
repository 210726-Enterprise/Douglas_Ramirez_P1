package com.revature.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet is going to send "Welcome to servlets!!!"
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getOutputStream().println("<h1>Welcome to Servlets!!!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        for(String key: parameters.keySet()){
            System.out.println("Key: " + key);
            System.out.println("Value: " + req.getParameter(key));
        }

        List<String> list = req.getReader().lines().collect(Collectors.toList());
        System.out.println(list);
    }
}
/*  receive request
    parse request
    call dao
    success (sc 200)
    if it failed handle it
 */
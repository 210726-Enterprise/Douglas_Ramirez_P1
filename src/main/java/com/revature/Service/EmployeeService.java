package com.revature.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.orm.annotations.Column;
import com.revature.orm.model.employees;
import com.revature.persistence.SQLCommandDAOImpl;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private SQLCommandDAOImpl dao;
    private ObjectMapper mapper;
    employees employee1 = new employees();

    public EmployeeService(){
        dao = new SQLCommandDAOImpl();
        mapper = new ObjectMapper();
    }

    public void getAllEmployees(HttpServletRequest req, HttpServletResponse resp) {
        try {
            @SuppressWarnings("unchecked")
            List<employees> list = (List<employees>)(List<?>)getEmployees();
            PrintWriter out = resp.getWriter();
            String json = mapper.writeValueAsString(list);
            resp.setContentType("application/json");
            out.print(json);


        } catch (IOException e) {
            logger.warn(e.getMessage(), e);
        }
    }
    public void insertEmployee(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String requestData = req.getReader().lines().collect(Collectors.joining());
//            StringBuilder builder = new StringBuilder();
//            req.getReader().lines()
//                    .collect(Collectors.toList())
//                    .forEach(builder::append);

            employees employee = mapper.readValue(requestData, employees.class);
            int result = insert(employee);

            if(result == 1){
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else{

                // TODO: refactor with exception propagation to set better status codes
                resp.setStatus(HttpServletResponse.SC_CONFLICT);
            }

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            logger.warn(e.getMessage());
        }
    }

    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp) {
        StringBuilder builder = new StringBuilder();
        try {

            req.getReader().lines()
                    .collect(Collectors.toList())
                    .forEach(builder::append);

            employees employee = mapper.readValue(builder.toString(), employees.class);

            if(employee.getEmployee_id() != 0){
                boolean result = update(employee, employee.getEmployee_id());

                if(result){
                    resp.setStatus(HttpServletResponse.SC_OK);

                    String JSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
                    resp.getWriter().print(JSON);
                }

            } else{
                resp.setStatus(HttpServletResponse.SC_CONFLICT);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) {
        StringBuilder builder = new StringBuilder();

        try {
            req.getReader().lines()
                    .collect(Collectors.toList())
                    .forEach(builder::append);

            employees employee = mapper.readValue(builder.toString(), employees.class);

            boolean result = delete(employee, Integer.parseInt(String.valueOf(employee.getEmployee_id())));

            if (result) {
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.setStatus(HttpServletResponse.SC_CONFLICT);
            }
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private List<Object> getEmployees(){
        Optional<List<Object>> result = dao.findAll(employee1);
        return result.orElseGet(ArrayList::new);
    }
    private int insert(employees employee){
        return dao.insert(employee);
    }

    private boolean update(employees employee, int employee_id){
        return dao.update(employee, employee_id);
    }

    private boolean delete(employees employee, int id){
        return dao.delete(employee, id);
    }

}

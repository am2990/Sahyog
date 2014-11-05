package com.chs.service;

import java.util.List;

import com.chs.entity.EmployeeEntity;

 
public interface EmployeeService {
    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
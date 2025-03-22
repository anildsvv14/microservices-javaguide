package net.javaguides.employee_service.service;

import net.javaguides.employee_service.dto.ApiResponseDto;
import net.javaguides.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);
}

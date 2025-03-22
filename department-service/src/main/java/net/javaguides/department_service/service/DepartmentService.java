package net.javaguides.department_service.service;

import net.javaguides.department_service.dto.DepartmentDto;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartmentByCode(String departmentCode);

}

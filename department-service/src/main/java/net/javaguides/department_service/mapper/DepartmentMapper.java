package net.javaguides.department_service.mapper;

import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department) {

        return new DepartmentDto(department.getId(), department.getDepartmentName(), department.getDepartmentDescription(), department.getDepartmentCode());

    }

    public static Department mapToDepartment(DepartmentDto departmentDto) {

        return new Department(departmentDto.getId(), departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

    }
}

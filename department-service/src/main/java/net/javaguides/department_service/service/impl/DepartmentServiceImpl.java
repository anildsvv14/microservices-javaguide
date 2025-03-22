package net.javaguides.department_service.service.impl;

import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;
import net.javaguides.department_service.mapper.DepartmentMapper;
import net.javaguides.department_service.repository.DepartmentRepository;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert to department
        Department dept = DepartmentMapper.mapToDepartment(departmentDto);
        //save the department
        Department savedDept = departmentRepository.save(dept);
        return DepartmentMapper.mapToDepartmentDto(savedDept);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto=DepartmentMapper.mapToDepartmentDto(department);


        return departmentDto;
    }
}

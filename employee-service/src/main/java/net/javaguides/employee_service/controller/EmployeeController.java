package net.javaguides.employee_service.controller;


import net.javaguides.employee_service.dto.ApiResponseDto;
import net.javaguides.employee_service.dto.EmployeeDto;
import net.javaguides.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {

        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}

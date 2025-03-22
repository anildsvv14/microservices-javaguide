package net.javaguides.employee_service.service.impl;


import net.javaguides.employee_service.dto.ApiResponseDto;
import net.javaguides.employee_service.dto.DepartmentDto;
import net.javaguides.employee_service.dto.EmployeeDto;
import net.javaguides.employee_service.entity.Employee;
import net.javaguides.employee_service.mapper.EmployeeMapper;
import net.javaguides.employee_service.repository.EmployeeRepository;
import net.javaguides.employee_service.service.ApiClient;
import net.javaguides.employee_service.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
 //   private WebClient webClient;
//    private RestTemplate restTemplate;
    private ApiClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ApiClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.apiClient = apiClient;

    }
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        employee = employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee= employeeRepository.findById(employeeId).get();
       // ResponseEntity<DepartmentDto> response =restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
      //  DepartmentDto departmentDto=response.getBody();

        //webclient to get response from department service
       // DepartmentDto departmentDto=webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
       DepartmentDto departmentDto=apiClient.getDepartmentByCode(employee.getDepartmentCode());
        ApiResponseDto apiResponseDto=new ApiResponseDto(EmployeeMapper.mapToEmployeeDto(employee),departmentDto);
        return apiResponseDto;
    }
}

package Employee.Management;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) { this.service = service; }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee emp) { return service.save(emp); }

    @GetMapping("/all")
    public List<Employee> getAll() { return service.getAll(); }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { 
        service.delete(id); 
        return "Deleted"; 
    }
}

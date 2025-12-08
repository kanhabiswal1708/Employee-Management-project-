package Employee.Management;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee save(Employee emp) { return repo.save(emp); }
    public List<Employee> getAll() { return repo.findAll(); }
    public void delete(Long id) { repo.deleteById(id); }
}

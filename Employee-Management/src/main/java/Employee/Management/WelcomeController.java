package Employee.Management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WelcomeController {

    // Root mapping removed to allow index.html to be served

    @GetMapping("/status")
    @ResponseBody
    public Map<String, Object> status() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "running");
        status.put("timestamp", System.currentTimeMillis());
        status.put("port", 8080);
        status.put("database", "H2 In-Memory");
        return status;
    }
}

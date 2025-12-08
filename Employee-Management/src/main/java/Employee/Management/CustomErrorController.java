package Employee.Management;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/error")
public class CustomErrorController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object requestUri = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);

        int statusCode = status != null ? Integer.parseInt(status.toString()) : 500;
        
        errorDetails.put("timestamp", System.currentTimeMillis());
        errorDetails.put("status", statusCode);
        errorDetails.put("error", HttpStatus.valueOf(statusCode).getReasonPhrase());
        errorDetails.put("message", message != null ? message.toString() : "No message available");
        errorDetails.put("path", requestUri != null ? requestUri.toString() : "Unknown");

        if (statusCode == 404) {
            errorDetails.put("message", "Endpoint not found. Please check the URL and try again.");
            errorDetails.put("hint", "Available endpoints: POST /employee/save, GET /employee/all, DELETE /employee/delete/{id}");
        } else if (statusCode == 405) {
            errorDetails.put("message", "Method not allowed. Please use the correct HTTP method.");
        } else if (statusCode == 400) {
            errorDetails.put("message", "Bad request. Please check your request parameters and body.");
        }

        return ResponseEntity.status(statusCode).body(errorDetails);
    }
}


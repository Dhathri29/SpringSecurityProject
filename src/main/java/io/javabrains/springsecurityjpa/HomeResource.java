package io.javabrains.springsecurityjpa;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this is a controller page
@RestController
public class HomeResource {
    
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }
    
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }
    
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
    
    @RequestMapping("/registration")
    public String regestration(HttpServletRequest request) {
        return "regestration";
    }
}


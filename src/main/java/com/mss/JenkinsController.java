package com.mss;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {
    @GetMapping("/welcome")
    public String welcome1() {
        return "<html><head><style>body { display: flex; justify-content: center; align-items: center; height: 100vh;}</style></head><body><h1 style='color:blue; text-align:center;'>WELCOME TO MY <b>DEPLOYMENT<b><br></h1></body></html>";
    }
}


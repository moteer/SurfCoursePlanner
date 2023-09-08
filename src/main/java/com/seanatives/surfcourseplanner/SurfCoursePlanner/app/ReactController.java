package com.seanatives.surfcourseplanner.SurfCoursePlanner.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReactController {
    @GetMapping("/")
    public String index() {
        return "forward:/frontend/build/index.html";
    }
}

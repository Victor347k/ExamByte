package com.exambyte.exambyte.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/test-management")
    public String testManagement() {
        return "test-management";
    }

    @GetMapping("/correction")
    public String correction() {
        return "correction";
    }

    @GetMapping("/results")
    public String results() {
        return "results";
    }

    @GetMapping("/correction-status")
    public String correctionStatus() {
        return "correction-status";
    }
}

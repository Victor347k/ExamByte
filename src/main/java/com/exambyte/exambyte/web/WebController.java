package com.exambyte.exambyte.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index"; // Lädt index.html
    }

    @GetMapping("/test")
    public String test() {
        return "test"; // Lädt test.html
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

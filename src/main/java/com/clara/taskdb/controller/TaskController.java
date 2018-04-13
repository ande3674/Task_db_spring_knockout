package com.clara.taskdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ce6915gp on 4/12/2018.
 */
@Controller
public class TaskController {

    // Web page routes. Only need one in this app, there's only one page,
    // that's updated with JavaScript calls from the client JavaScript app.
    @GetMapping("/")
    public String homePage() {
        return "index.html";
    }
}

package com.satyla.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/error403")
    public String userAuthorityError() {
        LOG.error("Authority error");
        return "error403";
    }

}

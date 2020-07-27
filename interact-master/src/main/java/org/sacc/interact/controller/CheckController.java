package org.sacc.interact.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaofan
 */
@RestController
public class CheckController {
    @GetMapping("/check")
    public String check(){
        return "It works.";
    }
}

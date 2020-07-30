package org.sacc.interact.controller;

import org.sacc.interact.entity.Group;
import org.sacc.interact.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gaofan
 */
@RestController
public class CheckController {
    @Autowired
    GroupService groupService;
    @GetMapping("/checkgroup")
    public List<Group> check(){
        List<Group> groups= groupService.check();
        return groups;
    }
}

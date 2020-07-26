package org.sacc.interact.service;

import org.sacc.interact.entity.Group;
import org.sacc.interact.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;
    public List<Group> check (){
        return groupMapper.checkgroup();
    }
}

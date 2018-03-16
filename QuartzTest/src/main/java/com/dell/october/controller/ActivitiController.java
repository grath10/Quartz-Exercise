package com.dell.october.controller;

import com.dell.october.entity.StartProcessRepresentation;
import com.dell.october.entity.TaskBean;
import com.dell.october.service.ActivitiService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivitiController {
    @Autowired
    private ActivitiService activitiService;

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public void startProcessInstance(@RequestBody StartProcessRepresentation startProcessRepresentation){
        activitiService.startProcess(startProcessRepresentation.getAssignee());
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseBody
    public List<TaskBean> getTasks(String assignee){
        List<Task> tasks = activitiService.getTasks(assignee);
        List<TaskBean> taskBeanList = new ArrayList<>();
        for(Task task: tasks){
            taskBeanList.add(new TaskBean(task.getId(), task.getName()));
        }
        return taskBeanList;
    }

}

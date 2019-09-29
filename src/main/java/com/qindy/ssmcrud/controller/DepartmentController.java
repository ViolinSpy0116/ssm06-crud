package com.qindy.ssmcrud.controller;

import com.qindy.ssmcrud.bean.Department;
import com.qindy.ssmcrud.bean.Msg;
import com.qindy.ssmcrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Qindy
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts", list);
    }

    @RequestMapping(value = "/dept", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveDep(@Valid Department department, BindingResult result){
        departmentService.saveDep(department);
        return Msg.success();
    }
}

package com.qindy.ssmcrud.service;

import com.qindy.ssmcrud.bean.Department;
import com.qindy.ssmcrud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ssm06-crud
 * @contact: qindy0116@126.com
 * @author: Mr.DYQin
 * @create: 2019-09-27 16:40
 **/

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }

    public void saveDep(Department department) {
        departmentMapper.insertSelective(department);
        System.out.println("service here");
    }
}

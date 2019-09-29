package com.qindy.ssmcrud.test;

import com.qindy.ssmcrud.bean.Department;
import com.qindy.ssmcrud.bean.Employee;
import com.qindy.ssmcrud.dao.DepartmentMapper;
import com.qindy.ssmcrud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author Qindy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD() {
        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(
//                new Department(null, "人事部")
//        );
//        departmentMapper.insertSelective(
//                new Department(null, "管理部")
//        );


        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + 1;
            mapper.insertSelective(new Employee(null, uid, "F", uid + "0203@qbhn.com", 4));
        }
        System.out.println("insert success");
    }
}

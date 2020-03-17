package com.zpark.springboot02configautoconfig.controller;

import com.zpark.springboot02configautoconfig.dao.DepartmentDao;
import com.zpark.springboot02configautoconfig.dao.EmployeeDao;
import com.zpark.springboot02configautoconfig.entities.Department;
import com.zpark.springboot02configautoconfig.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> allEmployee = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",allEmployee);
        //thyemleaf默认就会拼串
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //来到添加页面
        return "emp/add";
    }
    //添加员工
    //SpringBootMVC自动请求参数和入参对象属性进行一一绑定：请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("保存员工信息："+employee);
        //保存员工
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址   /表示当前项目路径
        //forward:表示转发到一个地址

        return "redirect:/emps";
    }
    /**
     * 来到修改页面，查出当前员工，在页面回显
     */
    @GetMapping("/emp/{id}")
    public String toEdiPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        System.out.println("emp:"+employee);
        Collection<Department>departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add是要给修改添加二合一的页面)
        return "emp/add";
    }
    /**
     * 员工修改
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改过的员工信息："+employee);

        employeeDao.save(employee);
        return "redirect:/emps";
    }
    /**
     * 员工删除
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    /**
     *
     */
    @RequestMapping("/tu")
    public String tu(){

        return "";
    }
}

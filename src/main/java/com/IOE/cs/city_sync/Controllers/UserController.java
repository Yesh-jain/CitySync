package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.Services.DepartmentService;
import com.IOE.cs.city_sync.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public String userPage() {
        return "user/user-rights";
    }

    @GetMapping("/showDepartments")
    public String showDepartments(Model model) {
        List<DepartmentListDTO> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "user/showDepartments";
    }
}

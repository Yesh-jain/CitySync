package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.*;
import com.IOE.cs.city_sync.Services.CSUserService;
import com.IOE.cs.city_sync.Services.DepartmentService;
import com.IOE.cs.city_sync.Services.MessageService;
import com.IOE.cs.city_sync.Services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CSUserService csUserService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("")
    public String adminRole() {
        return "admin/admin-role";
    }

    @GetMapping("/role")
    public String adminPage() {
        return "admin/admin-rights";
    }

    @GetMapping({"/register-user"})
    public String registerUser(Model model) {
        CSUserDTO csuserDto = new CSUserDTO();
        List<DepartmentListDTO> departmentListDTOS = departmentService.getAllDepartments();
        model.addAttribute("departments", departmentListDTOS);
        model.addAttribute("csuserDto", csuserDto);
        return "admin/registerUser";
    }

    @PostMapping("/add-user")
    public String userSubmission(CSUserDTO csuserdto, Model model) {
        csUserService.addUser(csuserdto);
        model.addAttribute("message", "Signup successful for " + csuserdto.getName());
        return "user/result";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        List<UserListDTO> allUsers = csUserService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "admin/showUsers";
    }

    @GetMapping("/register-department")
    public String registerDepartment(Model model) {
        DepartmentDTO departmentDto = new DepartmentDTO();
        model.addAttribute("departmentdto", departmentDto);
        return "admin/registerDept";
    }

    @PostMapping("/add-department")
    public String addDepartment(DepartmentDTO departmentdto, Model model) {
        departmentService.addDepartment(departmentdto);
        model.addAttribute("message", "Deparatment Registration successful for" + departmentdto.getName());
        return "user/result";
    }

    @GetMapping("/showAllMessages")
    public String showAllMessages(Model model) {
        List<MessageDTO> allMessages = messageService.getAllMessages();
        model.addAttribute("allMessages", allMessages);
        return "admin/showAllMessages";
    }

    @GetMapping("/showResourcePool")
    public String showResourcePool(Model model){
        List<ResourcePoolDTO> allPooledResources = resourceService.getResourcePool();
        model.addAttribute("allPooledResources" , allPooledResources);
        return "admin/showPooledResources";
    }
}

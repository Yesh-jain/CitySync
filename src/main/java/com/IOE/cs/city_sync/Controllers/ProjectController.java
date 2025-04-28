package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.DTOs.ProjResDTO;
import com.IOE.cs.city_sync.DTOs.ProjectListDTO;
import com.IOE.cs.city_sync.DTOs.ResourceDTOWrapper;
import com.IOE.cs.city_sync.Expection.AlreadyFinishedProjectException;
import com.IOE.cs.city_sync.Services.DepartmentService;
import com.IOE.cs.city_sync.Services.ProjectService;
import com.IOE.cs.city_sync.Services.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/upload")
    public String uploadProject(Model model) {
        ProjResDTO projResDTO = new ProjResDTO();
        List<DepartmentListDTO> departmentListDTOS = departmentService.getAllDepartments();
        model.addAttribute("projResDTO", projResDTO);
        model.addAttribute("departments", departmentListDTOS);
        return "user/UploadProject";
    }

    @PostMapping("/submit")
    public String projectSubmission(@ModelAttribute ProjResDTO projectDTO, Principal user) {
        System.out.println(projectDTO.toString());
        projectService.saveProjectResource(projectDTO, user.getName());
        return "redirect:/user";
    }

    @GetMapping("/showProjects")
    public String showProjects(Model model) {
        List<ProjectListDTO> allProjects = projectService.showProjects();
        model.addAttribute("allProjects", allProjects);
        return "user/showProjects";
    }

    @GetMapping("/myProjects")
    public String myProjects(Principal user, Model model) {
        List<ProjectListDTO> myProjects = projectService.myProjects(user.getName());
        model.addAttribute("myProjects", myProjects);
        return "user/showMyProjects";
    }

    @GetMapping("/finishProject")
    public String finishProjects(@RequestParam("projectId") Integer projectId, Model model){
        ProjResDTO finishedProjResDTO = projectService.getFinishedProject(projectId);
        model.addAttribute("finishedProjResDTO", finishedProjResDTO);
        return "user/finishProject";
    }

    @PostMapping("/finishProject")
    public String usedResourceUpdate(@ModelAttribute ResourceDTOWrapper usedResource){
        try{
                resourceService.usedResourceUpdate(usedResource);
        }catch (AlreadyFinishedProjectException ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/user/project/myProjects";
    }
}

package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.ProjResDTO;
import com.IOE.cs.city_sync.DTOs.ProjectListDTO;
import com.IOE.cs.city_sync.DTOs.ResourceDTO;
import com.IOE.cs.city_sync.DTOs.UserListDTO;
import com.IOE.cs.city_sync.Entities.Message;
import com.IOE.cs.city_sync.Entities.Project;
import com.IOE.cs.city_sync.Entities.Resource;
import com.IOE.cs.city_sync.Repos.*;
import com.IOE.cs.city_sync.enums.ProjectStatus;
import com.IOE.cs.city_sync.enums.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private CSUserRepo csUserRepo;

    @Autowired
    private ResourcePoolRepo resourcePoolRepo;


    public void saveProjectResource(ProjResDTO projResDTO, String username) {
        Project project = new Project();
        project.setName(projResDTO.getProjectName());
        project.setDepartment(csUserRepo.getByUsername(username).getDepartment());
        //System.out.println("This is department"+csUserRepo.getByUsername(username).getDepartment());                    // Marked
        project.setDescription(projResDTO.getProjDescription());
        project.setStartDate(projResDTO.getStartDate());
        project.setEndDate(projResDTO.getEndDate());
        project.setUploadDate(LocalDate.now());
        project.setIsInterdepartmental(false);
        project.setLocation(projResDTO.getLocation());
        project.setProjectStatus(ProjectStatus.UNDERPROCESS);
        List<UserListDTO> userListDTOs = csUserRepo.getAllUsers();

        // added for sending notification
        for (UserListDTO userListDTO : userListDTOs) {
            if (userListDTO.getUsername().equals("admin") || userListDTO.getUsername().equals(username)) {
                continue;
            }
            Message message = new Message();
            message.setProject(project);
            message.setRecepientUser(csUserRepo.findByUsername(userListDTO.getUsername()));
            message.setResponse(Response.UNANSWERED);
            messageRepo.save(message);
        }

        projectRepo.save(project);

        // Resource

        for (ResourceDTO resourceDTO : projResDTO.getResourcesdto()) {
            Resource resource = new Resource();
            resource.setProject(projectRepo.getById(project.getId()));
            resource.setName(resourceDTO.getResourceName());
            resource.setAllottedQuantity(resourceDTO.getAllottedQuantity());

            resource.setDescription(resourceDTO.getResDescription());
            resource.setIsAvailable(true);
            resourceRepo.save(resource);
        }
    }

    public List<ProjectListDTO> showProjects() {
        return projectRepo.showProjects();
    }

    public List<ProjectListDTO> myProjects(String username) {
        Integer deptId = csUserRepo.getDepartmentIdByUsername(username);
        List<ProjectListDTO> myProjects = projectRepo.myProjects(deptId);
        return myProjects;
    }

    public ProjResDTO getFinishedProject(Integer projectId) {
        ProjResDTO projResDTO = new ProjResDTO();
        Project project = projectRepo.getProjectById(projectId);
        projResDTO.setProjectName(project.getName());
        projResDTO.setProjectStatus(project.getProjectStatus());
        projResDTO.setResourcesdto(resourceRepo.getFinishedProjectResourceById(projectId));



        return projResDTO;
    }
}
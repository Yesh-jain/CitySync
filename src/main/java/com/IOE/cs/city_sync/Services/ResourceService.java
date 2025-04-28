package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.ResourceDTO;
import com.IOE.cs.city_sync.DTOs.ResourceDTOWrapper;
import com.IOE.cs.city_sync.DTOs.ResourcePoolDTO;
import com.IOE.cs.city_sync.Entities.CSUser;
import com.IOE.cs.city_sync.Entities.Project;
import com.IOE.cs.city_sync.Entities.Resource;
import com.IOE.cs.city_sync.Entities.ResourcePool;
import com.IOE.cs.city_sync.Expection.AlreadyFinishedProjectException;
import com.IOE.cs.city_sync.Repos.CSUserRepo;
import com.IOE.cs.city_sync.Repos.ProjectRepo;
import com.IOE.cs.city_sync.Repos.ResourcePoolRepo;
import com.IOE.cs.city_sync.Repos.ResourceRepo;
import com.IOE.cs.city_sync.enums.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ResourcePoolRepo resourcePoolRepo;

    @Autowired
    private CSUserRepo csUserRepo;


    public void usedResourceUpdate(ResourceDTOWrapper usedResource) {
        ArrayList<ResourceDTO> usedResourcesDTO = usedResource.getUsedResource();
        Project projectCheck = resourceRepo.getResourceById(usedResourcesDTO.getFirst().getResourceId()).getProject();
           // System.out.println(resourceRepo.getResourceById(usedResourcesDTO.get(0).getResourceId()));
        if(projectCheck.getProjectStatus() == ProjectStatus.COMPLETED){
            throw new AlreadyFinishedProjectException("Project "+projectCheck.getName()+" Already finished");
        }
        for(ResourceDTO resourceDTO : usedResourcesDTO){
            Resource resource = resourceRepo.getById(resourceDTO.getResourceId());
            resource.setUsedQuantity(resourceDTO.getUsedQuantity());
            Project project = resource.getProject();
            resourceRepo.save(resource);
            project.setProjectStatus(ProjectStatus.COMPLETED);
            projectRepo.save(project);
        }
    }


    public List<ResourcePoolDTO> showResourcePool(String username) {
        List<ResourcePool> resourcePoolList = resourcePoolRepo.findAll();
        List<ResourcePoolDTO> resourcePoolDTOList = new ArrayList<>();
        for(ResourcePool resourcePool : resourcePoolList){
            if(resourcePool.getSharedUser()!= null || resourcePool.getResource().getProject().getDepartment() == csUserRepo.getByUsername(username).getDepartment() ){
                continue;
            }
            ResourcePoolDTO resourcePoolDTO = new ResourcePoolDTO();
            resourcePoolDTO.setResourceId(resourcePool.getResource().getId());
            resourcePoolDTO.setResourceName(resourcePool.getResource().getName());
            resourcePoolDTO.setResDescription(resourcePool.getResource().getDescription());
            resourcePoolDTO.setPooledQuantity(resourcePool.getPooledQuantity());
            resourcePoolDTO.setOwnerDepartment(resourcePool.getResource().getProject().getDepartment().getName());
            resourcePoolDTOList.add(resourcePoolDTO);
        }
        return resourcePoolDTOList;
    }

    public void bookResource(String username, Integer resourceId) {
        ResourcePool resourcePool = resourcePoolRepo.getResourcePoolByResource(resourceRepo.getResourceById(resourceId));
        System.out.println(resourcePool.toString());
        resourcePool.setSharedUser(csUserRepo.getByUsername(username));
        resourcePoolRepo.save(resourcePool);
    }

    public List<ResourcePoolDTO> getResourcePool(){
        return resourcePoolRepo.getResourcePool();
    }
}

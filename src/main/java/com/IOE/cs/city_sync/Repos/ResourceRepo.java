package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.DTOs.ResourceDTO;
import com.IOE.cs.city_sync.Entities.Project;
import com.IOE.cs.city_sync.Entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceRepo extends JpaRepository<Resource, Integer> {
    @Query("Select new com.IOE.cs.city_sync.DTOs.ResourceDTO(r.id, r.name , r.allottedQuantity , r.usedQuantity) " +
            "from Resource r where r.project.id = :projectID")
    List<ResourceDTO> getFinishedProjectResourceById(@Param("projectID") Integer projectId);

    Resource getResourceById(Integer id);
}

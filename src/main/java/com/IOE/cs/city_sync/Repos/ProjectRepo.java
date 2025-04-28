package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.DTOs.ProjectListDTO;
import com.IOE.cs.city_sync.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
    Project save(Project project);

    @Override
    Project getById(Integer id);

    Project getProjectById(Integer projectId);

    @Query("Select new com.IOE.cs.city_sync.DTOs.ProjectListDTO(p.id , p.name , d.name , p.location , p.Description , p.startDate , p.endDate , p.projectStatus) from Project p " +
            "left join Department d ON p.department.id = d.id")
    List<ProjectListDTO> showProjects();

    @Query("Select new com.IOE.cs.city_sync.DTOs.ProjectListDTO(p.id , p.name , d.name , p.location , p.Description , p.startDate , p.endDate, p.projectStatus) from Project p " +
            "left join Department d ON p.department.id = d.id where p.department.id = :deptid")
    List<ProjectListDTO> myProjects(@Param("deptid") Integer deptID);

}

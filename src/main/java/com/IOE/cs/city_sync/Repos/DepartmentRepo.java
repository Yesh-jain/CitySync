package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    Department getDepartmentById(Integer id);

    @Query("SELECT new com.IOE.cs.city_sync.DTOs.DepartmentListDTO(d.id , d.name, d.Description ,d.PhoneNumber  ) from Department d")
    List<DepartmentListDTO> getAllDepartments();

}

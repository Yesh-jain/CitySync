package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.DepartmentDTO;
import com.IOE.cs.city_sync.DTOs.DepartmentListDTO;
import com.IOE.cs.city_sync.Entities.Department;
import com.IOE.cs.city_sync.Repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public List<DepartmentListDTO> getAllDepartments(){
        return departmentRepo.getAllDepartments();
    }

    public void addDepartment(DepartmentDTO departmentdto) {
        Department department = new Department();
        department.setName(departmentdto.getName());
        department.setDescription(departmentdto.getDescription());
        department.setPhoneNumber(departmentdto.getPhoneNumber());
        departmentRepo.save(department);
    }
}

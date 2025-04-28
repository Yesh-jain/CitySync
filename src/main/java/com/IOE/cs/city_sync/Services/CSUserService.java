package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.CSUserDTO;
import com.IOE.cs.city_sync.DTOs.UserListDTO;
import com.IOE.cs.city_sync.Entities.CSUser;
import com.IOE.cs.city_sync.Repos.CSUserRepo;
import com.IOE.cs.city_sync.Repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSUserService {

    @Autowired
    private CSUserRepo csUserRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void addUser(CSUserDTO csUserDTO) {
        CSUser csUser = new CSUser();

        csUser.setEmail(csUserDTO.getEmail());
        csUser.setName(csUserDTO.getName());

        csUser.setUsername(csUser.getEmail().substring(0, csUser.getEmail().indexOf('@')).toLowerCase());  // fetches the name from email by removing domain name

        csUser.setPassword(encoder.encode(csUserDTO.getPassword())); // encodes the password
        csUser.setRole(csUserDTO.getRole().toUpperCase());

        csUser.setDepartment(departmentRepo.getDepartmentById(csUserDTO.getDepartmentid()));
        csUserRepo.save(csUser);
    }

    public List<UserListDTO> getAllUsers() {
        return csUserRepo.getAllUsers();
    }

}

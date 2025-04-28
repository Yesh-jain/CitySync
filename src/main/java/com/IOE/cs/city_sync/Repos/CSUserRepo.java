package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.DTOs.UserListDTO;
import com.IOE.cs.city_sync.Entities.CSUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CSUserRepo extends JpaRepository<CSUser, Integer> {

    CSUser save(CSUser csUser);

    CSUser findByUsername(String username);

    @Query("SELECT new com.IOE.cs.city_sync.DTOs.UserListDTO(u.name, u.email, u.id, u.username, d.name) from CSUser u \n" +
            "left join \n" +
            "\t\t Department d\n" +
            "ON \n" +
            "\t d.id = u.department.id")
    List<UserListDTO> getAllUsers();

    @Query("Select u.department.id from CSUser u where u.username = :username")
    Integer getDepartmentIdByUsername(@Param("username") String username);

    CSUser getByUsername(String username);
}

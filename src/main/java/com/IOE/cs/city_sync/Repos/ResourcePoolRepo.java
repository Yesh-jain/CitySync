package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.DTOs.ResourcePoolDTO;
import com.IOE.cs.city_sync.Entities.Resource;
import com.IOE.cs.city_sync.Entities.ResourcePool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourcePoolRepo extends JpaRepository<ResourcePool, Integer> {


    ResourcePool getResourcePoolByResource(Resource resource);

    @Query("SELECT new com.IOE.cs.city_sync.DTOs.ResourcePoolDTO(r.id , r.name , r.Description , rp.pooledQuantity , p.name , d.name , u.name) from  ResourcePool rp \n" +
            "LEFT JOIN \n" +
            "\t\tResource r\n" +
            "ON\n" +
            "\t\t rp.resource.id = r.id \n" +
            "LEFT JOIN \n" +
            "\t\tProject p\n" +
            "ON \n" +
            "\t\tr.project.id = p.id\n" +
            "LEFT JOIN\n" +
            "\t\tCSUser u\n" +
            "ON\n" +
            "\t\t rp.sharedUser.id = u.id\n" +
            "LEFT JOIN \n" +
            "\t\t Department d\n" +
            "ON \n" +
            "\t\t p.department.id = d.id")
    List<ResourcePoolDTO> getResourcePool();
}

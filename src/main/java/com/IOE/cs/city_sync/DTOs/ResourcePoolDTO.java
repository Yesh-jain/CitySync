package com.IOE.cs.city_sync.DTOs;

import com.IOE.cs.city_sync.Entities.CSUser;
import com.IOE.cs.city_sync.Entities.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class ResourcePoolDTO {
    private Integer resourceId;

    private String resourceName;

    private String resDescription;

    private Integer pooledQuantity;

    private String ownerDepartment;

    private String projectName;

    private String departmentName;

    private String sharedUser;

    ResourcePoolDTO(Integer resourceId , String resourceName , String resDescription , Integer pooledQuantity ,
                    String projectName , String departmentName, String sharedUser){
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resDescription = resDescription;
        this.pooledQuantity = pooledQuantity;
        this.sharedUser = sharedUser;
        this.departmentName = departmentName;
        this.projectName = projectName;
    }

}

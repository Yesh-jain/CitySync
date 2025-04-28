package com.IOE.cs.city_sync.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceDTO {

    private Integer resourceId;

    private String resourceName;

    private Integer allottedQuantity;

    private Integer usedQuantity;

    private String resDescription;

    private String ownerDepartment;

    private Integer pooledQuantity;

    public ResourceDTO(Integer resourceId , String resourceName , Integer allottedQuantity, Integer usedQuantity) {
        this.resourceId = resourceId;
        this.usedQuantity = usedQuantity;
        this.allottedQuantity = allottedQuantity;
        this.resourceName = resourceName;
    }

public ResourceDTO(Integer resourceId , String resourceName , String resDescription, Integer pooledQuantity , String ownerDepartment) {
    this.resourceId = resourceId;
    this.resDescription = resDescription;
    this.pooledQuantity = pooledQuantity;
    this. ownerDepartment = ownerDepartment;
    this.resourceName = resourceName;
}

    public ResourceDTO(Integer resourceId, String ownerDepartment, String resDescription, Integer usedQuantity, Integer allottedQuantity, String resourceName) {
        this.resourceId = resourceId;
        this.ownerDepartment = ownerDepartment;
        this.resDescription = resDescription;
        this.usedQuantity = usedQuantity;
        this.allottedQuantity = allottedQuantity;
        this.resourceName = resourceName;
    }
}

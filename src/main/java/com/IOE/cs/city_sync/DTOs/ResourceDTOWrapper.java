package com.IOE.cs.city_sync.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTOWrapper {

   ArrayList<ResourceDTO> usedResource;

}

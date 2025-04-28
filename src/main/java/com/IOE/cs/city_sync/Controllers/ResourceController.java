package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.ResourcePoolDTO;
import com.IOE.cs.city_sync.Services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/showPool")
    public String showResourcePool(Model model, Principal user){
        List<ResourcePoolDTO> pooledResourceDto = resourceService.showResourcePool(user.getName());
        model.addAttribute("pooledResourceDto" , pooledResourceDto);
        return "user/resourcePool";
    }

    @PostMapping("/bookResource")
    public String bookResource(Principal user, @RequestParam("resourceId") Integer resourceId){
        resourceService.bookResource(user.getName() , resourceId);
        return "redirect:/user/resources/showPool";
    }
}

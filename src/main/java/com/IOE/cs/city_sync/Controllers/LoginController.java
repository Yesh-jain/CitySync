package com.IOE.cs.city_sync.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    //    @GetMapping({"","/home"})
//    public String register(){
//        return "index";
//    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

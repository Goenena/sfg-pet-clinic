package com.avensic.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"/", "", "/index.html", "/index"})
    public String listOwners(){
        return "owners/index";
    }
}

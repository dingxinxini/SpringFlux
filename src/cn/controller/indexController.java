package cn.controller;

import cn.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class indexController {
    @RequestMapping("/test")
    @ResponseBody
public String test(){
        // ResponseEntity<String>
//     ResponseEntity responseEntity=new ResponseEntity("Web", HttpStatus.OK);
//     return responseEntity;
        return "test";
}
    @RequestMapping("/person")
    @ResponseBody
    public String person(){
        // ResponseEntity<String>
//     ResponseEntity responseEntity=new ResponseEntity("Web", HttpStatus.OK);
//     return responseEntity;
        return "test";
    }

    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        return "index";
    }
    @ModelAttribute("role")
    public Role role(){
        return new Role(1,"USER");
    }

    @ModelAttribute("roles")
    public List<Role> roles(){
        return Arrays.asList(new Role(1,"USER"),new Role(2,"admin"));
    }

}

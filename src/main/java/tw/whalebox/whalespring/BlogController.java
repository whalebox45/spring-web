/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tw.whalebox.whalespring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author hsean
 */
@Controller
public class BlogController {
    
    @GetMapping("/")
    public String rootPage(){
        return "redirect:/index";
    }
    
    @GetMapping("/about")
    public String aboutBlog(){
        return "about";
    }
}


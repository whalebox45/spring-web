/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tw.whalebox.blogweb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author hsean
 */
@Controller
public class BlogController {
    
    @GetMapping("/")
    public String rootPage(){
        return "redirect:/about";
    }
    
    @GetMapping("/about")
    public String aboutBlog(){
        return "about";
    }
    
    @GetMapping("/contact")
    public String contactBlog(){
        return "contact_beta";
    }
    
}

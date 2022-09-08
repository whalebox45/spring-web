/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tw.whalebox.whalespring;

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
public class BlogPostController {
    @Autowired
    PostRepository postRepo;
    
    @GetMapping("/index")
    public String Index(Model model){
        var posts = (List<Post>) postRepo.findByOrderByCreateDateDesc();
        model.addAttribute("posts",posts);
        return "index";
    }
    
    @GetMapping("/post/{route_tag}")
    public String BlogPostByRouteTag(Model model, @PathVariable String route_tag){
        var post = (List<Post>) postRepo.findByRouteTag(route_tag);
        
        model.addAttribute("blogpost", post.get(0));
        return "post";
    }
    
    @GetMapping({"/postid/{id}"})
    public String BlogPostById(Model model, @PathVariable long id){
        var post = (List<Post>) postRepo.findById(id);
        
       
        model.addAttribute("blogpost",post.get(0));
        
        return "post";
    }
    
}

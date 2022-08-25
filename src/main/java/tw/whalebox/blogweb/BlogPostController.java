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
public class BlogPostController {
    @Autowired
    PostRepository postRepo;
//    @GetMapping("/post")
//    public String BlogPost(Model model){
//        
//        var posts = (List<Post>) postRepo.findAll();
//        
//        model.addAttribute("posts",posts);
//        
//        return "blogpost_res";
//    }
    
    @GetMapping({"/post/{id}"})
    public String BlogPostById(Model model, @PathVariable long id){
        var post = (List<Post>) postRepo.findById(id);
        
       
        model.addAttribute("blogpost",post.get(0));
        
        return "post";
    }
}

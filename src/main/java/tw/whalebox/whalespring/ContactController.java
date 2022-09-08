/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tw.whalebox.whalespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author hsean
 */
@Controller
public class ContactController {
    
    @Autowired
    ContactFormRepository contactRepo;
            
//    @GetMapping("/contact")
//    public String contactBlog(){
//        return "contact";
//    }
    
    @GetMapping(
            value = {"/contact_test","/contact"}
    )
    public String contactBlogTest(Model model){
        model.addAttribute("newform", new ContactForm());
        return "contact";
    }
    
    @PostMapping(
            value = "/contact_form"
            )
    public String contactFormPost(@ModelAttribute ContactForm newform, 
            Model model, BindingResult result, RedirectAttributes redirectAttributes){
        
        redirectAttributes.addFlashAttribute("message", "表單傳送失敗");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        if (result.hasErrors()) {
            return "redirect:/contact";
        }
        
        
        redirectAttributes.addFlashAttribute("message", "表單傳送成功");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
    
        model.addAttribute("newform", new ContactForm());
        this.contactRepo.save(newform);
        return "redirect:/contact";
    }
    
}

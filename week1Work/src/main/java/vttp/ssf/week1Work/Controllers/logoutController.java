package vttp.ssf.week1Work.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vttp.ssf.week1Work.models.Info;

@Controller
@RequestMapping
public class logoutController {
    @PostMapping("/exit")
   public String logOut(HttpSession session, Model model) {

        session.setAttribute("counter", 0); 
        model.addAttribute("counter", 0);
        model.addAttribute("INFO", new Info());

       
       return "login";
   }
}

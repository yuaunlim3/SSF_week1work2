package vttp.ssf.week1Work.Controllers;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.ssf.week1Work.models.Constants;
import vttp.ssf.week1Work.models.Info;

@Controller
@RequestMapping("/sercet")
public class loginController {
    @PostMapping
    public String processLogin(@Valid @ModelAttribute("INFO") Info info, BindingResult bindingResult, Model model,
            HttpSession session) {

        // Get Counter from session
        Integer counter = (Integer) session.getAttribute("counter");
        Boolean capNeeded = (Boolean) session.getAttribute("captionNeeded"); // changed to Boolean instead of boolean

        if (capNeeded == null) {
            capNeeded = Boolean.FALSE;  // Default to false if not set
        }
        if (counter == null)
            counter = 0;
        String password = info.getPassword();
        Random rand = new SecureRandom();
        int toGet = rand.nextInt(20);
        model.addAttribute("toGive", toGet);
        System.out.printf("capNeeded %b counter: %d Info:%s\n", capNeeded, counter, info.toString());
        // Correct password
        if (capNeeded) {
            Integer caption = info.getCaption();
            if (password.equals(Constants.PASSWORD) && caption != null && toGet == caption) {
                model.addAttribute("name", info.getName());
                return "secret";
            }
        } else {
            if (password.equals(Constants.PASSWORD)) {
                model.addAttribute("name", info.getName());
                return "secret";
            }
        }

        counter++;
        if(capNeeded){
            capNeeded = true;
            if (counter > 3 && capNeeded) {
                session.invalidate();
                return "block";
            }
        }

        if (counter > 3) {
            counter = 0;
            capNeeded = true;
        }

        System.out.printf("Counter: %d capNeeded: %b\n",counter,capNeeded);

        session.setAttribute("counter", counter);
        session.setAttribute("captionNeeded", capNeeded);
        model.addAttribute("counter", counter);

        return "login";
    }
}


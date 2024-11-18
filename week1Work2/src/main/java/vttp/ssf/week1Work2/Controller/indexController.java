package vttp.ssf.week1Work2.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.week1Work2.Model.taskToDo;

@Controller
@RequestMapping(path = { "/", "index.html" })
public class indexController {
   @GetMapping
   public String getIndex(Model model) {

      model.addAttribute("tasksTodo", new taskToDo());
      model.addAttribute("Number", 0);
      return "index";
   }

}

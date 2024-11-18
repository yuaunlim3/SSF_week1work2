package vttp.ssf.week1Work2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.ssf.week1Work2.Model.taskToDo;

@Controller
@RequestMapping
public class saveController {

    @PostMapping("/exit")
    public String postExit(Model model, @RequestParam(required = false) String hiddenValues) {
        hiddenValues = "";
        taskToDo tasksTodo = new taskToDo();
        hiddenValues = "";

        model.addAttribute("tasksTodo", tasksTodo);
        model.addAttribute("hiddenValues", hiddenValues);

        return "index";
    }
}
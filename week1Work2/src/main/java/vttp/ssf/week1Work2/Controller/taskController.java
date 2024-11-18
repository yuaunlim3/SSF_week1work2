package vttp.ssf.week1Work2.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import vttp.ssf.week1Work2.Model.taskToDo;

@Controller
@RequestMapping("/toDoList")
public class taskController {

    @PostMapping
    public String getTask(
        @Valid @ModelAttribute("tasksTodo") taskToDo task, 
        BindingResult bindings,
        @RequestParam(required = false) String hiddenValues,
        Model model
    ){
        if (hiddenValues == null) {
            hiddenValues = "";
        }

        List<taskToDo> reglist = new ArrayList<>();

        String tasksDone = task.toString() + "|";
        hiddenValues += tasksDone;
        String[] tasks = hiddenValues.split("\\|");
        //System.out.printf("Hidden Values: %s\n",hiddenValues);
        //System.out.printf("Tasks to add: %s\n",tasks);
        for(String infos: tasks){
            //System.out.printf("the task is: %s\n",infos);
            String[] info = infos.split(",");
            taskToDo toDo = new taskToDo();
            toDo.setTask(info[0]);
            toDo.setPriority(info[1]);
            toDo.setDate(LocalDate.parse(info[2]));

            reglist.add(toDo);
        }
    

    
        model.addAttribute("hiddenValues", hiddenValues);
        model.addAttribute("Number", tasksDone);
        model.addAttribute("reglist", reglist);
        model.addAttribute("Number", reglist.size());
    
        return "index"; 
    }
    

}

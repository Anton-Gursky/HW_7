package Task_34.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/")
    public ModelAndView home() {

        List<Students> listStudent = studentsService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listStudent", listStudent);
        return mav;
    }

    @RequestMapping("/new")
    public String newStudentsForm(Map<String, Object> model) {

        Students students = new Students();
        model.put("students", students);
        return "new_student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("students") Students students) {

        studentsService.save(students);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editStudentsForm(@RequestParam long id) {

        ModelAndView mav = new ModelAndView("edit_student");
        Students students = studentsService.get(id);
        mav.addObject("students", students);
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteStudentForm(@RequestParam long id) {
        studentsService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Students> result = studentsService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }
}

package com.example.minitest.controller;

import com.example.minitest.model.Class;
import com.example.minitest.model.Students;
import com.example.minitest.service.IClassService;
import com.example.minitest.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentsService studentsService;
    @Autowired
    private IClassService classService;

    @ModelAttribute("classesList")
    public Iterable<Class> findAll(){
        return classService.findAll();
    }
    @GetMapping()
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/Students/home");
        modelAndView.addObject("students",studentsService.findAll());
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam("name")String a){
        studentsService.search(a);
        ModelAndView modelAndView = new ModelAndView("/Students/page");
        modelAndView.addObject("students",studentsService.search(a));
        return modelAndView;
    }
    @GetMapping("/searchPage")
    public ModelAndView searchPage(@RequestParam("name")String a,@PageableDefault(value = 2 )Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/Students/page");
        modelAndView.addObject("students",studentsService.searchPage(a,pageable));
        modelAndView.addObject("search",a);
        return modelAndView;
    }

    @GetMapping("/page")
    public ModelAndView page(@PageableDefault(value = 2 )Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/Students/page");
        modelAndView.addObject("students",studentsService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView =new ModelAndView("/Students/create");
        modelAndView.addObject("students",new Students());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Class classes = studentsService.findByID(id).getClasses();
        classes.setQuantity(classes.getQuantity() - 1);
        classService.save(classes);
        studentsService.remove(id);
        return "redirect:/students/page";
    }
    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute Students students){
        studentsService.save(students);
        if(students!= null){
            Class classes = students.getClasses();
            classes.setQuantity(classes.getQuantity()+1);
            classService.save(classes);
        }
        ModelAndView modelAndView = new ModelAndView("/Students/home");
        modelAndView.addObject("students",studentsService.findAll());
        return modelAndView;

    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/Students/edit");
        modelAndView.addObject("students",studentsService.findByID(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("students") Students students){
        studentsService.save(students);
        ModelAndView modelAndView = new ModelAndView("/Students/edit");
        modelAndView.addObject("students",students);
        modelAndView.addObject("message","Edit okay");
        return modelAndView;
    }


    @GetMapping("/sort")
    public ModelAndView sort(@RequestParam("sort") String str){
        if(str.equals("point")){
           List<Students> studentsList= studentsService.sort();
            ModelAndView modelAndView = new ModelAndView("/Students/home");
            modelAndView.addObject("students",studentsList);
            return modelAndView;
        }else {
            List<Students> studentsList= studentsService.sortByAge();
            ModelAndView modelAndView = new ModelAndView("/Students/home");
            modelAndView.addObject("students",studentsList);
            return modelAndView;
        }
    }
    @GetMapping("/searchClass")
    public ModelAndView sortByClass(@RequestParam("id") Long id,@PageableDefault(value = 2) Pageable pageable){
        Class classes = classService.findByID(id);
        studentsService.searchClass(classes,pageable);
        ModelAndView modelAndView = new ModelAndView("/Students/page");
        modelAndView.addObject("students",studentsService.searchClass(classes,pageable));
        modelAndView.addObject("id",id);
        return modelAndView;
    }

}

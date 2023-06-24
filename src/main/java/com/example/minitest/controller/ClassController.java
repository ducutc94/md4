package com.example.minitest.controller;

import com.example.minitest.model.Class;
import com.example.minitest.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/class")

public class ClassController {
    @Autowired
    private IClassService classService;

    @GetMapping()
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/Class/ClassHome");
        modelAndView.addObject("classes", classService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createClass() {
        ModelAndView modelAndView = new ModelAndView("/Class/create");
        modelAndView.addObject("classes", new Class());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveClass(@ModelAttribute("classes") Class classes) {
        ModelAndView modelAndView = new ModelAndView("/Class/create");
        classes.setQuantity(0);
        classService.save(classes);
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("message", "Create okay");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        classService.remove(id);
        return "redirect:/class";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Class classes = classService.findByID(id);
        ModelAndView modelAndView = new ModelAndView("/Class/edit");
        modelAndView.addObject("classes", classes);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editClass(@ModelAttribute("classes") Class classes) {
        ModelAndView modelAndView = new ModelAndView("/Class/edit");
        classService.save(classes);
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("message", "Edit okay");
        return modelAndView;
    }
}

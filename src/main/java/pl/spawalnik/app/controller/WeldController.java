package pl.spawalnik.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.spawalnik.app.model.Drawing;
import pl.spawalnik.app.model.Weld;
import pl.spawalnik.app.model.Welder;
import pl.spawalnik.app.service.DrawingService;
import pl.spawalnik.app.service.WeldService;
import pl.spawalnik.app.service.WelderService;

import java.util.List;

@Controller
@RequestMapping("/welds")
public class WeldController {

    @Autowired
    private WeldService weldService;

    @Autowired
    private DrawingService drawingService;

    @Autowired
    private WelderService welderService;

    @ModelAttribute("drawings")
    public List<Drawing> getDrawings() {
        return drawingService.findAll();
    }

    @ModelAttribute("welders")
    public List<Welder> getWelders() {
        return welderService.findAll();
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("welds", weldService.findAll());
        return "weldList";
    }

    @GetMapping("/add")
    public String addWeld(Model model){
        model.addAttribute("weld", new Weld());
        return "weld";
    }

    @PostMapping("/add")
    public String addWeld(@ModelAttribute Weld weld){
        weldService.save(weld);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteWeld(@PathVariable Long id) {
        weldService.delete(id);
        return "redirect:../list";
    }


    @GetMapping("/update/{id}")
    public String updateWeld(@PathVariable Long id, Model model) {
        Weld weld = weldService.findById(id);
        model.addAttribute("weld", weld);
        return "weld";
    }

    @PostMapping("/update/{id}")
    public String updateWeld(@ModelAttribute Weld weld) {
        weldService.save(weld);
        return "redirect:../list";
    }



}

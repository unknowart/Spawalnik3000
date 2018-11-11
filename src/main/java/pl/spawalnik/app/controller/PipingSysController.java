package pl.spawalnik.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.spawalnik.app.model.Drawing;
import pl.spawalnik.app.model.PipingSys;
import pl.spawalnik.app.model.Weld;
import pl.spawalnik.app.service.DrawingService;
import pl.spawalnik.app.service.PipingSysService;
import pl.spawalnik.app.service.WeldService;

import java.util.List;

@Controller
@RequestMapping("/system")
public class PipingSysController {

    @Autowired
    private PipingSysService pipingSysService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("systems", pipingSysService.findAll());
        return "pipingSysList";
    }

    @GetMapping("/add")
    public String addSystem(Model model){
        model.addAttribute("system", new PipingSys());
        return "pipingSys";
    }

    @PostMapping("/add")
    public String addSystem(@ModelAttribute PipingSys pipingSys){
        pipingSysService.save(pipingSys);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSystem(@PathVariable Long id) {
        pipingSysService.delete(id);
        return "redirect:../list";
    }


    @GetMapping("/update/{id}")
    public String updateSystem(@PathVariable Long id, Model model) {
        PipingSys pipingSys = pipingSysService.findById(id);
        model.addAttribute("system", pipingSys);
        return "pipingSys";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@ModelAttribute PipingSys pipingSys) {
        pipingSysService.save(pipingSys);
        return "redirect:../list";
    }
}

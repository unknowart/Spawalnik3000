package pl.spawalnik.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.spawalnik.app.model.Weld;
import pl.spawalnik.app.model.Welder;
import pl.spawalnik.app.service.WeldService;
import pl.spawalnik.app.service.WelderService;

import java.util.List;

@Controller
@RequestMapping("/welders")
public class WelderController {

    @Autowired
    private WelderService welderService;

    @Autowired
    private WeldService weldService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("welders", welderService.findAll());
        model.addAttribute("welds", weldService.findAll());
        return "welderList";
    }

    @GetMapping("/add")
    public String addWelder(Model model){
        model.addAttribute("welder", new Welder());
        return "welder";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Welder welder){
        welderService.save(welder);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteWelder(@PathVariable Long id) {
        welderService.delete(id);
        return "redirect:../list";
    }


    @GetMapping("/update/{id}")
    public String updateWelder(@PathVariable Long id, Model model) {
        Welder welder = welderService.findById(id);
        model.addAttribute("welder", welder);
        return "welder";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@ModelAttribute Welder welder) {
        welderService.save(welder);
        return "redirect:../list";
    }
}

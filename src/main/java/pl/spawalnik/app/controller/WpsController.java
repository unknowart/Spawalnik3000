package pl.spawalnik.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.spawalnik.app.model.Welder;
import pl.spawalnik.app.model.Wps;
import pl.spawalnik.app.service.WelderService;
import pl.spawalnik.app.service.WpsService;

@Controller
@RequestMapping("/wps")
public class WpsController {


    @Autowired
    private WpsService wpsService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("wpses", wpsService.findAll());
        return "wpsList";
    }

    @GetMapping("/add")
    public String addWps(Model model){
        model.addAttribute("wps", new Wps());
        return "wps";
    }

    @PostMapping("/add")
    public String addWps(@ModelAttribute Wps wps){
        wpsService.save(wps);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteWps(@PathVariable Long id) {
        wpsService.delete(id);
        return "redirect:../list";
    }


    @GetMapping("/update/{id}")
    public String updateWps(@PathVariable Long id, Model model) {
        Wps wps = wpsService.findById(id);
        model.addAttribute("wps", wps);
        return "wps";
    }

    @PostMapping("/update/{id}")
    public String updateWps(@ModelAttribute Wps wps) {
        wpsService.save(wps);
        return "redirect:../list";
    }
}

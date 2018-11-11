package pl.spawalnik.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.spawalnik.app.model.*;
import pl.spawalnik.app.service.*;

import java.util.List;

@Controller
@RequestMapping("/drawings")
public class DrawingController {

    @Autowired
    private DrawingService drawingService;

    @Autowired
    private PipingSysService pipingSysService;

    @Autowired
    private WeldService weldService;

    @Autowired
    private WelderService welderService;

    @Autowired
    private WpsService wpsService;

    @ModelAttribute("wpses")
    public List<Wps> getWps() {
        return wpsService.findAll();
    }

    @ModelAttribute("welders")
    public List<Welder> getWelders() {
        return welderService.findAll();
    }

    @ModelAttribute("pipingSys")
    public List<PipingSys> getPipingSys() {
        return pipingSysService.findAll();
    }

    @ModelAttribute("weld")
    public Weld getWeld() {
        return new Weld();
    }

    @ModelAttribute("welds")
    public List<Weld> getWelds() {
        List<Weld> weldList = weldService.findAll();
        return weldList;
    }




    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("drawings", drawingService.findAll());
        return "drawingList";
    }

    @GetMapping("/add")
    public String addDrawing(Model model){
        model.addAttribute("drawing", new Drawing());
        return "drawing";
    }

    @PostMapping("/add")
    public String addDrawing(@ModelAttribute Drawing drawing){
        drawingService.save(drawing);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleDrawing(@PathVariable Long id) {
        Long idSys = drawingService.findById(id).getPipingSys().getId();
        drawingService.delete(id);
        return "redirect:../list/"+idSys;
    }


    @GetMapping("/update/{id}")
    public String updateDrawing(@PathVariable Long id, Model model) {
        Drawing drawing = drawingService.findById(id);
        model.addAttribute("drawing", drawing);
        return "drawing";
    }

    @PostMapping("/update/{id}")
    public String updateDrawing(@ModelAttribute Drawing drawing) {
        drawingService.save(drawing);
        return "redirect:../list";
    }



    @GetMapping("/sheet")
    public String sheet(Model model){
        List<Weld> list = weldService.findAll();
        list.add(new Weld());
        DwgW dwgW = new DwgW();
        dwgW.setWeldList(list);
        model.addAttribute("dwgW", dwgW);
        return "drawingSheet";
    }

    //DRAWING
    @GetMapping("/list/{id}")
    public String findAllFromSystem(@PathVariable Long id, Model model){
        int rtA = weldService.findAllByRtBySystem(id).size();
        int ptA = weldService.findAllByPtBySystem(id).size();
        int b =  weldService.findAllBySystemId(id).size();

        double percRt = (double)rtA/(double)b*100;
        double percPt = (double)ptA/(double)b*100;
        int c = (int)percRt;
        int d = (int)percPt;
        model.addAttribute("percRt", c);
        model.addAttribute("percPt", d);
        model.addAttribute("allWelds", b);
        model.addAttribute("rtTested", rtA);
        model.addAttribute("ptTested", ptA);

        model.addAttribute("system", pipingSysService.findById(id));
        model.addAttribute("drawings", drawingService.findAllFromSystem(id));
        return "drawingList";
    }

    @GetMapping("/add/{idSys}")
    public String addDrawing(@PathVariable Long idSys, Model model){
        Drawing drawing = new Drawing();
        drawing.setPipingSys(pipingSysService.findById(idSys));
        model.addAttribute("drawing", drawing);
        model.addAttribute("system", pipingSysService.findById(idSys));
        return "drawing";
    }

    @PostMapping("/add/{idSys}")
    public String addDrawing(@PathVariable Long idSys, Model model, @ModelAttribute Drawing drawing){
        drawingService.save(drawing);
        model.addAttribute("system", pipingSysService.findById(idSys));
        return "redirect:../list/"+idSys;
    }

    @GetMapping("/delete/{idSys}/{id}")
    public String deleDrawing(@PathVariable Long idSys, @PathVariable Long id) {
        drawingService.delete(id);
        return "redirect:../list/"+idSys;
    }


    @GetMapping("/update/{idSys}/{id}")
    public String updateDrawing(@PathVariable Long idSys, @PathVariable Long id, Model model) {
        Drawing drawing = drawingService.findById(id);
        model.addAttribute("drawing", drawing);
        model.addAttribute("system", pipingSysService.findById(idSys));
        return "drawing";
    }

    @PostMapping("/update/{idSys}")
    public String updateDrawing(@PathVariable Long idSys, @ModelAttribute Drawing drawing, Model model) {
        drawingService.save(drawing);
        model.addAttribute("system", pipingSysService.findById(idSys));
        return "redirect:../list/"+idSys;
    }



    // SHEET WELD
    @GetMapping("/sheet/{idSys}/{idDwg}")
    public String sheet(@PathVariable Long idDwg, @PathVariable Long idSys, Model model){
        model.addAttribute("system", pipingSysService.findById(idSys));
        Weld weld = new Weld();
        weld.setDrawing(drawingService.findById(idDwg));
        weld.setPipingSys(pipingSysService.findById(idSys));


        List<Weld> list = weldService.findAllByDrawingId(idDwg);
        list.add(weld);

        DwgW dwgW = new DwgW();
        dwgW.setWeldList(list);
        model.addAttribute("drawing", drawingService.findById(idDwg));
        model.addAttribute("dwgW", dwgW);
        return "drawingSheet";
    }

    @PostMapping("/sheet/{idSys}/{idDwg}")
    public String sheet(@PathVariable Long idSys, @PathVariable Long idDwg, @ModelAttribute Weld weld, Model model){
        weld.setDrawing(drawingService.findById(idDwg));
        weld.setPipingSys(pipingSysService.findById(idSys));

        List<Wps> tempWps = wpsService.findByDiameter(weld.getDiameter());
        weld.setWps(tempWps.get(0));
        System.out.println(weld.getWps().toString());
        weldService.save(weld);

        List<Weld> list = weldService.findAllByDrawingId(idDwg);
        Weld tempWeld = new Weld();
        tempWeld.setDrawing(drawingService.findById(idDwg));
        list.add(tempWeld);

        DwgW dwgW = new DwgW();
        dwgW.setWeldList(list);
        model.addAttribute("dwgW", dwgW);
        model.addAttribute("drawing", drawingService.findById(idDwg));
        model.addAttribute("system", pipingSysService.findById(idSys));

        return "drawingSheet";
    }

    @GetMapping("/sheet/delete/{idSys}/{idDwg}/{id}")
    public String deleteWeld(@PathVariable Long idSys, @PathVariable Long idDwg, @PathVariable Long id) {
        weldService.delete(id);
        return "redirect:../../../"+idSys+"/"+idDwg;
    }


    //Print
    @GetMapping("/sheet/full/{idSys}/{idDwg}")
    private String fullList(@PathVariable Long idSys, @PathVariable Long idDwg, Model model){
        model.addAttribute("drawing", drawingService.findById(idDwg));
        model.addAttribute("system", pipingSysService.findById(idSys));

        List<Weld> list = weldService.findAllByDrawingId(idDwg);
        model.addAttribute("welds", list);
        return "printAll";
    }


}

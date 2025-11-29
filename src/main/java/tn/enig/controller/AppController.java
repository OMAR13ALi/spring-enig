package tn.enig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.enig.dao.IAdherant;
import tn.enig.dao.IEmprunt;
import tn.enig.dao.ILivre;
import tn.enig.model.Emprunt;
import tn.enig.model.Livre;

@Controller
public class AppController {

    @Autowired
    private ILivre livredoa;

    @Autowired
    private IAdherant adherantdoa;
    @Autowired
    private IEmprunt empruntdoa;




    @GetMapping("/listeslivre")
    public String listeLivre(Model model) {
        model.addAttribute("livres", livredoa.findAll());
        return "listeslivre";
    }

    @GetMapping("/listesadherant")
    public String listeAdherant(Model model) {
        model.addAttribute("adherants", adherantdoa.findAll());
        return "listesadherant";
    }

    @GetMapping("/ajoutlivre")
    public String ajoutLivre(Model model) {
        model.addAttribute("livre", new Livre());
        return "ajoutlivre";
    }

    @PostMapping("/savelivre")
    public String saveLivre(@ModelAttribute Livre livre, Model model) {
        livredoa.save(livre);
        return "redirect:/listeslivre";

    }

    @GetMapping("/ajoutemprunt")
    public String ajoutemprunt(Model model) {
        model.addAttribute("livres", livredoa.findAll());
        model.addAttribute("adherants", adherantdoa.findAll());
        model.addAttribute("emprunt", new Emprunt());
        return "ajoutemprunt";


    }

    @PostMapping("/saveemprunt")
    public String saveEmprunt(@ModelAttribute Emprunt emprunt, Model model) {
        empruntdoa.save(emprunt);
        return "redirect:/listesadherant";
    }

   /* @GetMapping("/listeempruntlivre/{id}")
    public String listeempruntlivre(@PathVariable("id") Integer id, Model model) {
        Livre livre =
    }*/
}

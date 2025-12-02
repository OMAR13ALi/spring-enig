package tn.enig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.enig.dao.IAdherant;
import tn.enig.dao.IEmprunt;
import tn.enig.dao.ILivre;
import tn.enig.model.Adherant;
import tn.enig.model.Emprunt;
import tn.enig.model.Livre;

import java.util.List;

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

    @GetMapping("/empruntsadherant/{ida}")
    public String listeEmpruntsAdherant(@PathVariable("ida") Integer ida, Model model) {
        Adherant adherant = adherantdoa.findById(ida).orElse(null);
        if (adherant == null) {
            return "redirect:/listesadherant";
        }
        List<Emprunt> emprunts = empruntdoa.findByAdherant(adherant);
        model.addAttribute("adherant", adherant);
        model.addAttribute("emprunts", emprunts);
        return "empruntsadherant";
    }

    @GetMapping("/empruntslivre/{id}")
    public String listeEmpruntsLivre(@PathVariable("id") Integer id, Model model) {
        Livre livre = livredoa.findById(id).orElse(null);
        if (livre == null) {
            return "redirect:/listeslivre";
        }
        List<Emprunt> emprunts = empruntdoa.findByLivre(livre);
        model.addAttribute("livre", livre);
        model.addAttribute("emprunts", emprunts);
        return "empruntslivre";
    }

    @GetMapping("/deletelivre/{id}")
    public String deleteLivre(@PathVariable("id") Integer id) {
        livredoa.deleteById(id);
        return "redirect:/listeslivre";
    }

    @GetMapping("/deleteemprunt/{ide}")
    public String deleteEmprunt(@PathVariable("ide") Integer ide) {
        empruntdoa.deleteById(ide);
        return "redirect:/listesadherant";
    }

    // Custom 403 error page handler
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

}

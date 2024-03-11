package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloListController {

    @Autowired
    private ListContentRepository listContentRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<ListContent> listContents = listContentRepository.findAll();
        model.addAttribute("list", listContents);
        return "admin";
    }

    @PostMapping("/")
    public String addContent(
            @RequestParam String link,
            @RequestParam String otsikko,
            @RequestParam String kuvaus,
            @RequestParam String avainsana) {
        ListContent listContent = new ListContent();
        listContent.setLink(link);
        listContent.setOtsikko(otsikko);
        listContent.setKuvaus(kuvaus);
        listContent.setAvainsana(avainsana);
        listContentRepository.save(listContent);
        return "redirect:/admin";
    }

    @PostMapping("/remove/{id}")
    public String removeContent(@PathVariable Long id) {
        listContentRepository.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/remove/all")
    public String removeAll() {
        listContentRepository.deleteAll();
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<ListContent> listContents = listContentRepository.findAll();
        model.addAttribute("list", listContents);
        return "list";
    }
}

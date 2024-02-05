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
    public String home(Model model) {
        List<ListContent> listContents = listContentRepository.findAll();
        model.addAttribute("list", listContents);
        return "index";
    }

    @PostMapping("/")
    public String addContent(@RequestParam String content) {
        ListContent listContent = new ListContent(content.trim());
        listContentRepository.save(listContent);
        return "redirect:/list";
    }

    @PostMapping("/remove/{id}")
    public String removeContent(@PathVariable Long id) {
        listContentRepository.deleteById(id);
        return "redirect:/list";
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

package com.example.it210dgnl005.controller;

import com.example.it210dgnl005.model.Spacecraft;
import com.example.it210dgnl005.service.ISpacecraftService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.internal.util.collections.ArrayHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
    @RequestMapping("/spacecraft")
@RequiredArgsConstructor
public class SpacecraftController {
    @Autowired
    private ISpacecraftService service;

    @GetMapping
    public String list(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "false") String keyword,
            Model model
    ){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Spacecraft> data;

        if(keyword != null && !keyword.isEmpty()){
            data = service.search(keyword, pageable);
            model.addAttribute("Keyword", keyword);
        }else {
            data = service.findAll(pageable);
        }

        model.addAttribute("list", data);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("spacecraft", new Spacecraft());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("spacecraft") Spacecraft spacecraft,
                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form";
        }
        service.save(spacecraft);
        return "redirect:/spacecraft";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Spacecraft s = service.findById(id).orElse(null);
        model.addAttribute("spacecraft", s);
        return "form";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/spacecraft";
    }
}

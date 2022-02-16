package com.baithi_md4.controller;

import com.baithi_md4.model.City;
import com.baithi_md4.model.QuocGia;
import com.baithi_md4.service.CityServiceImpl;
import com.baithi_md4.service.QuocGiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CityController {
    @Autowired
    CityServiceImpl cityService;
    @Autowired
    QuocGiaServiceImpl quocGiaService;

    @ModelAttribute("quocgia")
    public List<QuocGia> showList(){
        return quocGiaService.findAll();
    }
    @ModelAttribute("city")
    public City getUsers(){
        return  new City();
    }

    @GetMapping("/city")
    public ModelAndView showAll(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("city",cityService.findAll(PageRequest.of(page,4)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("createcity");
        modelAndView.addObject("users", new City());
        return modelAndView;
    }

    @PostMapping("create")
    public Object add(@Valid @ModelAttribute(value = "city") City city, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("createcity");
            return modelAndView;
        }
        cityService.save(city);
        return "redirect:/city";
    }

    @GetMapping("edit")
    public ModelAndView edit(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("editcity");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("edit")
    public String editUser(@Valid @ModelAttribute(value = "city") City city, BindingResult bindingResult) {
//        validate_userName.validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "redirect:/editcity";
        }
        cityService.save(city);
        return "redirect:/city";
    }

    @GetMapping("/delete")
    public ModelAndView deleteForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("deletecity");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }
    @GetMapping("/detail")
    public ModelAndView detailCity(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("detailcity");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        cityService.delete(id);
        return "redirect:/city";
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam (value = "search") String search,@RequestParam (defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("city", cityService.findUsersByName(search,PageRequest.of(page,4)));
        return modelAndView;
    }

}

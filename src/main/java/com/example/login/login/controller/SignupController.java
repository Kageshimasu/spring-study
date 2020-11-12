package com.example.login.login.controller;

import com.example.login.login.domain.model.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;


import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class SignupController {

    private Map<String, String> radioMarriage;

    private Map<String, String> initRadioMarrige() {
        Map<String, String> radio = new LinkedHashMap<>();
        radio.put("既婚", "true");
        radio.put("未婚", "false");

        return radio;
    }

    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form, Model model) {
        radioMarriage = initRadioMarrige();
        model.addAttribute("radioMarriage", radioMarriage);
        return "login/signup";
    }

    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return getSignUp(form, model);
        }

        System.out.println(form);

        return "redirect:/login";
    }
}

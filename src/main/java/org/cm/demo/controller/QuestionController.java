package org.cm.demo.controller;

import org.cm.demo.entity.ChooseQuestion;
import org.cm.demo.service.IChooseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private IChooseQuestionService questionService;

    @GetMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<ChooseQuestion> questions = questionService.findAll();
        model.addAttribute("questions", questions);
        return "question/list";
    }
}

package com.kude.communication.controller;

import com.kude.communication.dto.CommentCreateDTO;
import com.kude.communication.dto.CommentDTO;
import com.kude.communication.dto.QuestionDTO;
import com.kude.communication.service.CommentService;
import com.kude.communication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/2 16:55
 * @Message
 */
@Controller
public class QuestionController {


    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(id);

        List<CommentDTO>  comments= commentService.listByQuestionId(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        return "question";
    }
}

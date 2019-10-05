package com.kude.communication.controller;

import com.kude.communication.dto.PaginationDTO;
import com.kude.communication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author liyage LOL_tOulan
 * @Time 2019/8/13 16:37
 * @Message 测试
 */
@Controller
public class IndexController {


    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "10") Integer size

    ) {
        //通过List方法获取到Question集合中的对象
        PaginationDTO pagination = questionService.selectList(page, size);
        //model的作用是将数据显示到前端界面上
        model.addAttribute("pagination", pagination);
        return "index";
    }
}

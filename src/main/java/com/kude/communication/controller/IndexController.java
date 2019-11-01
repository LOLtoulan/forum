package com.kude.communication.controller;

import com.kude.communication.cache.HotTagCache;
import com.kude.communication.dto.PaginationDTO;
import com.kude.communication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author liyage LOL_tOulan
 * @Time 2019/8/13 16:37
 * @Message 测试
 */
@Controller
public class IndexController {


    @Autowired
    private QuestionService questionService;
//    @Autowired
//    private HotTagCache hotTagCache;
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "2") Integer size,
                        @RequestParam(name = "search", value = "search",required = false) String search,
                        @RequestParam(name = "tag", required = false) String tag) {
        PaginationDTO pagination = questionService.list(search, tag, page, size);
//        List<String> tags = hotTagCache.getHots();
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        model.addAttribute("tag", tag);
//        model.addAttribute("tags", tags);
        return "index";
    }
}

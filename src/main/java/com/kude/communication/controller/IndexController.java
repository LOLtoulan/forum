package com.kude.communication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author liyage LOL_tOulan
 * @Time 2019/8/13 16:37
 * @Message 测试
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {

        return "index";
    }
}

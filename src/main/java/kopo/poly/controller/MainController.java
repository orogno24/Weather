package kopo.poly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {


    @GetMapping("/index")
    public String index() throws Exception {
        log.info(this.getClass().getName() + ".index Start!");
        return "/index";
    }
    @GetMapping("/url")
    public String url() throws Exception {
        log.info(this.getClass().getName() + ".index Start!");
        return "/url";
    }

    @GetMapping("/searchFeed")
    public String searchFeed() throws Exception {
        log.info(this.getClass().getName() + ".searchFeed 함수 실행");
        return "/searchFeed";
    }

//    @GetMapping("/profile")
//    public String profile() throws Exception {
//        log.info(this.getClass().getName() + ".profile 함수 실행");
//
//        return "/profile";
//    }

    @GetMapping("/hashinsert")
    public String hashinsert() throws Exception {
        log.info(this.getClass().getName() + ".hashinsert 함수 실행");

        return "/hashinsert";
    }
}

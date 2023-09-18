package kopo.poly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/main")
    public String main() throws Exception {
        log.info(this.getClass().getName() + ".main 함수 실행");
        return "/main";
    }
    @GetMapping("/index")
    public String index() throws Exception {
        log.info(this.getClass().getName() + ".index Start!");
        return "/index";
    }
    @GetMapping("/test")
    public String test() throws Exception {
        log.info(this.getClass().getName() + ".test 함수 실행");
        return "/test";
    }
    @GetMapping("/url")
    public String url() throws Exception {
        log.info(this.getClass().getName() + ".index Start!");
        return "/url";
    }
    @GetMapping("/index4")
    public String index4() throws Exception {
        log.info(this.getClass().getName() + ".index4 함수 실행");
        return "/index4";
    }
    @GetMapping("/index6")
    public String index6() throws Exception {
        log.info(this.getClass().getName() + ".index6 함수 실행");
        return "/index6";
    }
    @GetMapping("/index8")
    public String index8() throws Exception {
        log.info(this.getClass().getName() + ".index8 함수 실행");
        return "/index8";
    }
    @GetMapping("/searchFeed")
    public String searchFeed() throws Exception {
        log.info(this.getClass().getName() + ".searchFeed 함수 실행");
        return "/searchFeed";
    }

    @GetMapping("/profile")
    public String profile() throws Exception {
        log.info(this.getClass().getName() + ".profile 함수 실행");

        return "/profile";
    }
}

package kopo.poly.controller;

import kopo.poly.dto.UserInfo2DTO;
import kopo.poly.service.IUserInfo2Service;
import kopo.poly.util.CmmUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
public class NoticeController2 {

    private final IUserInfo2Service noticeService2;

    @PostMapping(value = "/index8Update")
    public String updateNoticeInfo2(HttpSession session, ModelMap model, HttpServletRequest request){

        log.info(this.getClass().getName() + ".noticeUpdate2 Start!");

        String msg = "";
        String url = "/index6";

        try {
            String user_intro = CmmUtil.nvl( request.getParameter("user_intro"));
            String user_nick = CmmUtil.nvl( request.getParameter("user_nick"));

            log.info("user_intro : " + user_intro);
            log.info("user_nick : " + user_nick);

            UserInfo2DTO pDTO = new UserInfo2DTO();
            pDTO.setUser_intro(user_intro);
            pDTO.setUser_nick(user_nick);

            noticeService2.updateNoticeInfo2(pDTO);

            msg = "수정되었습니다.";
        } catch (Exception e){
            msg = "실패하였습니다. : " + e.getMessage();
            log.info(e.toString());
            e.printStackTrace();
        } finally {
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            log.info(this.getClass().getName() + ".noticeUpdate2 End!");
        }

        return "/redirect";
    }

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestPart MultipartFile file, ModelMap model) throws Exception {

        log.info(this.getClass().getName() + ".upload Start!");

        noticeService2.uploadFile(file);

        String msg = "수정되었습니다.";
        model.addAttribute("msg", msg);

        return "/profile";
    }

}

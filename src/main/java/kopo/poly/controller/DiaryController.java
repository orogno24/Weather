package kopo.poly.controller;

import kopo.poly.dto.*;
import kopo.poly.service.IDairyService;
import kopo.poly.util.CmmUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class DiaryController {
    private final IDairyService dairyService;

    @GetMapping(value = "getfollowingId")
    public String getfollowingId(HttpSession session, ModelMap model) throws Exception {
        log.info(this.getClass().getName() + ".getfollowingId 시작!");

        String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
        log.info("user_id : " + user_id);

        FollowDTO pDTO = new FollowDTO();
        pDTO.setFollow_id(user_id);

        List<FollowDTO> rList = Optional.ofNullable(dairyService.getfollowingId(pDTO))
                .orElseGet(ArrayList::new);

        model.addAttribute("rList", rList);

        log.info("Controller Layer rList content: {}", rList);
        log.info("rList size: " + rList.size());

        log.info(this.getClass().getName() + ".getfollowingId End!");

        return "/getfollowingId";
    }

    @GetMapping(value = "getfollowId")
    public String getfollowId(HttpSession session, ModelMap model) throws Exception {
        log.info(this.getClass().getName() + ".getfollowId 시작!");

        String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
        log.info("user_id : " + user_id);

        FollowDTO pDTO = new FollowDTO();
        pDTO.setFollowing_id(user_id);

        List<FollowDTO> rList = Optional.ofNullable(dairyService.getfollowId(pDTO))
                .orElseGet(ArrayList::new);

        model.addAttribute("rList", rList);

        log.info("Controller Layer rList content: {}", rList);
        log.info("rList size: " + rList.size());

        log.info(this.getClass().getName() + ".getfollowId End!");

        return "/getfollowId";
    }

    @GetMapping(value = "countfollow")
    public String countfollow(HttpSession session, ModelMap model) throws Exception {
        log.info(this.getClass().getName() + ".getfollowId 시작!");

        String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
        log.info("user_id : " + user_id);

        FollowDTO pDTO = new FollowDTO();
        pDTO.setFollow_id(user_id);
        pDTO.setFollowing_id(user_id);

        FollowDTO rDTO = Optional.ofNullable(dairyService.countfollow(pDTO, true))
                .orElseGet(FollowDTO::new);

        model.addAttribute("rDTO", rDTO);

        log.info("Controller Layer rList content: {}", rDTO);

        log.info(this.getClass().getName() + ".getfollowId End!");

        return "/countfollow";
    }


    @GetMapping(value = "profile")
    public String profile(HttpSession session, ModelMap model) throws Exception {
        log.info(this.getClass().getName() + ".profile 함수 실행");

        String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
        log.info("user_id : " + user_id);

        UserInfoDTO pDTO = new UserInfoDTO();
        pDTO.setUser_id(user_id);

        UserInfoDTO rDTO = Optional.ofNullable(dairyService.getnick(pDTO, true))
                .orElseGet(UserInfoDTO::new);

        model.addAttribute("rDTO", rDTO);

        log.info("user_nick : " + rDTO.getUser_nick());
        log.info("user_intro : " + rDTO.getUser_intro());

        log.info(this.getClass().getName() + ".profile End!");

        return "/profile";
    }

    @PostMapping(value = "/uploadPhoto")
    public String uploadPhoto(@RequestPart MultipartFile file, ModelMap model, HttpSession session) throws Exception {

        log.info(this.getClass().getName() + ".uploadPhoto Start!");

        dairyService.uploadFile(file, session);

        String msg = "수정되었습니다.";
        model.addAttribute("msg", msg);

        return "/profile";
    }



    @ResponseBody
    @PostMapping(value = "getHashtag")
    public List<DiaryDTO> getHashtag(HttpServletRequest request) throws Exception {
        log.info(this.getClass().getName() + ".getHashtag 시작!");

        String hashtagId = CmmUtil.nvl(request.getParameter("hashtagId"));
        log.info("hashtagId : " + hashtagId);

        HashtagdiaryDTO pDTO = new HashtagdiaryDTO();
        pDTO.setHashtagId(hashtagId);

        List<DiaryDTO> rList = Optional.ofNullable(dairyService.getHashtag(pDTO))
                .orElseGet(ArrayList::new);

        log.info("Controller Layer rList content: {}", rList);

        log.info("rList size: " + rList.size());
        log.info(this.getClass().getName() + ".getHashtag End!");

        return rList;
    }

    @PostMapping(value = "/insertHashtag")
    public String insertHashtag(HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName() + ".insertHashtag 시작!");

        String msg = "";
        String url = "/hashinsert";

        try {
            String hashtagId = CmmUtil.nvl(request.getParameter("hashtagId"));

            log.info("hashtagId : " + hashtagId);

            msg = "해시태그 추가 성공";

            HashtagdiaryDTO pDTO = new HashtagdiaryDTO();

            pDTO.setHashtagId(hashtagId);

            dairyService.insertHashtag(pDTO);

        } catch (Exception e) {
            msg = "실패하였습니다. : " + e.getMessage();
            log.info(e.toString());
            e.printStackTrace();
        } finally {
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            log.info(this.getClass().getName() + ".insertHashtag End!");
        }

        return "/redirect";
    }

    @PostMapping(value = "/profileUpdate")
    public String profileUpdate(HttpSession session, ModelMap model, HttpServletRequest request) {

        log.info(this.getClass().getName() + ".profileUpdate Start!");

        String msg = "";
        String url = "/searchFeed";

        try {
            String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
            String user_intro = CmmUtil.nvl(request.getParameter("user_intro"));
            String user_nick = CmmUtil.nvl(request.getParameter("user_nick"));

            log.info("user_id : " + user_id);
            log.info("user_intro : " + user_intro);
            log.info("user_nick : " + user_nick);

            UserInfoDTO pDTO = new UserInfoDTO();
            pDTO.setUser_id(user_id);
            pDTO.setUser_intro(user_intro);
            pDTO.setUser_nick(user_nick);

            dairyService.updateProfile(pDTO);

            msg = "수정되었습니다.";
        } catch (Exception e) {
            msg = "실패하였습니다. : " + e.getMessage();
            log.info(e.toString());
            e.printStackTrace();
        } finally {
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            log.info(this.getClass().getName() + ".profileUpdate End!");
        }

        return "/redirect";
    }

}

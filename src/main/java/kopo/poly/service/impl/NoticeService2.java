package kopo.poly.service.impl;

import kopo.poly.dto.*;
import kopo.poly.persistance.mapper.INoticeMapper;
import kopo.poly.persistance.mapper.IUserInfoMapper;
import kopo.poly.persistance.mapper.IUserInfoMapper2;
import kopo.poly.service.IMailService;
import kopo.poly.service.INoticeService;
import kopo.poly.service.IUserInfo2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service

public class NoticeService2 implements IUserInfo2Service {

    // RequiredArgsConstructor 어노테이션으로 생성자를 자동 생성함
    // noticeMapper 변수에 이미 메모리에 올라간 INoticeMapper 객체를 넣어줌
    // 예전에는 autowired 어노테이션을 통해 설정했었지만, 이젠 생성자를 통해 객체 주입함

    private final IUserInfoMapper2 userInfoMapper2; // 회원관련 SQL 사용하기 위한 Mapper 가져오기

    @Override
    public void updateNoticeInfo2(UserInfo2DTO pDTO) throws Exception {
        log.info(this.getClass().getName() + ".updateNoticeInfo2 Start!");

        userInfoMapper2.updateNoticeInfo2(pDTO);
    }

    @Override
    public void uploadFile(MultipartFile file) throws Exception {
        log.info(this.getClass().getName() + ".uploadFile Start!");

        UserInfo2DTO pDTO = new UserInfo2DTO();

        UserInfo2DTO rDTO = userInfoMapper2.getLogin2(pDTO);

        log.info(rDTO.getUser_id() + ".uploadFile Start!");

        // 파일 경로를 rDTO 객체에 할당
        String filePath = "C:\\SpringBootWorks\\Weather\\src\\main\\resources\\static\\user\\" + rDTO.getUser_id() + ".png";

        // 파일을 지정된 경로에 저장
        file.transferTo(new File(filePath));

        pDTO.setProfile_path(filePath);

        userInfoMapper2.updateProfile(pDTO);

        log.info(this.getClass().getName() + ".uploadFile End!");
    }

}

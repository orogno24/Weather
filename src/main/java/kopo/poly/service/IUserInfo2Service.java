package kopo.poly.service;

import kopo.poly.dto.UserInfo2DTO;
import org.springframework.web.multipart.MultipartFile;

public interface IUserInfo2Service {

    void updateNoticeInfo2(UserInfo2DTO pDTO) throws Exception;

    void uploadFile(MultipartFile file) throws Exception;

}

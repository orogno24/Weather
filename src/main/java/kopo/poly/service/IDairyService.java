package kopo.poly.service;

import kopo.poly.dto.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IDairyService {
    List<DiaryDTO> getHashtag(HashtagdiaryDTO pDTO) throws Exception;

    void insertHashtag(HashtagdiaryDTO pDTO) throws Exception;

    void updateProfile(UserInfoDTO pDTO) throws Exception;

    void uploadFile(MultipartFile file, HttpSession session) throws Exception;

    List<FollowDTO> getfollowingId(FollowDTO pDTO) throws Exception;

    List<FollowDTO> getfollowId(FollowDTO pDTO) throws Exception;

    FollowDTO countfollow(FollowDTO pDTO, boolean type) throws Exception;

    UserInfoDTO getnick(UserInfoDTO pDTO, boolean type) throws Exception;
}

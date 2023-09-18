package kopo.poly.persistance.mapper;

import kopo.poly.dto.UserInfo2DTO;
import kopo.poly.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserInfoMapper2 {
    void updateNoticeInfo2(UserInfo2DTO pDTO) throws Exception;

    UserInfo2DTO getLogin2(UserInfo2DTO pDTO) throws Exception;

    void updateProfile(UserInfo2DTO pDTO) throws Exception;

}

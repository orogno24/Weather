package kopo.poly.persistance.mapper;

import kopo.poly.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IHashtagMapper {
    List<DiaryDTO> getHashtag(HashtagdiaryDTO pDTO) throws Exception;

    void insertHashtag(HashtagdiaryDTO pDTO) throws Exception;

    void updateProfile(UserInfoDTO pDTO) throws Exception;

    UserInfoDTO getUserId(UserInfoDTO pDTO) throws Exception;

    void updatePhoto(UserInfoDTO pDTO) throws Exception;

    List<FollowDTO> getfollowingId(FollowDTO pDTO) throws Exception;

    List<FollowDTO> getfollowId(FollowDTO pDTO) throws Exception;

    FollowDTO countfollow(FollowDTO pDTO) throws Exception;

    UserInfoDTO getnick(UserInfoDTO pDTO) throws Exception;

}

package kopo.poly.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HashtagdiaryDTO {
    private String HashtagDiarySeq;
    private String diarySeq;
    private String hashtagId;
}

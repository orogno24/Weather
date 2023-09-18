package kopo.poly.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DiaryDTO {
    private String diarySeq;
    private String likeCnt;
    private String readCnt;
    private String contents;
    private String imgPath;
    private String nftYn;
    private String publicYn;
    private String regId;
    private String regDt;
    private String chgId;
    private String chgDt;
}

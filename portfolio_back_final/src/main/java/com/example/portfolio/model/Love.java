package com.example.portfolio.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.portfolio.model
 * fileName : Life
 * author : samsung
 * date : 2023-07-02
 * description :
 * 요약 :
 * <p>
 * ===============================================================
 * DATE             AUTHOR              NOTE
 * --------------------------------------------
 * 2023-07-02          samsung            최소 생성
 */
@Entity
@Table(name="TB_LOVE")
@SequenceGenerator(
        name = "SQ_LOVE_GENERATOR"
        , sequenceName = "SQ_LOVE"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
// soft delete
// @Where : (clause ="자동으로추가할조건절") :자동으로 select 조건으로 추가함
@Where(clause = "DELETE_YN = 'N'")
// @SQLDelete : delete 실행 -> 대체해서 실행될 sql문을 지정
// 사용법) @SQLDelete(sql = "대체실행sql문")
@SQLDelete(sql = "UPDATE TB_LOVE SET DELETE_YN = 'Y', DELETE_TIME=TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE LNO = ?")

public class Love extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOVE_GENERATOR"
    )
    private Integer lno;
    @Column
    private String loveSentence;
    @Column
    private String loveWriter;
    
}

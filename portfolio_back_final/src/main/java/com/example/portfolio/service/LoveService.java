package com.example.portfolio.service;

import com.example.portfolio.model.Love;
import com.example.portfolio.repository.LoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * packageName : com.example.portfolio.service
 * fileName : LoveService
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
@Service
public class LoveService {
    @Autowired
    LoveRepository loveRepository;

    //    전체 조회 함수(페이징기능추가)
    public Page<Love> findAll(Pageable pageable) {
        Page<Love> page = loveRepository.findAll(pageable);

        return page;
    }

    //    내용(loveSentence) like 검색 함수(페이징처리)
    public Page<Love> findAllByLoveSentenceContaining(
            String loveSentence, Pageable pageable
    ) {
       Page<Love> page = loveRepository.findAllByLoveSentenceContaining(loveSentence, pageable);

        return page;
    }
}

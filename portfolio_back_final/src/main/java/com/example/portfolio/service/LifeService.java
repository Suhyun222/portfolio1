package com.example.portfolio.service;

import com.example.portfolio.model.Life;
import com.example.portfolio.repository.LifeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * packageName : com.example.portfolio.service
 * fileName : LifeService
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
public class LifeService {
    @Autowired
    LifeRepository lifeRepository;

    //    전체 조회 함수(페이징기능추가)
    public Page<Life> findAll(Pageable pageable) {
        Page<Life> page = lifeRepository.findAll(pageable);

        return page;
    }

    //    내용(lifeSentence) like 검색 함수(페이징처리)
    public Page<Life> findAllByLifeSentenceContaining(
            String lifeSentence, Pageable pageable
    ) {
        Page<Life> page
                = lifeRepository
                .findAllByLifeSentenceContaining(lifeSentence, pageable);

        return page;
    }
}

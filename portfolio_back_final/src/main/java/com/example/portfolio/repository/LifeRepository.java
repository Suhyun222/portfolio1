package com.example.portfolio.repository;

import com.example.portfolio.model.Life;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.example.portfolio.repository
 * fileName : LifeRepository
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
@Repository
public interface LifeRepository extends JpaRepository<Life,Integer> {
    //    내용(sentence) like 검색
    Page<Life> findAllByLifeSentenceContaining(String lifeSentence, Pageable pageable);

}

package com.example.portfolio.controller;

import com.example.portfolio.model.Love;
import com.example.portfolio.service.LoveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : com.example.portfolio.controller
 * fileName : LoveController
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
@RestController
@RequestMapping("/api")
@Slf4j
public class LoveController {
    @Autowired
    LoveService loveService;

    //     1)전체 조회 함수 + 2) 문장 like 검색 함수(페이징처리)
    @GetMapping("/love")
    public ResponseEntity<Object> getLoveAll(
            @RequestParam(required = false, defaultValue = "") String loveSentence,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size
    ) {
        try {
            // TODO: Pageable 객체 저장 : page(현재페이지번호)
            //                        , size(1페이지당개수) 값
//                  사용법) Pageable pageable
//                           = PageRequest.of(현재페이지, 1페이지당개수)
            Pageable pageable = PageRequest.of(page, size);

            Page<Love> lovePage
                    = loveService.findAllByLoveSentenceContaining(loveSentence, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("love", lovePage.getContent()); // 객체배열
            response.put("currentPage", lovePage.getNumber()); // 현재페이지번호
            response.put("totalItems", lovePage.getTotalElements()); // 총개수(건수)
            response.put("totalLPages", lovePage.getTotalPages()); // 총페이지수

            if (lovePage.isEmpty() == false) {
                // 성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                // 데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage()); // 에러 출력
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}

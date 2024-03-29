package com.example.demo.src.review.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostReviewReq {
    // 유저 id, 별점, 리뷰내용, 리뷰이미지 url
    private int userIdx;
//    @NotNull(message = "별점을 입력해주세요.")
    private float star;
    private String content;
    private List<String> reviewImgUrl;

}

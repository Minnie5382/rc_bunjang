package com.example.demo.src.review.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostReviewReq {
    // 유저 id, 별점, 리뷰내용, 리뷰이미지 url
    private int userIdx;
    private float star;
    private String content;
    private String reviewImgUrl;

}

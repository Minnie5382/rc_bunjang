package com.example.demo.src.KakaoPay;

import lombok.Data;

import java.util.Date;

@Data
public class KakaoPayReadyVO {

    //response
    private String tid, next_redirect_pc_url;
    private Date created_at;

}
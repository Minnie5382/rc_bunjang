package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatchShopInfoRes {
    private int userIdx;

    private String profileImgUrl;

    private String shopDescription;

    private String name;

}

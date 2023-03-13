package com.example.demo.src.product.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostProductReq {
   private int userIdx;
    private List<PostProductImgs> productImgs;
   private String productName;
   private int subCategoryIdx;
   private List<PostTags> tags;
   private int price;
   private String description;
   private int count;
   private String productStatus;
   private String isExchange;
}

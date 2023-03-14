package com.example.demo.src.product;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.product.model.*;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ProductProvider productProvider;
    @Autowired
    private final ProductService productService;
    @Autowired
    private final JwtService jwtService;

    public ProductController(ProductProvider productProvider, ProductService productService, JwtService jwtService) {
        this.productProvider = productProvider;
        this.productService = productService;
        this.jwtService = jwtService;
    }

    /**
     * 특정 상품 조회 API
     *
     * @param productIdx
     * @return
     */
    @ResponseBody
    @GetMapping("/{productIdx}") // (GET) 127.0.0.1:9000/products/:productIdx
    public BaseResponse<GetProductRes> getProductRes(@PathVariable("productIdx") int productIdx) {
        try {
            List<GetProductList> getProductList = productProvider.getProducts(productIdx);
            List<GetReviewList> getReviewList = productProvider.getReviews(productIdx);
            GetShopInfo getShopInfo = productProvider.getShopInfo(productIdx);
            GetShopRes getShopRes = new GetShopRes(getReviewList, getProductList, getShopInfo);

            GetProductInfoRes getProductInfoRes = productProvider.getProductInfoRes(productIdx);
            GetProductRes getProductRes = new GetProductRes(getProductInfoRes, getShopRes);
            return new BaseResponse<>(getProductRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }


    /**
     * 상품 등록 api
     *
     * @param postProductReq
     * @return
     */
    @ResponseBody
    @PostMapping("") // (POST) 127.0.0.1:9000/products
    public BaseResponse<PostProductRes> postProductRes(@Valid @RequestBody PostProductReq postProductReq, Errors errors) throws BaseException {
        // 회원용 API
        int userIdxByJwt = jwtService.getUserIdx(); // jwt에서 userIdx 추출
        if (postProductReq.getUserIdx() != userIdxByJwt) { // 유저가 제시한 userIdx != jwt에서 추출한 userIdx
            return new BaseResponse(INVALID_USER_JWT);
        }

        // validation : 상품명을 입력했는지?
        if(postProductReq.getProductName().isEmpty())
            return new BaseResponse<>(EMPTY_PRODUCT_NAME);

        // validation : 내용을 입력했는지?
        if(postProductReq.getDescription().isEmpty())
            return new BaseResponse<>(EMPTY_PRODUCT_DESCRIPTION);

        // validation : 이미지를 1장 이상 첨부했는지?
        if(postProductReq.getProductImgs().size() < 1)
            return new BaseResponse<>(EMPTY_PRODUCT_IMG);

        //validation : 상품명 40자 이하
        if(postProductReq.getProductName().length() > 40)
            return new BaseResponse<>(INVALID_PRODUCT_NAME);

        // validation : 내용 10~20,000자
        if(postProductReq.getDescription().length() < 10 || postProductReq.getDescription().length() > 20000)
            return new BaseResponse<>(INVALID_PRODUCT_DESCRIPTION);

        // validation : 가격 500~999,999,999원
        if(postProductReq.getPrice() < 500 || postProductReq.getPrice() > 999999999)
            return new BaseResponse<>(INVALID_PRODUCT_PRICE);

        // validation : 태그 최대 5개
        if(postProductReq.getTags().size() > 5)
            return new BaseResponse<>(INVALID_PRODUCT_TAGS);

        // validation : 이미지 12장 이하
        if(postProductReq.getProductImgs().size() > 12)
            return new BaseResponse<>(MAX_PRODUCT_IMG_COUNT);

        // validation : 이미지 사이즈 640X640 이하
        // 테스트 이미지 링크 : https://picsum.photos/200/300


        try {
            PostProductRes postProductRes = productService.postProducts(postProductReq.getUserIdx(), postProductReq);
            return new BaseResponse<>(postProductRes);

        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }


    /** 상품 수정 api
    *
     * @param
     * @param productIdx
     * @return
     */
    @ResponseBody
    @PatchMapping("/{productIdx}") // (PATCH) 127.0.0.1:9000/products/:productIdx
    public BaseResponse<PatchProductRes> patchProduct(@RequestBody PatchProductReq patchProductReq, @PathVariable("productIdx") int productIdx) throws BaseException {
        // 회원용 API
        int userIdxByJwt = jwtService.getUserIdx(); // jwt에서 userIdx 추출
        if (patchProductReq.getUserIdx() != userIdxByJwt) { // 유저가 제시한 userIdx != jwt에서 추출한 userIdx
            return new BaseResponse<>(INVALID_USER_JWT);
        }

        // validation : 상품명을 입력했는지?
        if(patchProductReq.getProductName().isEmpty())
            return new BaseResponse<>(EMPTY_PRODUCT_NAME);

        // validation : 내용을 입력했는지?
        if(patchProductReq.getDescription().isEmpty())
            return new BaseResponse<>(EMPTY_PRODUCT_DESCRIPTION);

        // validation : 이미지를 1장 이상 첨부했는지?
        if(patchProductReq.getProductImgs().size() < 1)
            return new BaseResponse<>(EMPTY_PRODUCT_IMG);

        //validation : 상품명 40자 이하
        if(patchProductReq.getProductName().length() > 40)
            return new BaseResponse<>(INVALID_PRODUCT_NAME);

        // validation : 내용 10~20,000자
        if(patchProductReq.getDescription().length() < 10 || patchProductReq.getDescription().length() > 20000)
            return new BaseResponse<>(INVALID_PRODUCT_DESCRIPTION);

        // validation : 가격 500~999,999,999원
        if(patchProductReq.getPrice() < 500 || patchProductReq.getPrice() > 999999999)
            return new BaseResponse<>(INVALID_PRODUCT_PRICE);

        // validation : 태그 최대 5개
        if(patchProductReq.getTags().size() > 5)
            return new BaseResponse<>(INVALID_PRODUCT_TAGS);

        // validation : 이미지 12장 이하
        if(patchProductReq.getProductImgs().size() > 12)
            return new BaseResponse<>(MAX_PRODUCT_IMG_COUNT);

        try {
            PatchProductRes patchProductRes = productService.patchProduct(productIdx, patchProductReq);
            return new BaseResponse<>(patchProductRes);

        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

        /** 상품 판매상태 변경 api
         *
         * @param productIdx
         * @param saleStatus
         * @return
         */
        @ResponseBody
        @PatchMapping("") // (PATCH) 127.0.0.1:9000/products?productIdx={productIdx}&saleStatus={saleStatus}
        public BaseResponse<PatchProductRes> patchSaleStatus (@RequestParam("productIdx") int productIdx, @RequestParam("saleStatus") String saleStatus, @RequestBody ProductUserIdx productUserIdx) throws BaseException {
            // 회원용 API
            int userIdxByJwt = jwtService.getUserIdx(); // jwt에서 userIdx 추출
            if (productUserIdx.getUserIdx() != userIdxByJwt) { // 유저가 제시한 userIdx != jwt에서 추출한 userIdx
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            // validation : 요청값에 판매 상태가 존재하는지
            if(saleStatus.isEmpty())
                return new BaseResponse<>(EMPTY_SALE_STATUS);

            // validation : 요청값의 판매상태가 {"ONSALE","ORDERED","SOLD"} 중 있는지?
            String [] saleStatus_array =  {"ONSALE","ORDERED","SOLD"};
            ArrayList<String>  saleStatus_enum = new ArrayList<>(Arrays.asList(saleStatus_array));

            if(!saleStatus_enum.contains(saleStatus))
                return new BaseResponse<>(PATCH_INVALID_PRODUCT_STATUS);


            try {

                PatchProductRes patchProductRes = productService.patchSaleStatus(productIdx, saleStatus);
                return new BaseResponse<>(patchProductRes);

            } catch (BaseException exception) {
                return new BaseResponse<>((exception.getStatus()));
            }
        }

        /** 상품 삭제 api
         *
         * @param productIdx
         * @return
         */
        @ResponseBody
        @PatchMapping("/{productIdx}/status") // (PATCH) 127.0.0.1:9000/products/:productIdx/status
        public BaseResponse<PatchProductRes> deleteProduct ( @PathVariable("productIdx") int productIdx, @RequestBody ProductUserIdx productUserIdx){
            try {
                // 회원용 API
                int userIdxByJwt = jwtService.getUserIdx(); // jwt에서 userIdx 추출
                if (productUserIdx.getUserIdx() != userIdxByJwt) { // 유저가 제시한 userIdx != jwt에서 추출한 userIdx
                    return new BaseResponse<>(INVALID_USER_JWT);
                }

                PatchProductRes patchProductRes = productService.deleteProduct(productIdx);
                return new BaseResponse<>(patchProductRes);

            } catch (BaseException exception) {
                return new BaseResponse<>((exception.getStatus()));
            }
        }

        /** 태그 검색 api
         *
         * @param tag
         * @return
         */
        @ResponseBody
        @GetMapping("") // (GET) 127.0.0.1:9000/products?tag={tag}
        public BaseResponse<List<GetProductList>> getProductByTag (@RequestParam("tag") String tag){
            try {
                List<GetProductList> getProductList = productProvider.getProductsByTag(tag);
                return new BaseResponse<>(getProductList);

            } catch (BaseException exception) {
                return new BaseResponse<>((exception.getStatus()));
            }
        }

        /** 상품 리스트 뽑아내기 api (홈화면 용)면
         *
         * @return
         */
        @ResponseBody
        @GetMapping("/home") // (GET) 127.0.0.1:9000/products/home
        public BaseResponse<List<GetProductList>> getProducts () {
            try {
                List<GetProductList> getProductList = productProvider.getHomeProducts();
                return new BaseResponse<>(getProductList);

            } catch (BaseException exception) {
                return new BaseResponse<>((exception.getStatus()));
            }
        }

        /** 카테고리 별 상품 뽑아내기 api
         *
         * @param categoryIdx
         * @return
         */
        @ResponseBody
        @GetMapping("/category/{categoryIdx}") // (GET) 127.0.0.1:9000/products/category/1
        public BaseResponse<List<GetProductList>> getProductsByCat (@PathVariable("categoryIdx") int categoryIdx){
            try {
                List<GetProductList> getProductList = productProvider.getProductsByCat(categoryIdx);
                return new BaseResponse<>(getProductList);

            } catch (BaseException exception) {
                return new BaseResponse<>((exception.getStatus()));
            }
        }

        /** 서브카테고리 별 상품 뽑아내기 api
         *
         * @param subCategoryIdx
         * @return
         */
        @ResponseBody
        @GetMapping("/subCategory/{subCategoryIdx}") // (GET) 127.0.0.1:9000/products/subCategory/1
        public BaseResponse<List<GetProductList>> getProductsBySubCat (@PathVariable("subCategoryIdx") int subCategoryIdx){
            try {
                List<GetProductList> getProductList = productProvider.getProductsBySubCat(subCategoryIdx);
                return new BaseResponse<>(getProductList);

            } catch (BaseException exception) {
                return new BaseResponse<>((exception.getStatus()));
            }
        }



}

package com.example.demo.src.user;

import com.example.demo.src.product.model.PatchProductRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import static com.example.demo.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/users")
public class UserController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final UserProvider userProvider;
    @Autowired
    private final UserService userService;
    @Autowired
    private final JwtService jwtService;

    public UserController(UserProvider userProvider, UserService userService, JwtService jwtService) {
        this.userProvider = userProvider;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    /**
     * 마이페이지 조회 API
     * [GET] /users/mypage/:userIdx
     * @return BaseResponse<GetMyPageRes>
     */
    @ResponseBody
    @GetMapping("/mypage/{userIdx}") // (GET) 127.0.0.1:9000/users/mypage/:userIdx
    public BaseResponse<GetMyPageRes> getMyPage(@PathVariable("userIdx") int userIdx) {
        try {
            GetMyPageRes getMyPageRes = userProvider.getMyPage(userIdx);
            return new BaseResponse<>(getMyPageRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 상점 조회 API
     * [GET] /users/store/:userIdx
     * @return BaseResponse<GetStoreRes>
     */
    @ResponseBody
    @GetMapping("/store/{userIdx}") // (GET) 127.0.0.1:9000/users/store/:userIdx
    public BaseResponse<GetStoreRes> getShop(@PathVariable("userIdx") int userIdx) {
        try {
            GetStoreRes getStoreRes = userProvider.getStore(userIdx);
            return new BaseResponse<>(getStoreRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 상점 상품 조회 API
     * [GET] /users/store/:userIdx/products
     * @return BaseResponse<List<GetStoreProductsRes>>
     */
    @ResponseBody
    @GetMapping("/store/{userIdx}/products") // (GET) 127.0.0.1:9000/users/store/:userIdx/products
    public BaseResponse<List<GetStoreProductsRes>> getStoreProducts(@PathVariable("userIdx") int userIdx) {
        try {
            List<GetStoreProductsRes> getStoreProducts = userProvider.getStoreProducts(userIdx);
            return new BaseResponse<>(getStoreProducts);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 회원가입 API
     * [POST] /users
     * @return BaseResponse<PostUserRes>
     */
    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostUserRes> createUser(@RequestBody PostUserReq postUserReq) {
        // 회원가입 시 이름을 입력하지 않았을 때
        if (postUserReq.getName() == null) {
            return new BaseResponse<>(POST_USERS_EMPTY_NAME);
        }

        // 회원가입 시 휴대폰 번호를 입력하지 않았을 때
        if (postUserReq.getPhoneNo() == null) {
            return new BaseResponse<>(POST_USERS_EMPTY_PHONENO);
        }

        // 회원가입 시 생년월일을 입력하지 않았을 때
        if (postUserReq.getBirthday() == null) {
            return new BaseResponse<>(POST_USERS_EMPTY_BIRTHDAY);
        }

        // user명이 상점명이기 때문에 문자만 입력 가능하게 하면 안될 듯.
//        String regExp = "^[가-힣]*$";
//         //회원가입 시 이름 입력란에 문자만 입력 가능
//        if (!postUserReq.getName().matches(regExp)) {
//            return new BaseResponse<>(POST_USERS_INVALID_NAME);
//        }

        String regex = "[0-9]+";
        // 회원가입 시 휴대폰 번호 입력란에 숫자만 입력 가능
        if (!(postUserReq.getPhoneNo().matches(regex))) {
            return new BaseResponse<>(POST_USERS_INVALID_PHONENO);
        }

        // 회원가입 시 휴대폰 번호 최대 11자리까지만 입력 가능
        if(postUserReq.getPhoneNo().length() > 11) {
            return new BaseResponse<>(POST_USERS_INVALID_PHONENO_LENGTH);
        }

        try {
            PostUserRes postUserRes = userService.createUser(postUserReq);
            return new BaseResponse<>(postUserRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 로그인 API
     * [POST] /users/logIn
     * @return BaseResponse<PostLoginRes>
     */
    @ResponseBody
    @PostMapping("/logIn")
    public BaseResponse<PostLoginRes> logIn(@RequestBody PostLoginReq postLoginReq){
        // 로그인 시 이름을 입력하지 않았을 때
        if (postLoginReq.getName() == null) {
            return new BaseResponse<>(POST_USERS_EMPTY_NAME);
        }

        // 로그인 시 휴대폰 번호를 입력하지 않았을 때
        if (postLoginReq.getPhoneNo() == null) {
            return new BaseResponse<>(POST_USERS_EMPTY_PHONENO);
        }

        // user명이 상점명이기 때문에 문자만 입력 가능하게 하면 안될 듯.
//        String regExp = "^[가-힣]*$";
//        //로그인 시 이름 입력란에 문자만 입력 가능
//        if (!postLoginReq.getName().matches(regExp)) {
//            return new BaseResponse<>(POST_USERS_INVALID_NAME);
//        }

        String regex = "[0-9]+";
        // 로그인 시 휴대폰 번호 입력란에 숫자만 입력 가능
        if (!(postLoginReq.getPhoneNo().matches(regex))) {
            return new BaseResponse<>(POST_USERS_INVALID_PHONENO);
        }

        // 로그인 시 휴대폰 번호 최대 11자리까지만 입력 가능
        if(postLoginReq.getPhoneNo().length() > 11) {
            return new BaseResponse<>(POST_USERS_INVALID_PHONENO_LENGTH);
        }

        try{
            PostLoginRes postLoginRes = userProvider.logIn(postLoginReq);
            return new BaseResponse<>(postLoginRes);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 상점 소개 편집 API
     * [PATCH] /users/:userIdx
     * @return BaseResponse<PatchShopInfoReq>
     */

    @ResponseBody
    @PatchMapping("/{userIdx}")
    public BaseResponse<PatchShopInfoRes> modifyShopInfo(@PathVariable("userIdx") int userIdx, @RequestBody PatchShopInfoReq patchShopInfoReq) {
        try {
            // 상점 이름 길이가 10자 초과되는지 체크
            if(patchShopInfoReq.getName().length() > 10) {
                throw new BaseException(PATCH_INVALID_NAME_LENGTH);
            }

            // 상점 소개 길이가 1000자 초과되는지 체크
            if(patchShopInfoReq.getShopDescription().length() > 1000) {
                throw new BaseException(PATCH_INVALID_SHOPDESCRIPTION_LENGTH);
            }

            // 상점 이름에 한글, 영어, 숫자 이외의 문자가 있는지 체크
            if(Pattern.matches("^[0-9a-zA-Zㄱ-ㅎ가-힣]*$", patchShopInfoReq.getName()) == false) {
                throw new BaseException(PATCH_INVALID_NAME_PATTERN);
            }

            PatchShopInfoRes patchShopInfoRes = userService.modifyShop(userIdx, patchShopInfoReq);

            return new BaseResponse<>(patchShopInfoRes);

        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }


    /**
     * 회원 탈퇴 API
     * [PATCH] /users/:userIdx/status
     * @return BaseResponse<PatchDeleteUserRes>
     */
    @ResponseBody
    @PatchMapping("/{userIdx}/status")
    public BaseResponse<PatchDeleteUserRes> deleteUser(@PathVariable("userIdx") int userIdx, @RequestBody PatchDeleteUserReq patchDeleteUserReq) {
        try {
            PatchDeleteUserRes patchDeleteUserRes = userService.deleteUser(patchDeleteUserReq, userIdx);

            return new BaseResponse<>(patchDeleteUserRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}

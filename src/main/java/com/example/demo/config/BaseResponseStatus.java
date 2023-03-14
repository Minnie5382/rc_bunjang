package com.example.demo.config;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_JWT(false, 2001, "JWT를 입력해주세요."),
    INVALID_JWT(false, 2002, "유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false, 2003, "권한이 없는 유저의 접근입니다."),

    // users
    USERS_EMPTY_USER_ID(false, 2010, "유저 아이디 값을 확인해주세요."),

    // [POST] /users
    POST_USERS_EMPTY_EMAIL(false, 2015, "이메일을 입력해주세요."),
    POST_USERS_INVALID_EMAIL(false, 2016, "이메일 형식을 확인해주세요."),
    POST_USERS_EXISTS_PHONENO(false, 2017, "중복된 휴대폰번호 입니다."),
    POST_USERS_EMPTY_NAME(false, 2018, "이름을 입력해주세요."),
    POST_USERS_EMPTY_PHONENO(false, 2018, "핸드폰 번호를 입력해주세요."),
    POST_USERS_EMPTY_BIRTHDAY(false, 2019, "생년월일을 입력해주세요."),
    INACTIVE_USER(false, 2020, "비활성화 상태입니다"),
    DELETED_USER(false, 2021, "삭제된 사용자 입니다."),
    POST_SHOP_NOT_EXISTS(false, 2022, "존재하지 않는 가게 입니다."),
    INVALID_USER(false, 2023, "이미 탈퇴한 회원입니다."),

    // Product
    PRODUCT_NOT_EXISTS(false, 2030, "존재하지 않는 상품 입니다."),
    SUBCATEGORY_NOT_EXISTS(false, 2031, "존재하지 않는 카테고리 입니다."),
    INVALID_PRODUCT_STATUS(false, 2032, "판매 상태가 올바르지 않습니다."),

    PATCH_INVALID_PRODUCT_STATUS(false, 2033, "판매 상태를 다시 입력해주세요."),
    EMPTY_PRODUCT_IMG(false, 2034, "상품 이미지는 1장 이상이어야 합니다."),
    EMPTY_PRODUCT_IMG_LIST(false, 2034, "상품 이미지 객체가 없습니다."),
    EMPTY_PRODUCT_NAME(false, 2035, "상품 제목을 입력해주세요."),
    INVALID_PRODUCT_NAME(false, 2036, "제목은 40자 이하여야 합니다."),
    INVALID_PRODUCT_PRICE(false, 2037, "금액은 500원 이상 999,999,999원 이하여야 합니다."),
    EMPTY_PRODUCT_DESCRIPTION(false, 2038, "내용을 입력해주세요."),
    INVALID_PRODUCT_DESCRIPTION(false, 2039, "내용은 10자 이상 200000자 이하여야 합니다."),
    INVALID_PRODUCT_TAGS(false, 2040, "태그는 5개 이하여야 합니다."),
    INVALID_PRODUCT_IMG(false, 2041, "이미지 사이즈는 640X640 이하여야 합니다."),
    MAX_PRODUCT_IMG_COUNT(false, 2042,"상품 이미지는 최대 12장입니다."),
    EMPTY_SALE_STATUS(false, 2032, "판매 상태 값을 입력해주세요."),


    // Review
    REVIEW_NOT_EXISTS(false, 2050, "존재하지 않는 리뷰 입니다."),
    DUPLICATED_PRODUCT_REVIEW(false, 2051, "이미 리뷰가 작성된 상품입니다."),
    EMPTY_REVIEW_CONTENT(false, 2052, "리뷰 내용을 입력해주세요."),
    MAX_REVIEW_IMG_COUNT(false, 2053, "리뷰 이미지는 최대 6장 입니다."),


    // Follow
    FOLLOW_NOT_EXISTS(false, 2060, "존재하지 않는 팔로우 입니다."),
    DUPLICATED_FOLLOW(false, 2061, "이미 팔로우하고 있습니다."),

    // Favorite
    FAVORITE_NOT_EXISTS(false, 2070, "존재하지 않는 찜 입니다."),
    DUPLICATED_FAVORITE(false, 2071, "이미 찜한 상품입니다."),




    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    // [POST] /users
    DUPLICATED_EMAIL(false, 3013, "중복된 이메일입니다."),
    FAILED_TO_LOGIN(false, 3014, "없는 아이디거나 비밀번호가 틀렸습니다."),
    DELETE_FAIL_USER(false, 3015, "유저를 삭제하는데 실패하였습니다."),


    /**
     * 4000 : Database, Server 오류
     */

    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),

    //[PATCH] /users/{userIdx}
    MODIFY_FAIL_USERNAME(false, 4014, "유저네임 수정 실패"),

    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다."),
    MODIFY_FAIL_SHOP(false, 4013, "상점 변경에 실패하였습니다.");

    // 5000 : 필요시 만들어서 쓰세요
    // 6000 : 필요시 만들어서 쓰세요


    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}


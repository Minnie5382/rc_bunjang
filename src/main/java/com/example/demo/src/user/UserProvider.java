package com.example.demo.src.user;


import com.example.demo.config.BaseException;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.JwtService;
import com.example.demo.utils.SHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Service
public class UserProvider {

    private final UserDao userDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserProvider(UserDao userDao, JwtService jwtService) {
        this.userDao = userDao;
        this.jwtService = jwtService;
    }

    public GetUserRes getUser(int userIdx) throws BaseException {
        try {
            GetUserRes getUserRes = userDao.getUser(userIdx);
            return getUserRes;
        } catch (Exception exception) {
            logger.error("App - getUser Provider Error", exception);
            throw new BaseException(DATABASE_ERROR);
        }
    }

//    public int getUser(PostUserReq postUserReq) throws BaseException {
//        try {
//            GetUserRes getUserRes = userDao.getUser(postUserReq);
//            return getUserRes;
//        } catch (Exception exception) {
//            logger.error("App - getUser Provider Error", exception);
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }

    public PostLoginRes logIn(PostLoginReq postLoginReq) throws BaseException {
        try {
            User user = userDao.getUser(postLoginReq);
            int resultIdx = userDao.checkPhoneNo(postLoginReq);

            if(resultIdx == 1){
                int userIdx = user.getUserIdx();
                String jwt = jwtService.createJwt(userIdx);
                String name = user.getName();
                return new PostLoginRes(userIdx,name,jwt);
            }
            else{
                throw new BaseException(FAILED_TO_LOGIN);
            }
        } catch (Exception exception) {
            logger.error("App - logIn Provider Error", exception);
            throw new BaseException(DATABASE_ERROR);
        }
    }

}

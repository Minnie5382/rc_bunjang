package com.example.demo.src.chat;

import com.example.demo.config.BaseException;
import com.example.demo.src.chat.model.PostChatReq;
import com.example.demo.src.chat.model.PostChatRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class ChatService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ChatDao chatDao;

    public ChatService(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    public PostChatRes createChat(PostChatReq postChatReq, int userIdx) throws BaseException {
         int idx = chatDao.createChat(postChatReq, userIdx);

//         if (idx == 0) {
//             throw new BaseException(FAILED_TO_CREATE_CHAT);
//         }

         try{
             int chatRoomIdx = postChatReq.getChatRoomIdx();
             String message = postChatReq.getMessage();
             Timestamp updateAt = postChatReq.getUpdateAt();

             return new PostChatRes(chatRoomIdx, message, updateAt) ;

         }catch (Exception exception) {
             logger.error("App - createChat Service Error", exception);
             throw new BaseException(DATABASE_ERROR);
         }
    }

    public void patchChat(int chatRoomIdx) {
        chatDao.patchChat(chatRoomIdx);
    }
}

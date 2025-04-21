package com.yeqian.service;

import com.yeqian.pojo.ChatRecord;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface ChatRecordService {

    /**
     * 查询 两个用户 之间的 聊天记录
     * @param senderId
     * @param receiverId
     * @return
     */
    List<ChatRecord> selectBySenderIdAndReceiverId(Integer senderId, Integer receiverId);

    /**
     * 添加 聊天记录
     * @param chatRecord
     */
    void addChatRecord(ChatRecord chatRecord);
}

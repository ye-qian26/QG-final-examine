package com.yeqian.service.impl;

import com.yeqian.dao.mapper.ChatRecordMapper;
import com.yeqian.pojo.ChatRecord;
import com.yeqian.service.ChatRecordService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class ChatRecordServiceImpl implements ChatRecordService {
    ChatRecordMapper chatRecordMapper = MapperProxyFactory.getProxy(ChatRecordMapper.class);

    @Override
    public List<ChatRecord> selectBySenderIdAndReceiverId(Integer senderId, Integer receiverId) {
        return chatRecordMapper.selectBySenderIdAndReceiverId(senderId, receiverId);
    }

    @Override
    public void addChatRecord(ChatRecord chatRecord) {
        chatRecordMapper.addChatRecord(chatRecord);
    }
}

package com.yeqian.dao.mapper;

import com.yeqian.pojo.ChatRecord;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface ChatRecordMapper {

    /**
     * 查询 两个用户 之间的 聊天记录
     * @param senderId
     * @param receiverId
     * @return
     */
    @Select("select * from chat_record where (sender_id = #{senderId} and receiver_id = #{receiverId}) " +
            "or (sender_id = #{receiverId} and receiver_id = #{senderId}) order by send_time desc")
    List<ChatRecord> selectBySenderIdAndReceiverId(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);

    /**
     * 添加 聊天记录
     * @param chatRecord
     */
    @Insert("insert into chat_record values (null, #{senderId}, #{receiverId}, #{content}, #{sendTime})")
    void addChatRecord(ChatRecord chatRecord);
}

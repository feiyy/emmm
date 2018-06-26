package com.zxd1997.Mapper;

import com.zxd1997.Beans.Message;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//@Mapper
public interface MessageMapper {
//    @Select("SELECT name FROM message where id=#{id}")
    List<Message> findall() throws SQLException;
    Message findMessageById(int id) throws SQLException;
    List<Message> find_range(Map map) throws SQLException;
    int add(Message message) throws  SQLException;
    int delete(int id) throws SQLException;
    int getPages() throws SQLException;
    List<Message> find_range_with_con(Map map) throws SQLException;
    int pages_with_con(Map map) throws SQLException;
}

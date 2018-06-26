package com.zxd1997;

import com.zxd1997.Beans.Message;
import com.zxd1997.Beans.User;
import com.zxd1997.Mapper.MessageMapper;
import com.zxd1997.Services.MessageService;
import com.zxd1997.Services.ServiceImpl.UserServiceImpl;
import com.zxd1997.Services.UserService;
import com.zxd1997.Util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class Demo {
    @Autowired
    static MessageService messageService;
    public static void main(String args[]) throws IOException {
//        InputStream inputStream=Resources.getResourceAsStream("MyBatis.xml");
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        System.out.println("open session");
//        int c=sqlSession.selectOne("MessageMapper.findCount");
//        sqlSession.close();
//        System.out.println(c);
//        System.out.println("session close");
//        SqlSession sqlSession=SqlSessionUtil.getSession();
//        String name=sqlSession.selectOne("MessageMapper.findNameById",54);
//        System.out.println(name);
//        sqlSession.close();
//        Message message=sqlSession.selectOne("MessageMapper.findMessageById",54);
//        System.out.println(message.getName());
//        System.out.println(message.getTitle());
//        System.out.println(message.getContent());
//        int count=sqlSession.insert("MessageMapper.add",new Message("dq qw","qd q qw","d q ",1,new Date()));
//        List<Message> messages=sqlSession.selectList("MessageMapper.findMessages");
//        MessageMapper messageMapper=sqlSession.getMapper(MessageMapper.class);
//        Message message= null;
//        try {
//            message = messageMapper.findMessageById(54);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(message.getName());
//        System.out.println(message.getTitle());
//        System.out.println(message.getContent());
////        System.out.println(messages.size());
//        sqlSession.close();
        UserService userService=new UserServiceImpl();
        ((UserServiceImpl) userService).trans("112","zxd1997",100);
        for (Message m:messageService.findall()){
            System.out.println(m.getContent());
        }
    }
}

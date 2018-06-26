package com.zxd1997.Services.ServiceImpl;

import com.zxd1997.Beans.Message;
import com.zxd1997.Mapper.MessageMapper;
import com.zxd1997.Services.MessageService;
import com.zxd1997.Util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
//    @Autowired
//    MessageDao messageDao;
    @Autowired
    MessageMapper messageMapper;
    @Override
    @Transactional
    public boolean add(Message message) {
        boolean f;
        try {
            messageMapper.add(message);
            f=true;
        } catch (SQLException e) {
            f=false;
            e.printStackTrace();
        }
//        JDBCutil db = new JDBCutil();
//        db.getConnection();
//        db.beginTransation();
//        SqlSession session=SqlSessionUtil.getSession();
//        MessageMapper messageMapper=session.getMapper(MessageMapper.class);
//        try {
//            if (messageMapper.add(message) > 0) {
//                session.commit();
//                f = true;
//            } else {
//                f=false;
//                session.rollback();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            f = false;
//            session.rollback();
//        } finally {
//            session.close();
//        }
        return f;
    }

    @Override
    public List<Message> findall() {
//        JDBCutil db = new JDBCutil();
//        db.getConnection();
        try {
            System.out.println("Message com.zxd1997.Service");
            return messageMapper.findall();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        boolean f = false;
        try {
            if (messageMapper.delete(id) > 0) {
                f = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Message> find_page(int n) {
        try {
            System.out.println("Message com.zxd1997.Service");
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("a",Page.getN() * (n - 1) + 1);
            map.put("b", Page.getN() * n);
            return messageMapper.find_range(map);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Message> find_page_With_con(int n, Map map) {
        try {
            System.out.println("Message com.zxd1997.Service");
            map.put("a",Page.getN() * (n - 1) + 1);
            map.put("b", Page.getN() * n);
            System.out.println(map.get("a")+" "+map.get("b"));
            return messageMapper.find_range_with_con(map);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getPages() {
            try {
                return messageMapper.getPages();
            } catch (SQLException e) {
                e.printStackTrace();
                return 0;
            }
    }

    @Override
    public int getPagewithCon(Map map) {
        try {
            return messageMapper.pages_with_con(map);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

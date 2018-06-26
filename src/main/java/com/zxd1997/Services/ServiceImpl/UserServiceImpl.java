package com.zxd1997.Services.ServiceImpl;

import com.zxd1997.DAO.UserDao;
import com.zxd1997.Mapper.UserMapper;
import com.zxd1997.Services.UserService;
import com.zxd1997.Util.JDBCutil;
import com.zxd1997.Util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserDao userDao;
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean login(String username, String password) {
//        JDBCutil db = new JDBCutil();
//        db.getConnection();
        try {
            String pass = userMapper.findPassword(username);
            if (pass == null) return false;
            if (pass.equals(password))
                return true;
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public String trans(String usera, String userb, int count) {
        String t = "";
        try {
            Map<String,Object> map=new HashMap<>();
            map.put("num",count);
            map.put("username",usera);
            int t1 = userMapper.min(map);
            map=new HashMap<>();
            map.put("num",count);
            map.put("username",userb);
            int t2 = userMapper.add(map);
            if (t1 > 0 && t2 > 0) {
                if (userMapper.getBalance(usera) < 0) {
                    t = "balance not enough";
                } else {
                    t = "Success";
                }
            } else {
                if (t1 == 0) {
                    t = "Account 1 not exists";
                } else if (t2 == 0) {
                    t = "Account 2 not exists";
                }
            }
        } catch (SQLException e) {
            t = "Error";
            e.printStackTrace();
        } finally {
        }
        System.out.println(t);
        return t;
    }
}

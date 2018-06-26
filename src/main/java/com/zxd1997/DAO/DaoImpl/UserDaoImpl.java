package com.zxd1997.DAO.DaoImpl;


import com.zxd1997.Beans.User;
import com.zxd1997.DAO.UserDao;
import com.zxd1997.Util.JDBCutil;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    public String findPassword(String username) throws Exception {
        String sql = "select * from users where username=?";
        JDBCutil db = new JDBCutil();
        Object[] object = {username};
        db.getConnection();
        ResultSet rs = db.executeQuery(sql, object);
        while (rs.next()) {
            String t = rs.getString("password");
            rs.close();
            return t;
        }
        rs.close();
        return null;
    }
}

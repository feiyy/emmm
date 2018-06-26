package com.zxd1997.DAO;

import com.zxd1997.Beans.User;

import java.util.List;

public interface UserDao {
    public String findPassword(String username) throws Exception;
}

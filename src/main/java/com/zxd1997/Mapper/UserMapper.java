package com.zxd1997.Mapper;

import java.sql.SQLException;
import java.util.Map;

public interface UserMapper {
    public String findPassword(String username) throws SQLException;
    public int add(Map map) throws SQLException;
    public int min(Map map) throws SQLException;
    public int getBalance(String username) throws SQLException;
}

package com.zxd1997.Services;

import com.zxd1997.Beans.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    public boolean add(Message message);

    public List<Message> findall();

    public boolean delete(int id);

    public List<Message> find_page(int n);

    public List<Message> find_page_With_con(int n, Map map);

    public int getPages();
    public int getPagewithCon(Map map);
}

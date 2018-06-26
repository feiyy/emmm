package com.zxd1997.Beans;

import com.zxd1997.Util.ContentFilter;

import javax.tools.Tool;
import java.util.Date;

public class Message {
	
    private String name;
    private String title;
    private String content;
    private int id;
    private Date time;
    public Message(){}
    public Message(String name, String title, String content, int id, Date time) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.id = id;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = ContentFilter.StringFilter(name);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = ContentFilter.StringFilter(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = ContentFilter.StringFilter(content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

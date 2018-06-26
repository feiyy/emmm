package com.zxd1997.Util;

public class ContentFilter {
    public static String StringFilter(String s){
        if (s==null){
            return null;
        }
        if (s.length()==0){
            return s;
        }
        s=s.replaceAll("&","&amp;");
        s=s.replaceAll("<","&lt;");
        s=s.replaceAll(">","&gt;");
        s=s.replaceAll(" ","&nbsp;");
        s=s.replaceAll("'","&#39;");
        s=s.replaceAll("\"","&quot;");
        s=s.replaceAll("\n","<br>");
        return s;
    }
}

package com.zxd1997.Controller;

import com.zxd1997.Beans.Message;
import com.zxd1997.Services.MessageService;
import com.zxd1997.Services.UserService;
import com.zxd1997.Util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyHandler {
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/find")
    public String find(HttpServletRequest request,int page){
        System.out.println("____MyHandler____find()");
        Page pages=new Page(messageService.getPages(), page);
        request.setAttribute("list",messageService.find_page(pages.getPage()));
        request.setAttribute("page",pages);
        return "forward:/msg.jsp";
    }
    @RequestMapping(value = "/findall")
    @ResponseBody
    public List<Message> findall(){
        System.out.println("____MyHandler____find()");
        return messageService.findall();
    }
    @RequestMapping(value = "/addajax")
    @ResponseBody
    public String addajax(Message message){
        System.out.println(message.getName()+message.getContent());
        messageService.add(message);
        return "{\"result\":\"success\"}";
    }
    @RequestMapping(value = "/findwithcon")
    public String findwithcon(HttpServletRequest request,int page,String name, String title ,String content){
        System.out.println("____MyHandler____findwithcon()");
        HttpSession session=request.getSession();
        Map<String,Object> map;
        if (session.getAttribute("map")!=null)
            map=(Map<String, Object>) session.getAttribute("map") ;
        else map=new HashMap<>();
        if(null!=name||null!=title||null!=content) {
            map.put("name",name);
            map.put("title",title);
            map.put("content",content);
        }
        session.setAttribute("map",map);
        System.out.println((String )map.get("name")+map.get("title")+map.get("content"));
        Page pages=new Page(messageService.getPagewithCon(map), page);
        request.setAttribute("list",messageService.find_page_With_con(pages.getPage(),map));
        request.setAttribute("page",pages);
        return "forward:/msg.jsp";
    }
    @RequestMapping(value = "/unit/add")
    public String add(HttpServletRequest request,Message message){
        System.out.println("____MyHandler____add()");
        HttpSession session=request.getSession();
        message.setName((String) session.getAttribute("username"));
        if (messageService.add(message)){
            session.setAttribute("map",new HashMap<>());
            return "redirect:/findwithcon?page=1";
        }else {
            request.setAttribute("msg","Failed");
            return "redirect:/msgworng.jsp";
        }
    }
    @RequestMapping(value = "/unit/delete")
    public String delete(HttpServletRequest request,int id){
        if (messageService.delete(id)) {
            return "forward:/findwithcon";
        } else {
            request.setAttribute("msg", "Delete failed");
            return "forward:/msgworng.jsp";
        }
    }
    @RequestMapping(value = "/change")
    public String change(int num){
        Page.setN(num);
        System.out.println(num);
        return "forward:/findwithcon?page=1";
    }
    @RequestMapping(value = "/Login")
    public String login(HttpServletRequest request,String username,String password){
        if (userService.login(username,password)){
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            return "forward:/findwithcon?page=1";
        }else {
            request.setAttribute("msg", "Login failed");
            return "forward:/msgworng.jsp";
        }
    }
//    @RequestMapping(value = "/upload")
//    public String upload(HttpServletRequest request,String username, String password, MultipartFile upload){
//        String filename=System.currentTimeMillis()+upload.getOriginalFilename();
//        String path=request.getServletContext().getRealPath("/");
//        File f=new File(path);
//        String ppath=f.getParent();
//        path=ppath+"/upload";
//        File dest=new File(path,filename);
//        try {
//            upload.transferTo(dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "index.jsp";
//    }

    @RequestMapping(value = "/uploadajax")
    @ResponseBody
    public String uploadajax(HttpServletRequest request, MultipartFile upload){
        String filename=System.currentTimeMillis()+upload.getOriginalFilename();
        String path=request.getServletContext().getRealPath("/");
        File f=new File(path);
        String ppath=f.getParent();
        path=ppath+"/upload";
        File dest=new File(path,filename);
        try {
            upload.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"result:\":true}";
    }
}

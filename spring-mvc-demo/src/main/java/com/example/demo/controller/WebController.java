package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

//@RestController
@Controller // 我是一个控制器，我要在 spring 启动的时候加载并注册
@ResponseBody // 当前类返回的是非静态页面
//@RequestMapping("/web") // 当使用“/web”可以访问到当前类
public class WebController {

    // 当使用“/web”+“/hi”可以访问到当前方法
//    @RequestMapping(value = "/hi",method = RequestMethod.POST)
//    @PostMapping("/hi")
    @GetMapping("/hi")
    public Object sayHi(HttpServletRequest request, HttpServletResponse response) {
        return "Hi," + request.getParameter("name");
    }


    /**
     * 获取单个参数
     *
     * @return
     */
    @GetMapping("/get1")
    public String getParam1(Integer age) {
        return "value：" + age;
    }


    /**
     * 获取多个参数（2个及以上）
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/get2")
    public String getParam2(String name, Integer age) {
        // 执行到此行已经得到了前端传递参数的值，就可以随意使用了
        return "name:" + name + " | age:" + age; // 返回的顺序无所谓
    }

    /**
     * 获取参数类型为对象的 demo
     *
     * @param student
     * @return
     */
    @GetMapping("/get3")
    public String getParam3(Student student) {
        return student.toString();
    }

    /**
     * 获取 form 表单中的参数
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(String name, String password) {
        // 伪代码...
        return "<h1>用户名：" + name + " | 密码：" + password + "</h1>";
    }

    @RequestMapping("/login2")
    public HashMap<String, Object> login2(String name, String password) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("password", password);
        return result;
    }

    /**
     * 得到用户传递的 JSON 对象
     *
     * @param user
     * @return
     */
    @RequestMapping("/login3")
    public HashMap<String, Object> login3(@RequestBody User user) {
        HashMap<String, Object> result = new HashMap<>();
            result.put("name", user.getName());
        result.put("password", user.getPassword());
        return result;
    }

    /**
     * 获取 form 表单（多个参数）
     *
     * @param user
     * @return
     */
    @RequestMapping("/reg")
    public String reg(User user) {
        // 业务代码...
        return user.toString();
    }

    @RequestMapping("/reg2")
    public String reg2(String name, @RequestPart("myfile") MultipartFile file) throws IOException {
        // 保存文件
        file.transferTo(new File("img2.png"));
        return "success";
    }

    /**
     * spring mvc 获取 cookie 值
     */
    @RequestMapping("/getck")
    public String getCookie(@CookieValue("bite") String bite,
                            @CookieValue("java") String java) {
        return "bite:" + bite + " |java:" + java;
    }

    /**
     * 设置 session
     *
     * @param request
     * @return
     */
    @RequestMapping("/setsess")
    public String setsess(HttpServletRequest request) {
        // 获取 HttpSession 对象，参数设置为 true 表示如果没有 session 对象就创建一个 session
        HttpSession session = request.getSession(true);
        if (session != null) {
            session.setAttribute("username", "java666");
        }
        return "session 存储成功";
    }


    /**
     * 读取 session
     *
     * @param username
     * @return
     */
    @RequestMapping("/getsess")
    public String getsess(@SessionAttribute(value = "username", required = false) String username) {
        return "username:" + username;
    }


    /**
     * 读取请求头 header 里面的信息
     *
     * @param userAgent
     * @return
     */
    @RequestMapping("/gethead")
    public String getHead(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent:" + userAgent;
    }

    /**
     * 前端参数重命名
     *
     * @param time
     * @return
     */
    @RequestMapping("/gettime")
    public String getTime(@RequestParam(value = "t", required = false) String time) {
        return "time:" + time;
    }

    /**
     * 从 url 中获取参数
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login4/{name}/{password}")
    public String login4(@PathVariable("name") String username,
                         @PathVariable String password) {
        return "username:" + username + " | password:" + password;
    }

}

package com.cydi.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cydi.common.ResultObj;
import com.cydi.domain.User;
import com.cydi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录前端控制器
 * @author cyd
 * @Package com.cydi.controller
 * @date 2020/6/1 11:45
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到登陆页面
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultObj login(String loginname,String pwd,String code,HttpSession session) {
        Object codeSession = session.getAttribute("code");
        if(code!=null&&code.equals(codeSession)) {

            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("loginname", loginname);
            queryWrapper.eq("pwd", pwd);
            User user = userService.getOne(queryWrapper);
            if(null!=user) {
                session.setAttribute("user", user);
                return new ResultObj(200, "登陆成功");
            }else {
                return new ResultObj(-1, "用户名或密码不正确");
            }
        }else {
            return new ResultObj(-1, "验证码错误");
        }

    }


    @RequestMapping("getCode")
    public void getCode(HttpServletResponse resp, HttpSession session) throws IOException {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(116, 36, 4, 5);
        //得到code
        String code = captcha.getCode();
        System.out.println(code);
        //放到session
        session.setAttribute("code", code);
        ServletOutputStream outputStream = resp.getOutputStream();
        captcha.write(outputStream);
        outputStream.close();
    }
}

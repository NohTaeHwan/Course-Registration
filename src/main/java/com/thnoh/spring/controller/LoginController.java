package com.thnoh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * name : LoginController
 * Controller Layer
 *
 * /login url 로 오는 요청을 처리
 * error 와 logout 함께 처리
 *
 * @return : login view
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error",required = false) String error,
                        @RequestParam(value = "logout",required = false) String logout,
                        Model model){

        if(error!=null){
            model.addAttribute("errorMsg","유효하지 않은 아이디와 비밀번호입니다.");
        }

        if(logout!=null){
            model.addAttribute("logoutMsg","로그아웃 성공");
        }

        return "login";
    }



}

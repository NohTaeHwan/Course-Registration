package com.thnoh.spring.controller;

import com.thnoh.spring.model.User;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Name : RegisterController
 * Controller Layer
 *
 *** 회원가입 처리
 *** 회원가입 폼 요청 , 회원가입 처리
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    /**
     * GET 회원가입 폼 요청
     *
     * @param model
     * @return 회원가입 form view
     */
    @RequestMapping("/register")
    public String registerUser(Model model){

        User user = new User();

        model.addAttribute("user",user);

        return "registerUser";
    }

    /**
     * POST 회원가입 처리
     *
     * 아이디 중복체크, 에러 체크.
     *
     * @param user
     * @param bindingResult
     * @param model
     * @return 회원가입 성공 view
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUserPost(@Valid User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "registerUser";
        }

        List<User> userList = userService.getAllUsers();

        //아이디 중복 체크
        for(User obj:userList){
            if(user.getUsername().equals(obj.getUsername())){
                model.addAttribute("usernameMsg","아이디가 이미 있습니다");
                return "registerUser";
            }
        }

        user.setEnabled(true);

        //권한 설정(admin , user)
        if(user.getUsername().equals("admin"))
            user.setAuthority("ROLE_ADMIN");
        else
            user.setAuthority("ROLE_USER");


        userService.addUser(user);

        return "registerSuccess";
    }
}

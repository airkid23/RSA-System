package cn.edu.lingnan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PROGRAM: rsa_system
 * @PACKAGE_NAME: cn.edu.lingnan.controller
 * @DESCRIPTION controller
 * @Author wzj
 * @create: 2020-06-02 9:49
 **/
@Controller
public class IndexController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/trans")
    public String toTrans(){ return "trans";}

}
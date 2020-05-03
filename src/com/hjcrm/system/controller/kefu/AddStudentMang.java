package com.hjcrm.system.controller.kefu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddStudentMang {
    @RequestMapping("/custom/addStudentMang.do")
    public String addStudentMang(){

        return JumpViewConstants.CUSTOM_ADDSTUDENTMANG;
    }
}

package com.hjcrm.system.controller.huihua;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.entity.Pattertype;
import com.hjcrm.system.service.IPatterService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyPatterConntroller {
    @Autowired
    IPatterService patterService;
    @RequestMapping("/patter/myPatter.do")
    public String myPatter(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.PATTER_MYPATTER;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/patter/queryPatter.do")
    public @ResponseBody
    String queryPattertype(Patter patter){
        List<Patter> list=patterService.queryPatter(patter);
        if(list.size()>0){
            return PageBean.jsonToPage(list,null);
        }
        return "null";
    }
    @RequestMapping("/patter/queryPattertype.do")
    public @ResponseBody String queryPattertypeType(Patter patter){
        List<Pattertype> list=patterService.queryPatterType(patter);
        if(list.size()>0){
            return PageBean.jsonToPage(list,null);
        }
        return "null";
    }
    @RequestMapping("/patter/saveOrUpdatePatter.do")
    public @ResponseBody String saveOrUpdatePatter(Patter patter){
        if(patterService.saveOrUpdatePatter(patter)>0){
            return  "success";
        }
        return "error";
    }
    @RequestMapping("/patter/deletePatter.do")
    public @ResponseBody String deletePatter(String patterids,int userid){
        if(patterService.deletePatter(patterids,userid)>0){
            return "success";
        }
        return "error";
    }
    @RequestMapping("/patter/updatePatterIsShare.do")
    public @ResponseBody String updatePatterIsShare(int patterid){
        if(patterService.updatePatterIsShare(patterid)>0){
            return "success";
        }
        return "error";
    }
}

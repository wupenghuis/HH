package com.hjcrm.system.controller.yonghu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.Subject;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.ISubjectService;
import com.hjcrm.system.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    ISubjectService subjectService;
    @RequestMapping("/system/subjectMang.do")
    public String subjectMAng(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_SUBJECT;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/subject/querySubject.do")
    public @ResponseBody String querySubject(Integer currentPage, Integer pageSize,Integer courseid){
       if(currentPage !=0 && pageSize!=0 ){
           //封装分页查询实体类
           System.out.println("请求科目 信息:"+pageSize+"/"+currentPage);
           PageBean pageBean=new PageBean();
           pageBean.setPageSize(pageSize);
           pageBean.setCurrentPage((currentPage-1)*pageSize);

           List<Subject> list=subjectService.querySubject(pageBean);
           pageBean.setCountResult(subjectService.queryAllSubjectInfoCount());
           String roleJoin=PageBean.jsonToPage(list,pageBean);
           System.out.println("roleJoin:"+roleJoin);
           return PageBean.jsonUserInfoToPage(list,subjectService.queryAllSubjectInfoCount(),currentPage);

       }else{
           List<Subject> list=subjectService.querySubjectById(courseid);
           String roleJoin=PageBean.jsonToPage(list,null);
           return roleJoin;
       }
    }
    @RequestMapping("/subject/deleteSubject.do")
    public @ResponseBody String deleteCourse(String subjectids){
        System.out.println("需要删除的 subjectids  :"+subjectids);
        if(subjectService.deleteSubject(subjectids)>0){
            System.out.println("删除成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("删除失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/subject/addOrUpdateSubject.do")
    public @ResponseBody String addOrUpdateSubject(Subject subject){
        System.out.println("需要修改or add的 subject  :"+subject);
        if(subject.getSubjectid()!=0){
            if(subjectService.updateSubject(subject)>0){
                System.out.println("修改成功");
                return ReturnConstants.SUCCESS;
            }else{
                System.out.println("修改失败");
            }

        }else{
            if(subjectService.addSubject(subject)>0){
                System.out.println("添加成功");
                return ReturnConstants.SUCCESS;
            }else{
                System.out.println("添加失败");
            }
        }
       return ReturnConstants.PARAM_NULL;
    }
}

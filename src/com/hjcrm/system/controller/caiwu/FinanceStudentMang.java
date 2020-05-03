package com.hjcrm.system.controller.caiwu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FinanceStudentMang {
    @Autowired
    IStudentService studentService;
    @RequestMapping("/finance/financeStudentMang.do")
    public String financeStudentMang(){

        return JumpViewConstants.FINANCE_FINANCESTUDENTMANG;
    }
    @RequestMapping("/report/queryStudentscaiwu.do")
    public @ResponseBody String financeStudentMang(Integer currentPage,Integer pageSize){
        Student student=new Student();
        student.setPageSize(pageSize);
        student.setCurrentPage((currentPage-1)*pageSize);
        List<Student> list=studentService.queryStudnetMatchs(student);
        int i=list.size();
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setCountResult(i);
        return PageBean.jsonToPage(list,pageBean);
    }




    //到账信息
    @RequestMapping("matchinfo/macthinfor.do")
    public String macthinfor(){
        return JumpViewConstants.FINANCE_MACTHINFOR;
    }
    //到账信息查询
    @RequestMapping("/matchinfo/queryMatchinfo.do")
    public @ResponseBody String queryMatchinfo(Integer currentPage,Integer pageSize){
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        List<Matchinfo> list=studentService.queryMatchinfo();
        return PageBean.jsonToPage(list,pageBean);
    }



    //网络培训费
    @RequestMapping("/matchinfo/networkTrain.do")
    public String networkTrain(){
        return JumpViewConstants.FINANCE_MACTHINFOR;
    }
}

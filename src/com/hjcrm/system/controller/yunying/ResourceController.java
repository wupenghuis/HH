package com.hjcrm.system.controller.yunying;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Resource;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.IResourceService;
import com.hjcrm.system.service.IUserService;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResourceController {
    @Autowired
    IResourceService resourceService;
    @Autowired
    IUserService userService;
    @RequestMapping("/resource/resourcesMang.do")
    public String resourcesMang(){
        return JumpViewConstants.RESOURCE_RESOURCESMANG;
    }

    @RequestMapping("/resource/queryResource.do")
    public @ResponseBody String queryResource(Resource resource,Integer roleid,Integer currentPage, Integer pageSize,Integer userid){
        System.out.println("pageSize"+pageSize);
        System.out.println("currentPage"+currentPage);
        resource.setPageSize(pageSize);
        resource.setCurrentPage((currentPage-1)*15);
        resource.setUserid(userid);
        System.out.println("resource"+resource);
        List<Resource> list=resourceService.queryResource(resource);
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage((currentPage-1)*15);
        pageBean.setCountResult(resourceService.queryResourceCount(resource));
        System.out.println("pa"+pageBean.toString());
        String jsionResource=PageBean.jsonToPage(list,pageBean);
        return jsionResource;
    }
    @RequestMapping("/resource/addResource.do")
    public @ResponseBody String addResource(Resource resource){
        if(resource.getResourceId()>0){
            if(resource.getAddress()!=null){
                System.out.println("asdsadsadsad:++"+resource);
                if(resourceService.updateById(resource)>0){
                    System.out.println("修改成功ss");
                    return  ReturnConstants.SUCCESS;
                }else{
                    System.out.println("修改失败ss");
                }
            }else{
                //修改分配
                if(resourceService.updateResource(resource)>0){
                    System.out.println("修改成功");
                    return  ReturnConstants.SUCCESS;
                }else{
                    System.out.println("修改失败");
                }
            }
        }else{
            System.out.println("添加的信息："+resource);
            if(resourceService.addResource(resource)>0){
                System.out.println("添加成功");
                return  ReturnConstants.SUCCESS;
            }else{
                System.out.println("添加失败");
            }
        }
       return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/resource/queryAllCreatePerson.do")
    public @ResponseBody String queryAllCreatePerson(Resource resource){
        System.out.println("resource :::++"+resource);
        if(resource.getUserid()!=0){
            List<User> list=userService.queryAllUser();
            for (User u:list) {
                System.out.println("u:"+u);
            }
            return PageBean.jsonToPage(list,null);
        }else{
            System.out.println("无参");

            List<User> list=userService.queryAllUser();
            return PageBean.jsonToPage(list,null);
        }
    }
    @RequestMapping("/resource/deleteResources.do")
    public @ResponseBody String deleteResources(String resourceId){
        System.out.println("resourceId:---------"+resourceId);
        if(resourceService.deleteResources(resourceId)>0){
            System.out.println("删除成功");
            return  ReturnConstants.SUCCESS;
        }else{
            System.out.println("删除失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/resource/queryResourceCount.do")
    public @ResponseBody String queryResourceCount(Resource resource){
        System.out.println("resourceId:---------"+resource.getUserid());
        int i=resourceService.queryResourceCount(resource);
        PageBean pageBean=new PageBean();
        pageBean.setCountResult(i);
        //List<Integer> list=new ArrayList<>();
        //list.add(i);
        return PageBean.jsonToPage(null,pageBean);
    }
    @RequestMapping("/resource/queryAllXiaoShou.do")
    public @ResponseBody String queryAllXiaoShou(){
        List<User> list=userService.queryAllUser();

        return PageBean.jsonToPage(list,null);
    }
    @RequestMapping("/resource/assigntoResource.do")
    public @ResponseBody String assigntoResource(String belongid,String resourceIds,String states){
        System.out.println("----------------------------"+Integer.parseInt(resourceIds));
        System.out.println("----------------------------"+Integer.parseInt(belongid));
        System.out.println("----------------------------"+Integer.parseInt("1"));

        Resource r=new Resource();
        r.setBelongid(Integer.parseInt(belongid));
        r.setResourceId(Integer.parseInt(resourceIds));
        if(resourceService.assigntoResource(r)>0){
            System.out.println("分配成功");
            return ReturnConstants.SUCCESS;
        }else {
            System.out.println("分配失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/resource/queryResourceBySceen.do")
    public @ResponseBody String queryResourceBySceen(Resource resource){
        List<Resource> list=resourceService.queryResource(resource);
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(resource.getPageSize());
        pageBean.setCountResult(5);
        pageBean.setCurrentPage((resource.getCurrentPage()-1)*resource.getPageSize());
        System.out.println("PageSize"+resource.getPageSize());
        System.out.println("CurrentPage"+(resource.getCurrentPage()-1)*resource.getPageSize());
        String jsionResource=PageBean.jsonToPage(list,pageBean);
        return jsionResource;
    }
}

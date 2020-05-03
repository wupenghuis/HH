package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.entity.Pattertype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatterDao {
    //话术显示
    List<Patter> queryPatter(Patter patter);
    List<Pattertype> queryPatterType(Patter patter);
    //话术添加社修改
    int updatePatter(Patter patter);
    int addPatter(Patter patter);
    //话术删除
    int deletePatter(@Param("list") List<Integer> list, @Param("userid") int userid);

    int updatePatterIsShare(int patterid);
}

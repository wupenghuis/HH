package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.entity.Pattertype;

import java.util.List;

public interface IPatterService {
    List<Patter> queryPatter(Patter patter);
    List<Pattertype> queryPatterType(Patter patter);
    int saveOrUpdatePatter(Patter patter);

    int deletePatter(String patterids,int userid);

    int updatePatterIsShare(int patterid);
}

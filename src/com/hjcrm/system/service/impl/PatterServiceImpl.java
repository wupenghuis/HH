package com.hjcrm.system.service.impl;
import com.hjcrm.publics.util.SplitIdsUtil;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.entity.Pattertype;
import com.hjcrm.system.mapper.PatterDao;
import com.hjcrm.system.mapper.PattertypeDao;
import com.hjcrm.system.service.IPatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("patterService")
public class PatterServiceImpl implements IPatterService {
    @Autowired
    private PatterDao myPatterDao;
    @Override
    public List<Patter> queryPatter(Patter patter) {
        return myPatterDao.queryPatter(patter);
    }

    @Override
    public List<Pattertype> queryPatterType(Patter patter) {
        return myPatterDao.queryPatterType(patter);
    }

    @Override
    public int saveOrUpdatePatter(Patter patter) {
        if(patter.getPatterid()!=0){
            return  myPatterDao.updatePatter(patter);
        }else{
            return  myPatterDao.addPatter(patter);
        }
    }

    @Override
    public int deletePatter(String patterids, int userid) {
        List<Integer> list=SplitIdsUtil.SplitIdstoList(patterids);

        return myPatterDao.deletePatter(list,userid);
    }

    @Override
    public int updatePatterIsShare(int patterid) {
        return myPatterDao.updatePatterIsShare(patterid);
    }
}

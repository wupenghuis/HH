package com.hjcrm.system.mapper;

import com.hjcrm.system.entity.Visitrecord;
import com.hjcrm.system.entity.Visitrecord;

import java.util.List;

public interface VisitrecordDao {
    //回访显示
    int addVisitrecord(Visitrecord visitrecord);
    List<Visitrecord> selectVisitrecord();
}

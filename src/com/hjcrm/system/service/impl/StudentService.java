package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.entity.Visitrecord;
import com.hjcrm.system.mapper.DealrecordDao;
import com.hjcrm.system.mapper.StudentDao;
import com.hjcrm.system.mapper.VisitrecordDao;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService implements IStudentService{
    @Autowired
    StudentDao studentDao;
    @Autowired
    DealrecordDao dealrecordDao;
    @Autowired
    VisitrecordDao visitrecordDao;
    @Override
    public List<Student> queryStudent() {
        return studentDao.queryStudent();
    }

    @Override
    public List<Student> queryStudnetMatchs(Student student) {
        return studentDao.queryStudnetMatchs(student);
    }

    @Override
    public List<Matchinfo> queryMatchinfo() {
        return studentDao.queryMatchinfo();
    }

    @Override
    public List<Student> queryPassStudents(Student student) {
        return studentDao.queryPassStudents(student);
    }

    @Override
    public List<Student> queryOnLineStudents(Student student) {
        return studentDao.queryOnLineStudents(student);
    }

    @Override
    public List<Student> queryStudentById(Student student) {
        return studentDao.queryStudentById(student);
    }

    @Override
    public int addDealrecord(Dealrecord dealrecord) {
        return dealrecordDao.addDealrecord(dealrecord);
    }

    @Override
    public int commit_caiwu(int studentIds) {
        return studentDao.commit_caiwu(studentIds);
    }

    @Override
    public int addstudent(Dealrecord dealrecord) {
        return studentDao.addstudent(dealrecord);
    }

    @Override
    public int returnStudent(Student student) {
        return studentDao.returnStudent(student);
    }

    @Override
    public int studentCommit(int studentId) {
        return studentDao.studentCommit(studentId);
    }

    @Override
    public int addVisitrecord(Visitrecord visitrecord) {
        return visitrecordDao.addVisitrecord(visitrecord);
    }

    @Override
    public List<Visitrecord> selectVisitrecord() {
        return visitrecordDao.selectVisitrecord();
    }


}

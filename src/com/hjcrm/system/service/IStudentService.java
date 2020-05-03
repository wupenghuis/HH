package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.entity.Visitrecord;

import java.util.List;

public interface IStudentService {
    public List<Student> queryStudent();

    public List<Student> queryStudnetMatchs(Student student);

    public List<Matchinfo> queryMatchinfo();

    public List<Student> queryPassStudents(Student student);

    public List<Student> queryOnLineStudents(Student student);

    public List<Student> queryStudentById(Student student);

    public int addDealrecord(Dealrecord dealrecord);

    //提交修改  1
    public int commit_caiwu(int studentIds);

    public int addstudent(Dealrecord dealrecord);

    public int returnStudent(Student student);

    public int studentCommit(int studentId);


    //回访表
    int addVisitrecord(Visitrecord visitrecord);
    List<Visitrecord> selectVisitrecord();


}

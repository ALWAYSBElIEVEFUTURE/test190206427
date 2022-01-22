package com.bjpowernode.test;

import com.bjpowernode.entity.MyStudent;
import com.bjpowernode.entity.Student;
import com.bjpowernode.vo.StudentClassRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentTest {

     Student selectStudents(Integer id);

     List<Student> selectMultiQuery(@Param("studentName")  String name, @Param("studentAge") Integer age);

     List<Student> selectMultiObject(Student student);

     List<Student> selectMultiPosition(String name,Integer age);

     List<Student> selectMultiMap(Map<String,Object> map);

     List<Student> selectStudent$(@Param("orderName") String name );

     List<Student> selectStudentAlias();

     Map<Object,Object> selectStudentMap(Integer id);

     /**
      *列名与属性名不同的；两种解决方案
      * 方案一
      */
     List<MyStudent> selectColStudent();

     List<MyStudent> selectDiffColStudent();

     List<Student> selectLikeStudent( String name);

     List<Student> selectLikeStudentOne( String name);

     List<Student> selectDynamicSql(Student student);

     List<Student> selectForEach(Integer[] array);

     List<Student> useSqlFragment(@Param("id") Integer id);

     List<Map<String,Object>> multiTableQuery();

     List<StudentClassRoom> useViewQuery();



}

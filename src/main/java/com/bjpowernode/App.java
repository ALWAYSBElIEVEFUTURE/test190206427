package com.bjpowernode;

import com.bjpowernode.entity.Student;
import com.bjpowernode.test.StudentTest;
import com.bjpowernode.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */

public class App 
{
    //传递一个参数的形式
    public static void main(String[] args) throws IOException {
        /*
        * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
        * */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        Student students = dao.selectStudents(1001);
        System.out.println("学生信息为:"+students);
    }
}

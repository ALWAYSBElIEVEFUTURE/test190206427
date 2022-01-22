package com.bjpowernode;

import com.bjpowernode.entity.MyStudent;
import com.bjpowernode.entity.Student;
import com.bjpowernode.test.StudentTest;
import com.bjpowernode.util.MyBatisUtil;
import com.bjpowernode.vo.StudentClassRoom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
   public void selectTest() throws IOException {

        //读取主配置文件中的信息
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId="com.bjpowernode.test.StudentTest"+"."+"selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        for (Student stu:students
             ) {
            System.out.println("学生信息:"+stu);
        }
    }

    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId="com.bjpowernode.test.StudentTest"+"."+"selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        for (Student stu:students
        ) {
            System.out.println("学生信息:"+stu);
        }
    }

    @Test   //简单的一个参数传递
    public void test01(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        Student students = dao.selectStudents(1003);
        System.out.println("学生信息为:"+students);
    }

    @Test   //多个参数传递
    public void test02(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);

        List<Student> students = dao.selectMultiQuery("麻甜甜", 21);
        for (Student student:students
             ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //使用对象的方式实现参数的传递
    public void test03(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        Student stu=new Student();
        stu.setName("张凤敏");
        stu.setAge(22);
        List<Student> students = dao.selectMultiObject(stu);
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //按位置传参
    public void test04(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);

        List<Student> students = dao.selectMultiPosition("张凤敏", 22);
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //使用map的方式进行传参
    public void test05(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        Map<String,Object> map=new HashMap<>();
        map.put("name","麻国庆");
        map.put("age",22);
        List<Student> students = dao.selectMultiMap(map);
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    //测试#与$符的区别
    @Test
    public void test06(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<Student> students = dao.selectStudent$("name");
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //给接口返回值自定义别名
    public void test07(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<Student> students = dao.selectStudentAlias();
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //返回一个Map集合
    public void test08(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        Map<Object, Object> objectObjectMap = dao.selectStudentMap(1001);
        System.out.println("学生信息为:"+objectObjectMap);
    }

    @Test   //列名与属性名不同的；两种解决方案
            //方案一
    public void test09(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<MyStudent> students = dao.selectColStudent();
        for (MyStudent student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //列名与属性名不同的；两种解决方案
            //方案二
    public void test10(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<MyStudent> students = dao.selectDiffColStudent();
        for (MyStudent student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //like查询的两种方案(模糊查询)
            // 方案一:直接传递like后跟的内容
    public void test11(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<Student> students = dao.selectLikeStudent("%麻%");
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //like查询的两种方案(模糊查询)
    // 方案一:在StudentTest.xml(mapper文件)中拼接%#{"属性名"}%
    public void test12(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<Student> students = dao.selectLikeStudent("%麻%");
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   /*like查询的两种方案(模糊查询)
              方案二:
                   在StudentTest.xml(mapper文件)中拼接"%" #{"属性名"} "%";
                   对应的sql的拼接语句:select * from student where name like "%" #{name} "%";
                   */
    public void test13(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<Student> students = dao.selectLikeStudentOne("王");
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //使用对象的方式实现参数的传递
    public void test14(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        Student stu=new Student();
        stu.setName("麻");
        stu.setAge(21);
        List<Student> students = dao.selectDynamicSql(stu);
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //使用foreach实现where id in(1001,1002,1003);
    //实现拼接(1001,1002,1003);
    public void test15(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        Integer array[]={1001,1002,1003};
        List<Student> students = dao.selectForEach(array);
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //使用sql片段
    public void test16(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<Student> students = dao.useSqlFragment(1001);
        for (Student student:students
        ) {
            System.out.println("学生信息:"+student);
        }
    }

    @Test   //多表联查
    public void test17(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<Map<String,Object>> maps=dao.multiTableQuery();
        for (Map<String,Object> student:maps
             ) {
            Set<String> keys = student.keySet();
            for (String key:keys
                 ) {
                System.out.println("key"+key+"  :  "+"value"+student.get(key));
            }
        }
    }

    @Test   //多表联查(使用vo(view object)包）
    public void test18(){
        /**
         * 使用jdk动态代理，动态的创建StudentTest接口实现类对象(不需要手动编写StudentTest接口实现类)
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentTest dao = sqlSession.getMapper(StudentTest.class);
        List<StudentClassRoom> studentClassRooms = dao.useViewQuery();
        for (StudentClassRoom student:studentClassRooms
             ) {
            System.out.println("学生信息:"+student.getsName()+"  "+student.getcName());
        }

    }
}

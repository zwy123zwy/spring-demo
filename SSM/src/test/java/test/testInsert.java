package test;

import T1.User.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.SqlSessionUtil;

import java.io.InputStream;
import java.util.List;

public class testInsert {
    @Test
    public void test1() throws  Exception{
    //获取核心配置文件的输入流
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
//        获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =new SqlSessionFactoryBuilder();
//        获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
//        获取SQL的会话对象sqlSession,是mybatis提供的操作数据库的对象,设置atuocommit为true，将自动提交事务
        SqlSession sqlSession= sqlSessionFactory.openSession();
//        获取UserMapper代理实现类对象
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
//        调用mapper接口中的方法，实现添加用户信息的功能
        int res= mapper.insertUser();
        System.out.println("res:::::" +res);
//        提交事务

        sqlSession.commit();
//       关闭会话
        sqlSession.close();
    }
    @Test
    public void testupdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser();
        sqlSession.close();
    }
    @Test
    public void testdelte(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
        sqlSession.close();
    }
    @Test
    public void testselect(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        User user= userMapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testselectAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        List<User> list= userMapper.getAllUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }

}

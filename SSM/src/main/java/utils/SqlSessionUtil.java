package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    @Test
    public static SqlSession getSqlSession(){
        SqlSession sqlSession =null;
        try {
            //        获取核心文件配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //            获取SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder =new SqlSessionFactoryBuilder();
            //            获取SqlSessionFactory
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
            //           s获取sqlSession对象
            sqlSession=sqlSessionFactory.openSession(true);
        }catch(IOException e){
            e.printStackTrace();
        }
        return  sqlSession;

    }
}

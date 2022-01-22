import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    public static final Logger log = LoggerFactory.getLogger(MybatisTest.class);
    private SqlSessionFactory sqlSessionFactory;

    private void setup() throws IOException {
        String resource = "mybatis-config-test";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

//    @Test
//    void gettingStart() throws IOException {
//        setup();
//
//        // Mybatis의 session은 JDBC의 connetion과 같은 역할을 한다.
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            User user = session.selectOne("UserMapper.findById", "root");
//            log.debug("User {}", user);
//        }
//
////        // 세션 불러오는 새로운 방법
////        try (SqlSession session = sqlSessionFactory.openSession()) {
////            BlogMapper mapper = session.getMapper(UserMapper.class);
////            Blog blog = mapper.selectBlog(101);
////        }
//    }
//
//    @Test
//    void insert() throws IOException {
//        setup();
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            User user = new User("userA", "1234", "김자바", "남자", "111@111.com");
//            session.insert("UserMapper.create", user);
//            User findUser = session.selectOne("UserMapper.findById", "userA");
//            Assertions.assertEquals(user.getUserID(), findUser.getUserID());
//        }
//    }
}

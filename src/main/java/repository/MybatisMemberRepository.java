package repository;

import model.Member;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisMemberRepository implements MemberRepository {

    private SqlSessionFactory sqlSessionFactory;

    @Override
    public int join(Member member) {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.insert("MemberMapper.join", member);
        }
    }

    @Override
    public Member findById(String memberId) {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("MemberMapper.findById", memberId);
        }
    }

    @Override
    public List<Member> findAll() {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("MemberMapper.findAll");
        }
    }

    @Override
    public int update(Member member) {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.update("MemberMapper.update", member);
        }
    }

    @Override
    public int delete(String memberId) {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.update("MemberMapper.delete", memberId);
        }
    }

    private void setUp() {
        String resource = "mybatis-config";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
}

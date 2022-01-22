package repository;

import model.Board;
import model.Pagination;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisBoardRepository implements BoardRepository {

    private SqlSessionFactory sqlSessionFactory;

    @Override
    public Board findById(int boardId) {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("BoardMapper.findById", boardId);
        }
    }

    @Override
    public List<Board> getList() {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("BoardMapper.findAll");
        }
    }

    // pagination test
    public List<Board> getPageList(Pagination pagination) {
        setUp();

        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("BoardMapper.getPageList", pagination);
        }
    }

    @Override
    public int write(Board board) {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.insert("BoardMapper.write", board);
        }
    }

    @Override
    public int delete(int boardId) {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.update("BoardMapper.delete", boardId);
        }
    }

    @Override
    public int update(Board board) {
        setUp();
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.update("BoardMapper.update", board);
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

package repository;

import model.Comment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ImplCommentRepository implements CommentRepository {

    private SqlSessionFactory sqlSessionFactory;

    public ImplCommentRepository() {
        String resource = "mybatis-config";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    // 댓글 번호로 조회할 일이 있을까?
    @Override
    public Comment findById(int commentId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("CommentMapper.findById", commentId);
        }
    }

    @Override
    public List<Comment> findAllByBoardId(int boardId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("CommentMapper.findAll", boardId);
        }
    }

    @Override
    public int write(Comment comment) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.insert("CommentMapper.write", comment);
        }
    }

    @Override
    public int update(Comment comment) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.update("CommentMapper.update", comment);
        }
    }

    @Override
    public int delete(int commentId) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.update("CommentMapper.delete", commentId);
        }
    }
}

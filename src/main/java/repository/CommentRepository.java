package repository;

import model.Comment;

import java.util.List;

public interface CommentRepository {

    Comment findById(int commentId);

    List<Comment> findAllByBoardId(int boardId);

    int write(Comment comment);

    int update(Comment comment);

    int delete(int commentId);

}

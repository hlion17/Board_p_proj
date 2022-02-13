package repositoryTest;

import model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import repository.CommentRepository;
import repository.ImplCommentRepository;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommentRepositoryTest {

    private CommentRepository commentRepository = new ImplCommentRepository();

    private Comment cm1;

    @Before
    public void setUP() {
        cm1 = new Comment(1, "테스트 댓글", "테스트 작성자", new Date(), 1, 30);
    }


    @Test
    @DisplayName("댓글 작성과 조회 테스트")
    public void writeAndViewCommentTest() {
        // Given

        // When
        commentRepository.write(cm1);
        Comment searchedComment = commentRepository.findById(cm1.getCommentId());

        // Then
        assertEquals(cm1.getCommentId(), searchedComment.getCommentId());
    }

    @Test
    @DisplayName("게시글에 해당되는 모든 댓글 조회")
    public void searchAllComment() {
        // Given

        // When
        List<Comment> searchedComments = commentRepository.findAllByBoardId(28);

        // Then
        assertNotNull(searchedComments);
        for (Comment searchedComment : searchedComments) {
            System.out.println(searchedComment);
        }
    }

    // 검증방법 문제 있는거 같음
    @Test
    @DisplayName("댓글 수정 기능 테스트")
    public void updateCommentTest() {
        // Given
        Comment cm = new Comment(1, "테스트 댓글", "테스트 작성자", new Date(), 1, 30) ;
        Comment updateComment = new Comment(1, "수정된 댓글", "테스트 작성자", new Date(), 1, 30);

        // When
        commentRepository.write(cm);
        commentRepository.update(updateComment);
        // DTO의 ID로 조회하는건 의미가 없다.
        // DB에서 자동증가 스퀀스 값이 들어가기 때문
        // 저장한 댓글을 어떻게 특정해서 조회할지 고민해보자
        Comment updatedComment = commentRepository.findById(cm.getCommentId());

        // Then
        assertEquals(updateComment.getContent(), updatedComment.getContent());
    }


    // 검증방법 문제 있는거 같음
    @Test
    @DisplayName("댓글 삭제 기능 테스트")
    public void deleteCommentTest() {
        // Given

        // When
        commentRepository.delete(3);
        Comment searchedComment = commentRepository.findById(3);

        // Then
        assertEquals(0, searchedComment.getDeleteAt());

    }
}

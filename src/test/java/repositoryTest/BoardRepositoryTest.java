package repositoryTest;

import model.Board;
import model.Member;
import model.Pagination;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import repository.BoardRepository;
import repository.MybatisBoardRepository;
import service.BoardService;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardRepositoryTest {

    private BoardRepository boardRepository = new MybatisBoardRepository();

    // 게시글 테스트 멤버
    private Member testMember;

    private Board b1;
    private Board b2;
    private Board b3;

    @Before
    public void setUp() {
        testMember = new Member("bTester", "testPW", "jUnit테스터", "T", "bTest@test.com");
    }

    @Test
    @DisplayName("전체 게시글 조회 테스트")
    public void showAllListTest() {
        // given
        int allPostCount = boardRepository.getList().size();
        int curPage = 1;
        Pagination pagination = new Pagination(allPostCount, curPage);

        // when
        List<Board> pageList = boardRepository.getPageList(pagination);

        // then
        assertNotNull(pageList);

        // 확인용으로 찍어보기
        for (Board board : pageList) {
            System.out.println(board);
        }
    }

    @Test
    @DisplayName("게시글 작성 테스트")
    public void insertPostTest() {
        // Given

        // 특수문자 대체 하는 로직 분리하기 (할일)
        b1 = new Board(
                "jUnit4 테스트 작성글"
                        .replaceAll(" ", "&nbsp;")
                        .replaceAll("<", "&lt;")
                        .replaceAll(">", "&gt")
                        .replaceAll("\n", "<br>"),
                testMember.getMemberId(),
                new Date(Calendar.getInstance().getTimeInMillis()),
                "게시글 내용"
                        .replaceAll(" ", "&nbsp;")
                        .replaceAll("<", "&lt;")
                        .replaceAll(">", "&gt")
                        .replaceAll("\n", "<br>")
        );

        // When
        int writeResult = boardRepository.write(b1);  // 게시글 작성

        // Then
        assertEquals(1, writeResult);
    }

    // 게시글 삭제 테스트 어떻게 만들어야되는지 모르겠음
    // 삭제할 게시글을 어떻게 특정하지?
    // boardid로만 접근할 수 있는데데
}

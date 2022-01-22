import model.Board;
import model.Member;
import model.Pagination;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import repository.BoardRepository;
import repository.MemberRepository;
import repository.MybatisBoardRepository;
import repository.MybatisMemberRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    private MemberRepository memberRepository = new MybatisMemberRepository();
    private BoardRepository boardRepository = new MybatisBoardRepository();

    @Test
    void findByIdTest() {
        MemberRepository memberRepository = new MybatisMemberRepository();

        Member findMember = memberRepository.findById("root");

        System.out.println(findMember);
    }

    @Test
    void findAllTest() {
        MemberRepository memberRepository = new MybatisMemberRepository();

        List<Member> list = memberRepository.findAll();

        System.out.println("list = " + list);

    }

    @Test
    void joinTest() {
        Member member = new Member("hlion21", "1234", "박자바", "남자", "jave@daum.net");
        memberRepository.join(member);

        Member foundMember = memberRepository.findById(member.getMemberId());

        assertEquals(member.getMemberId(), foundMember.getMemberId());
    }

    @Test
    void findAllBoards() {
        List<Board> list = boardRepository.getList();
        System.out.println("list = " + list);
    }

    @Test
    void findByIdBoard() {
        Board board = boardRepository.findById(1);
        System.out.println("board = " + board);
    }

    @Test
    void boardWriteTest() {
        // Given
        Board board = new Board(
                10,
                "이것은 제목",
                "test1",
                "2021-08-19",
                "이것은 내용",
                1
        );

        // When
        boardRepository.write(board);

        // Then
        Board searchedBoard = boardRepository.findById(board.getBoardId());
        assertEquals(searchedBoard.getBoardId(), board.getBoardId());
    }

    @Test
    void deleteTest() {
        // Given

        // When
        int deleteResult = boardRepository.delete(10);

        // Then
        Board searchedBoard = boardRepository.findById(10);
        int ba = searchedBoard.getBoardAvailable();

        System.out.println("ba = " + ba);
        System.out.println("deleteResult = " + deleteResult);

    }

    @Test
    void getPageListTest() {
        // Given

        // When
        List<Board> postPerPage = boardRepository.getPageList(new Pagination(24, 3));

        // Then
        for (Board board : postPerPage) {
            System.out.println(board.getBoardId());
        }


    }

}

package repositoryTest;

import model.Member;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import repository.BoardRepository;
import repository.MemberRepository;
import repository.MybatisBoardRepository;
import repository.MybatisMemberRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberRepositoryTest {

    // repository 객체
    private BoardRepository boardRepository = new MybatisBoardRepository();
    private MemberRepository memberRepository = new MybatisMemberRepository();

    // 테스트용 멤버 객체
    private Member m1;
    private Member m2;
    private Member m3;

    @Before
    public void setUp() {
        m1 = new Member("test1", "t1", "김테스트", "남", "test1@test.com");
        m2 = new Member("test2", "t2", "김테스트", "남", "test2@test.com");
        m3 = new Member("test3", "t3", "김테스트", "남", "test3@test.com");
    }

    @Test
    @DisplayName("테스트")
    public void getTest() {
        // bbs.PUBLIC.MEMBER
        // -> member
        Member updatedMember = new Member("test","updatedPW", "김수정", "여", "update@test.com");
        memberRepository.update(updatedMember);

    }

    @Test
    @DisplayName("멤버 추가 및 조회 테스트")
    public void addAndGetTest() {
        memberRepository.join(m1);
        memberRepository.join(m2);
        memberRepository.join(m3);

        Member searchedM1 = memberRepository.findById(m1.getMemberId());
        Member searchedM2 = memberRepository.findById(m2.getMemberId());
        Member searchedM3 = memberRepository.findById(m3.getMemberId());

        checkSameMember(m1, searchedM1);
        checkSameMember(m2, searchedM2);
        checkSameMember(m3, searchedM3);

        // 삭제
        memberRepository.delete(m1.getMemberId());
        memberRepository.delete(m2.getMemberId());
        memberRepository.delete(m3.getMemberId());

        Member deletedM1 = memberRepository.findById(m1.getMemberId());
        Member deletedM2 = memberRepository.findById(m2.getMemberId());
        Member deletedM3 = memberRepository.findById(m3.getMemberId());

        assertNull(deletedM1);
        assertNull(deletedM2);
        assertNull(deletedM3);
    }

    private void checkSameMember(Member m1, Member m2) {
        assertEquals(m1.getMemberId(), m2.getMemberId());
        assertEquals(m1.getMemberName(), m2.getMemberName());
        assertEquals(m1.getMemberPassword(), m2.getMemberPassword());
        assertEquals(m1.getMemberGender(), m2.getMemberGender());
        assertEquals(m1.getMemberEmail(), m2.getMemberEmail());
    }


}

package repository;

import model.Member;

import java.util.ArrayList;
import java.util.List;

public interface MemberRepository {

    int join(Member member);

    Member findById(String memberId);

    List<Member> findAll();

    int update(Member member);

    int delete(String memberId);

}

package service;

import controller.MyModelAndView;
import model.Member;
import repository.MemberRepository;
import repository.MybatisMemberRepository;

import java.util.Map;


public class MemberService {

    MemberRepository memberRepository = new MybatisMemberRepository();

    public String join(Map<String, String> paramMap, Map<String, Object> model) {

        Member member = new Member(
                paramMap.get("memberId"),
                paramMap.get("memberPassword"),
                paramMap.get("memberName"),
                paramMap.get("memberGender"),
                paramMap.get("memberEmail")
        );

        memberRepository.join(member);

        model.put("member", member);

        return "member/login";
    }

    public String login(Map<String, String> paramMap, Map<String, Object> model) {

        String memberId = paramMap.get("memberId");
        String memberPassword = paramMap.get("memberPassword");

        Member searchedMember = memberRepository.findById(memberId);

        if (searchedMember == null) {
            model.put("loginResult", -1);  // 아이디 없음
            return "member/login";
        } else if (searchedMember.getMemberPassword().equals(memberPassword)) {
            model.put("loginResult", 1);  // 로그인 성공
            model.put("memberId", memberId);
            return "home";
        } else {
            model.put("loginResult", 0);  // 패스워드 불일치
            return "member/login";
        }
    }

    public String edit(Map<String, String> paramMap, Map<String, Object> model) {

        Member member = new Member(
                paramMap.get("memberId"),
                paramMap.get("memberPassword"),
                paramMap.get("memberName"),
                paramMap.get("memberGender"),
                paramMap.get("memberEmail")
        );

        System.out.println("member = " + member);

        int updateResult = memberRepository.update(member);
        model.put("updateResult", updateResult);

        return "home";
    }

    public String withdraw(Map<String, String> paramMap, Map<String, Object> model) {

        String memberId = paramMap.get("memberId");

        System.out.println(memberId);

        int deleteResult = memberRepository.delete(memberId);


        model.put("deleteResult", deleteResult);

        return "/home";
    }


}

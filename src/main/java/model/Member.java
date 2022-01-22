package model;

import lombok.Getter;

@Getter
public class Member {
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberGender;
    private String memberEmail;

    public Member() {
    }

    public Member(String memberId, String memberPassword, String memberName, String memberGender, String memberEmail) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberEmail = memberEmail;
    }

//    public Member(String memberPassword, String memberName, String memberGender, String memberEmail) {
//        this.memberPassword = memberPassword;
//        this.memberName = memberName;
//        this.memberGender = memberGender;
//        this.memberEmail = memberEmail;
//    }

    // 테스트용
    @Override
    public String toString() {
        return memberId + ", " + memberPassword + ", " + memberName + ", " + memberGender + ", " + memberEmail;
    }
}

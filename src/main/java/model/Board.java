package model;

import lombok.Getter;

@Getter
public class Board {
    private int boardId;
    private String boardTitle;
    private String memberId;
    private String boardDate;
    private String boardContent;
    private int boardAvailable;

    public Board() {
    }

    public Board(int boardId, String boardTitle, String memberId, String boardDate, String boardContent, int boardAvailable) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.memberId = memberId;
        this.boardDate = boardDate;
        this.boardContent = boardContent;
        this.boardAvailable = boardAvailable;
    }

    // 게시글 등록
    public Board(String boardTitle, String memberId, String boardDate, String boardContent) {
        this.boardTitle = boardTitle;
        this.memberId = memberId;
        this.boardDate = boardDate;
        this.boardContent = boardContent;
    }

    // post update
    public Board(int boardId, String boardTitle, String boardDate, String boardContent) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardDate = boardDate;
        this.boardContent = boardContent;
    }
}

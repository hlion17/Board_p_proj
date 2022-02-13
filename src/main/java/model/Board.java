package model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Board {
    private int boardId;
    private String boardTitle;
    private String memberId;
    private Date boardDate;
    private String boardContent;
    private int boardAvailable;

    public Board() {
    }

    public Board(int boardId, String boardTitle, String memberId, Date boardDate, String boardContent, int boardAvailable) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.memberId = memberId;
        this.boardDate = boardDate;
        this.boardContent = boardContent;
        this.boardAvailable = boardAvailable;
    }

    // 게시글 등록
    public Board(String boardTitle, String memberId, Date boardDate, String boardContent) {
        this.boardTitle = boardTitle;
        this.memberId = memberId;
        this.boardDate = boardDate;
        this.boardContent = boardContent;
    }

    // post update
    public Board(int boardId, String boardTitle, Date boardDate, String boardContent) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardDate = boardDate;
        this.boardContent = boardContent;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", boardTitle='" + boardTitle + '\'' +
                ", memberId='" + memberId + '\'' +
                ", boardDate=" + boardDate +
                ", boardContent='" + boardContent + '\'' +
                ", boardAvailable=" + boardAvailable +
                '}';
    }
}

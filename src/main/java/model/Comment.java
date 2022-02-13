package model;

import java.util.Date;

public class Comment {
    private int commentId;
    private String content;
    private String writer;
    private Date createDate;
    private int deleteAt;
    private int boardId;

    public Comment(int commentId, String content, String writer, Date createDate, int deleteAt, int boardId) {
        this.commentId = commentId;
        this.content = content;
        this.writer = writer;
        this.createDate = createDate;
        this.deleteAt = deleteAt;
        this.boardId = boardId;
    }

    // Repository 에 댓글 넣을 떄
    public Comment(String content, String writer, Date createDate, int boardId) {
        this.content = content;
        this.writer = writer;
        this.createDate = createDate;
        this.deleteAt = deleteAt;
        this.boardId = boardId;
    }

    public int getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getDeleteAt() {
        return deleteAt;
    }

    public int getBoardId() {
        return boardId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", createDate=" + createDate +
                ", deleteAt=" + deleteAt +
                ", boardId=" + boardId +
                '}';
    }
}

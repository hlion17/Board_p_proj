package service;

import model.Board;
import model.Comment;
import model.Pagination;
import repository.BoardRepository;
import repository.CommentRepository;
import repository.ImplCommentRepository;
import repository.MybatisBoardRepository;

//import java.util.Date;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class BoardService {

    BoardRepository boardRepository = new MybatisBoardRepository();
    CommentRepository commentRepository = new ImplCommentRepository();

    public String write(Map<String, String> paramMap, Map<String, Object> model) {

        Board board = replaceSpChar(paramMap);

        boardRepository.write(board);

        model.put("board", board);

        return "redirect:/board/list";
    }



    public String getList(Map<String, String> paramMap, Map<String, Object> model) {

        List<Board> list = boardRepository.getList();

        model.put("boards", list);

        return "board/board";
    }

    // 게시글 리스트 조회
    public String getPageList(Map<String, String> paramMap, Map<String, Object> model) {

        int listCtn = boardRepository.getList().size();
        int curPage;
        int pageSize;

        if (paramMap.get("curPage") != null) {
            curPage = Integer.parseInt(paramMap.get("curPage"));
        } else {
            curPage = 1;
        }

       // 게시글 수 제한 처리(미완성)
//        if (paramMap.get("pageSize") != null) {
//            pageSize = Integer.parseInt(paramMap.get("pageSize"));
//        } else {
//            pageSize = 10;
//        }

        Pagination pagination = new Pagination(listCtn, curPage);
//        pagination.setPageSize(pageSize);

        List<Board> list = boardRepository.getPageList(pagination);

        model.put("boards", list);
        model.put("pagination", pagination);

        return "board/board";
    }

    // 게시글 조회
    public String getPost(Map<String, String> paramMap, Map<String, Object> model) {
        int boardId = Integer.parseInt(paramMap.get("boardId"));

        int listCtn = boardRepository.getList().size();
        int curPage;

        if (paramMap.get("curPage") != null) {
            curPage = Integer.parseInt(paramMap.get("curPage"));
        } else {
            curPage = 1;
        }

        Pagination pagination = new Pagination(listCtn, curPage);
        Board board = boardRepository.findById(boardId);
        List<Comment> comments = commentRepository.findAllByBoardId(boardId);

        model.put("board", board);
        model.put("comments", comments);
        model.put("pagination", pagination);

        return "board/board-content";
    }


    public String delete(Map<String, String> paramMap, Map<String, Object> model) {

        int boardId = Integer.parseInt(paramMap.get("boardId"));

        int deleteResult = boardRepository.delete(boardId);

        model.put("deleteResult", deleteResult);

        return "redirect:/board/list";
    }

    public String update(Map<String, String> paramMap, Map<String, Object> model) {

        Board board = new Board(
                Integer.parseInt(paramMap.get("boardId")),
                paramMap.get("boardTitle")
                        .replaceAll(" ", "&nbsp;")
                        .replaceAll("<", "&lt;")
                        .replaceAll(">", "&gt")
                        .replaceAll("\n", "<br>"),
                new Date(Calendar.getInstance().getTimeInMillis()),
                paramMap.get("boardContent")
                        .replaceAll(" ", "&nbsp;")
                        .replaceAll("<", "&lt;")
                        .replaceAll(">", "&gt")
                        .replaceAll("\n", "<br>")
        );

        int updateResult = boardRepository.update(board);

        model.put("updateResult", updateResult);

        return "redirect:/board/list";
    }

    // 특정 로직에 귀속되어 있다.
    // 특수문자를 바꿔주는 기능을 아무데서나 쓸 수 있는 방법 생각해보자
    private Board replaceSpChar(Map<String, String> paramMap) {
        Board board = new Board(
                paramMap.get("boardTitle")
                        .replaceAll(" ", "&nbsp;")
                        .replaceAll("<", "&lt;")
                        .replaceAll(">", "&gt")
                        .replaceAll("\n", "<br>"),
                paramMap.get("memberId"),
                new Date(Calendar.getInstance().getTimeInMillis()),
                paramMap.get("boardContent")
                        .replaceAll(" ", "&nbsp;")
                        .replaceAll("<", "&lt;")
                        .replaceAll(">", "&gt")
                        .replaceAll("\n", "<br>")
        );
        return board;
    }


}

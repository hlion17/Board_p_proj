package service;

import model.Comment;
import repository.CommentRepository;
import repository.ImplCommentRepository;

import java.util.Date;
import java.util.Map;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository = new ImplCommentRepository();

    @Override
    public String write(Map<String, String> paramMap, Map<String, Object> model) {

        Comment comment = new Comment(
                paramMap.get("content")
                        .replaceAll(" ", "&nbsp;")
                        .replaceAll("<", "&lt;")
                        .replaceAll(">", "&gt")
                        .replaceAll("\n", "<br>"),
                paramMap.get("writer"),
                new Date(),
                Integer.parseInt(paramMap.get("boardId"))
        );

        commentRepository.write(comment);

        return "redirect:/board/post" +
                "?boardId=" + paramMap.get("boardId")
                + "&curPage=" + paramMap.get("curPage");
    }
}

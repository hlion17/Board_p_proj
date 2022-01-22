package repository;

import model.Board;
import model.Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BoardRepository {

    Board findById(int boardId);

    List<Board> getList();

    // pagination Test
    List<Board> getPageList(Pagination pagination);

    int write(Board board);

    int delete(int boardId);

    int update(Board board);
}

package softwareproject.masterplan.board.service;

import softwareproject.masterplan.board.model.Board;
import softwareproject.masterplan.board.model.BoardFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {

    List<Board> selectBoardList(int projectidx) throws  Exception;

    void updateBoard(Board board) throws Exception;

    void saveBoard(Board board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

    Board selectBoardDetail(int boardidx) throws Exception;

    void deleteBoard(int boardidx) throws Exception;

    BoardFile selectBoardFileInformation(int idx, int boardidx) throws Exception;
}


package softwareproject.masterplan.board.service;

import softwareproject.masterplan.board.model.Board;
import softwareproject.masterplan.board.model.BoardFile;
import softwareproject.masterplan.board.repository.BoardRepository;
import softwareproject.masterplan.common.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Optional;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository BoardRepository;

    @Autowired
    FileUtils fileUtils;

    @Override
    public List<Board> selectBoardList(int projectidx) throws  Exception {
        return BoardRepository.findAllByProjectidxByOrderByBoardidxDesc(projectidx);
    }

    @Override
    public void saveBoard(Board board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        board.setCreatorid(username);
        List<BoardFile>list = fileUtils.parseFileInfo(multipartHttpServletRequest);

        if(CollectionUtils.isEmpty(list) == false) {
            board.setFilelist(list);
        }
        BoardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) throws Exception {
        board.setCreatorid("admin");
        BoardRepository.save(board);
    }

    @Override
    public Board selectBoardDetail(int boardidx) throws Exception {
        Optional<Board> optional = BoardRepository.findById(boardidx);
        if(optional.isPresent()) {
            Board board = optional.get();
            board.setHitcnt(board.getHitcnt()+1);
            BoardRepository.save(board);

            return board;
        }
        else {

            throw new NullPointerException();
        }
    }

    @Override
    public void deleteBoard(int boardidx) throws Exception {
        BoardRepository.deleteById(boardidx);
    }

    @Override
    public BoardFile selectBoardFileInformation(int idx,int boardidx) throws Exception {
        BoardFile boardFile = BoardRepository.findBoardFile(idx, boardidx);
        return boardFile;
    }
}

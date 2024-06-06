package WevServer;

import TicTacToe.GameBoard;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/tictactoe")
public class TicTacToeServer {
    private GameBoard gameBoard = new GameBoard();
    @GetMapping
    public String getGamePage() throws IOException {
        return Files.readString(Path.of("src/main/resources/tic.html"));
    }

    @GetMapping("board")
    public List<Character> getBoardState() {
        return gameBoard.getState();
    }

    @GetMapping("winner")
    public String getWinner() {
        Character winner = gameBoard.finished();
        if(winner != null){
        gameBoard = new GameBoard();
        }
        if(winner == null){
            winner = ' ';
        }
        return winner.toString();
    }

    @PostMapping("move")
    public List<Character> placeMove(@RequestBody TicTacToeMove moveRequest)
    {
        gameBoard.placeMove(moveRequest.getPosition(), moveRequest.sign);
        return gameBoard.getState();
    }
}
package WevServer;

import TicTacToe.GameBoard;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/tictactoe")
public class TicTacToeServer {
    private GameBoard gameBoard = new GameBoard();
    @GetMapping
    public String getGamePage() throws IOException {
        return Files.readString(Path.of("src/main/resources/tic.html"));
    }

    @PostMapping("move")
    public void placeMove(@RequestBody TicTacToeMove moveRequest)
    {
        gameBoard.placeMove(moveRequest.getPosition(), moveRequest.sign);
    }
}
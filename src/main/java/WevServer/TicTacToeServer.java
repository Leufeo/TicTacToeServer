package WevServer;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/tictactoe")
public class TicTacToeServer {
    @GetMapping
    public String getGamePage() throws IOException {
        return Files.readString(Path.of("src/main/resources/tic.html"));
    }

    @PostMapping("move")
    public void placeMove(@RequestBody TicTacToeMove moveRequest)
    {

    }
}
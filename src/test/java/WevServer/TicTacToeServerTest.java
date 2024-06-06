package WevServer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeServerTest {

    @Test
    public void testPlacingMoveShouldPlaceAndReturnCurrentBoardState(){
        TicTacToeServer server = new TicTacToeServer();
        TicTacToeMove move = new TicTacToeMove();
        move.position = "11";
        move.sign = 'X';

        List<Character> actualBoardState =  server.placeMove(move);
        if(actualBoardState == null || actualBoardState.size() != 9){
            fail("Wrong size of board state");
        }
        List<Character> expectedBoardState = new ArrayList<>();

        for (int i =0; i<9; i++){
            expectedBoardState.add(null);
        }
        expectedBoardState.set(0, 'X');

        if(actualBoardState.equals(expectedBoardState)){
            fail("Ivanov je kriv");
        }

    }
}
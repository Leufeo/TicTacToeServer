package WevServer;

public class TicTacToeMove {
    String position;
    Character sign;

    public Integer getPosition() {
        return Integer.parseInt(position);
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSign(Character sign)
    {
        this.sign = sign;
    }
}

import board.Board;
import game.Game;
import player.Player;
import game.Game;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("Tic tac toe project:");

        // Player p=new Player();
        // p.setPlayerDetails("Ram", "ram2005@gmail.com", 18,"8328314580", 'x');
        // p.getPlayerNameandSymbol();
        Board b = new Board(3, '-');
        b.printBoard();
        Player p1 = new Player();
        p1.setPlayerNameAndSymbol("ram", 'X');
        p1.getPlayerNameandSymbol();
        Player p2 = new Player();
        p2.setPlayerNameAndSymbol("sita", 'O');
        p2.getPlayerNameandSymbol();
        Game g = new Game(new Player[] { p1, p2 }, b);
        g.play();

    }
}

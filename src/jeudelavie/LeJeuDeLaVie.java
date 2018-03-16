package jeudelavie;

/**
 * Programme principal
 *
 * @author MicCode
 * @version
 */
public class LeJeuDeLaVie{
    public static void main(String[] args) {
        Board board = new Board();
        MainWindow w = new MainWindow();
        w.redrawBoard(board);
        while(true){
            try {Thread.sleep(Settings.CLOCK_TIME);}
            catch (InterruptedException e) {e.printStackTrace();}

            board.update();
            w.redrawBoard(board);
        }
    }
}

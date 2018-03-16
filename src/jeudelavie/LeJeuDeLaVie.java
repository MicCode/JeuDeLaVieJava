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
        while(true){
            board.update();
            w.redrawBoard(board);

            try {Thread.sleep(Settings.CLOCK_TIME);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}

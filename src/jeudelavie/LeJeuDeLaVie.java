package jeudelavie;

public class LeJeuDeLaVie{

    public static void main(String[] args) {
        MainWindow w = new MainWindow();
        Board board = new Board();
        while(true){
            board.update();
            w.redrawBoard(board);

            try {Thread.sleep(150);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}

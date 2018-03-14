package jeudelavie;

import javax.swing.*;

public class MainWindow extends JFrame {
    private int width = 1200;
    private int height = 1025;
    private GraphicRender render = new GraphicRender();

    public MainWindow(){
        this.setTitle("Le jeu de la vie");
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(render);
        this.setVisible(true);
    }

    public void redrawBoard(Board board){
        this.render.setBoard(board);
        this.render.repaint();
    }
}

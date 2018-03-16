package jeudelavie;

import javax.swing.*;

/**
 * Classe de la fenêtre principale, sert à initialiser le plateau et à gérer le refresh
 *
 * @author MicCode
 * @version 1.0
 */
public class MainWindow extends JFrame {
    private GraphicRender render = new GraphicRender();

    /**
     * Constructeur
     */
    public MainWindow(){
        this.setTitle("Le jeu de la vie");
        this.setSize(Settings.CELLS_X* Settings.GRID_SIZE, Settings.CELLS_Y* Settings.GRID_SIZE+25);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(render);
        this.setVisible(true);
    }

    /**
     * Met à jour le plateau
     * @param board Le plateau
     */
    public void redrawBoard(Board board){
        this.render.setBoard(board);
        this.render.repaint();
    }
}

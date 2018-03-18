package jeudelavie;

import javax.swing.*;
import java.awt.event.*;

/**
 * Classe de la fenêtre principale, sert à initialiser le plateau et à gérer le refresh
 *
 * @author MicCode
 * @version 1.0
 */
public class MainWindow extends JFrame implements MouseListener {
    private GraphicRender render = new GraphicRender();

    /**
     * Constructeur
     */
    public MainWindow(){
        this.setTitle("Le jeu de la vie");
        this.setSize(Settings.CELLS_X * Settings.GRID_SIZE + 25, Settings.CELLS_Y * Settings.GRID_SIZE + 50);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(render);
        this.setVisible(true);
        addMouseListener(this);
    }

    /**
     * Met à jour le plateau
     * @param board Le plateau
     */
    public void redrawBoard(Board board){
        this.render.setBoard(board);
        this.render.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.render.clicked(x,y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

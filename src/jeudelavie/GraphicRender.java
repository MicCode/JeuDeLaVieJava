package jeudelavie;

import javax.swing.*;
import java.awt.*;

/**
 * Classe de gestion des appels graphiques
 *
 * @author MicCode
 * @version 1.0
 */
public class GraphicRender extends JPanel {
    /**
     * Plateau de jeu
     */
    private Board board;

    public void paintComponent(Graphics g) {
        this.drawBoard(g);
    }

    public void setBoard(Board board){
        this.board = board;
    }

    /**
     * Dessine le plateau et les cellules
     * @param g
     */
    private void drawBoard(Graphics g){
        int minX = 0;
        int minY = 0;
        int maxX = Settings.GRID_SIZE * Settings.CELLS_X;
        int maxY = Settings.GRID_SIZE * Settings.CELLS_Y;

        if(Settings.DRAW_GRID) {
            g.setColor(Color.LIGHT_GRAY);
            for (int x = 0; x <= Settings.CELLS_X; x++) {
                g.drawLine(x*Settings.GRID_SIZE, minY, x*Settings.GRID_SIZE, maxY);
            }
            for (int y = 0; y <= Settings.CELLS_Y; y++) {
                g.drawLine(minX, y*Settings.GRID_SIZE, maxX, y*Settings.GRID_SIZE);
            }
            g.setColor(Color.BLACK);
            g.drawRect(minX, minY, Settings.CELLS_X * Settings.GRID_SIZE, Settings.CELLS_Y * Settings.GRID_SIZE);
        }

        for(int x = 0; x < Settings.CELLS_X; x++){
            for(int y = 0; y < Settings.CELLS_Y; y++){
                g.setColor(this.board.getCell(x,y).getColor());
                g.fillRect(
                        minX + x * Settings.GRID_SIZE + Settings.CELL_PADDING,
                        minY + y * Settings.GRID_SIZE + Settings.CELL_PADDING,
                        Settings.GRID_SIZE - Settings.CELL_PADDING * 2,
                        Settings.GRID_SIZE - Settings.CELL_PADDING * 2
                );
            }
        }
    }
}

package jeudelavie;

import javax.swing.*;
import java.awt.*;

public class GraphicRender extends JPanel {
    private Board board;
    private int gridSize = 20;
    private int paddingLeft = 0;
    private int paddingTop = 0;

    public void paintComponent(Graphics g) {
        this.drawBoard(g);
    }

    public void setBoard(Board board){
        this.board = board;
    }

    private void drawBoard(Graphics g){
        int minX = this.paddingLeft;
        int minY = this.paddingTop;
        int maxX = this.paddingLeft + this.gridSize * this.board.getCellsX();
        int maxY = this.paddingTop + this.gridSize * this.board.getCellsY();

        g.setColor(Color.LIGHT_GRAY);
        for(int x = 0; x <= this.board.getCellsX(); x++) {
            g.drawLine(x * this.gridSize + this.paddingLeft, minY, x * this.gridSize + this.paddingLeft, maxY);
        }
        for(int y = 0; y <= this.board.getCellsY(); y++) {
            g.drawLine(minX, y * this.gridSize + this.paddingTop,maxX,y * this.gridSize + this.paddingTop);
        }
        g.setColor(Color.BLACK);
        g.drawRect(minX,minY,this.board.getCellsX()*this.gridSize,this.board.getCellsY()*this.gridSize);

        for(int x = 0; x < this.board.getCellsX(); x++){
            for(int y = 0; y < this.board.getCellsY(); y++){
                Cell c = this.board.getCell(x,y);
                if(c.getValue() == 1) g.setColor(Color.BLACK);
                else  g.setColor(Color.WHITE);
                g.fillRect(minX + x * this.gridSize + 1, minY + y * this.gridSize + 1, this.gridSize - 2, this.gridSize - 2);
            }
        }
    }
}

package jeudelavie;

import javax.swing.*;
import java.awt.*;

public class GraphicRender extends JPanel {
    private Board board;
    private int gridSize = 5;
    private int paddingLeft = 0;
    private int paddingTop = 0;
    private int cellPadding =0;

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
                char c = this.board.getCell(x,y).getType();
                switch(c){
                    case 'A' : g.setColor(new Color(100,0,50));break;
                    case 'B' : g.setColor(new Color(100,50,50));break;
                    case 'C' : g.setColor(new Color(100,50,100));break;
                    case 'D' : g.setColor(new Color(100,100,100));break;
                    case 'E' : g.setColor(new Color(100,100,150));break;
                    case 'F' : g.setColor(new Color(100,150,150));break;
                    case 'G' : g.setColor(new Color(100,150,200));break;
                    case 'H' : g.setColor(new Color(100,200,200));break;
                    case 'I' : g.setColor(new Color(100,200,250));break;
                    case 'J' : g.setColor(new Color(100,250,250));break;
                    default : g.setColor(Color.WHITE);
                }
                g.fillRect(minX + x * this.gridSize + this.cellPadding, minY + y * this.gridSize + this.cellPadding, this.gridSize - this.cellPadding * 2, this.gridSize - this.cellPadding * 2);
            }
        }
    }
}

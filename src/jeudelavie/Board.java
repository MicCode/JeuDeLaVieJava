package jeudelavie;

import jeudelavie.cell.*;

/**
 * Classe du plateau de jeu
 *
 * @author MicCode
 * @version 1.0
 */
public class Board {
    /**
     * Ensemble des cellules
     */
    private Cell[][] cells;

    /**
     * Constructeur
     */
    public Board(){
        this.initBoard();
    }

    /**
     * Initiatisation du plateau avec des cellules aléatoires
     */
    private void initBoard(){
        this.cells = new Cell[Settings.CELLS_X][Settings.CELLS_Y];
        for(int x = 0; x < Settings.CELLS_X; x++){
            for(int y = 0; y < Settings.CELLS_Y; y++){
                this.cells[x][y] = new Cell();
            }
        }
    }

    /**
     * Mise à jour de toutes les cellules du plateau
     */
    public void update(){
        Cell[][] snapshotCells = new Cell[Settings.CELLS_X][Settings.CELLS_Y];
        for(int x = 0; x < Settings.CELLS_X; x++){
            for(int y = 0; y < Settings.CELLS_Y; y++) {
                snapshotCells[x][y] = (Cell)this.cells[x][y].clone();
            }
        }

        for(int x = 0; x < Settings.CELLS_X; x++){
            for(int y = 0; y < Settings.CELLS_Y; y++){
                Cell[] neighbors = new Cell[8];
                neighbors[0] = x > 0 && y > 0 ? this.cells[x-1][y-1] : new Cell(); //TOP LEFT
                neighbors[1] = y > 0 ? this.cells[x][y-1] : new Cell(); //TOP CENTER
                neighbors[2] = x < Settings.CELLS_X-1 && y > 0 ? this.cells[x+1][y-1] : new Cell(); //TOP RIGHT
                neighbors[3] = x < Settings.CELLS_X-1 ? this.cells[x+1][y] : new Cell(); //MIDDLE RIGHT
                neighbors[4] = x < Settings.CELLS_X-1 && y < Settings.CELLS_Y-1 ? this.cells[x+1][y+1] : new Cell(); //BOTTOM RIGHT
                neighbors[5] = y < Settings.CELLS_Y-1 ? this.cells[x][y+1] : new Cell(); //BOTTOM CENTER
                neighbors[6] = x > 0 && y < Settings.CELLS_Y-1 ? this.cells[x-1][y+1] : new Cell(); // BOTTOM LEFT
                neighbors[7] = x > 0 ? this.cells[x-1][y] : new Cell(); //MIDDLE LEFT
                snapshotCells[x][y].setNeighbors(neighbors);
                snapshotCells[x][y] = snapshotCells[x][y].updateLife();
            }
        }
        for(int x = 0; x < Settings.CELLS_X; x++) {
            for (int y = 0; y < Settings.CELLS_Y; y++) {
                this.cells[x][y] = (Cell) snapshotCells[x][y].clone();
            }
        }
    }

    public void setCells(Cell[][] cells){
        this.cells = cells;
    }
    public Cell[][] getCells(){
        return cells;
    }

    /**
     * Renvoit une seule cellule positionnée en x,y
     * @param x
     * @param y
     * @return La cellule pointée
     */
    public Cell getCell(int x, int y){
        return this.cells[x][y];
    }

    public void setCell(int x, int y, Cell newCell){
        System.out.println("x = " + x/Settings.GRID_SIZE + "  y = " + (y-25)/Settings.GRID_SIZE);
        this.cells[x/Settings.GRID_SIZE][(y-25)/Settings.GRID_SIZE] = newCell;
    }
}

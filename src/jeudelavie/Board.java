package jeudelavie;

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
                double n = Math.random();
                if(n < 0.1) this.cells[x][y] = new Cell('A');
                else if(n < 0.2) this.cells[x][y] = new Cell('B');
                else if(n < 0.3) this.cells[x][y] = new Cell('C');
                else if(n < 0.4) this.cells[x][y] = new Cell('D');
                else this.cells[x][y] = new Cell('0');
            }
        }
    }

    /**
     * Mise à jour de toutes les cellules du plateau
     */
    public void update(){
        Cell[][] snapshotCells = new Cell[Settings.CELLS_X][Settings.CELLS_Y];

        for(int x = 0; x < Settings.CELLS_X; x++) {
            for (int y = 0; y < Settings.CELLS_Y; y++) {
                snapshotCells[x][y] = new Cell(this.cells[x][y].getType());
            }
        }
        for(int x = 0; x < Settings.CELLS_X; x++){
            for(int y = 0; y < Settings.CELLS_Y; y++){
                Cell[] neighbors = new Cell[8];
                neighbors[0] = x > 0 && y > 0 ? this.cells[x-1][y-1] : new Cell('0'); //TOP LEFT
                neighbors[1] = y > 0 ? this.cells[x][y-1] : new Cell('0'); //TOP CENTER
                neighbors[2] = x < Settings.CELLS_X-1 && y > 0 ? this.cells[x+1][y-1] : new Cell('0'); //TOP RIGHT
                neighbors[3] = x < Settings.CELLS_X-1 ? this.cells[x+1][y] : new Cell('0'); //MIDDLE RIGHT
                neighbors[4] = x < Settings.CELLS_X-1 && y < Settings.CELLS_Y-1 ? this.cells[x+1][y+1] : new Cell('0'); //BOTTOM RIGHT
                neighbors[5] = y < Settings.CELLS_Y-1 ? this.cells[x][y+1] : new Cell('0'); //BOTTOM CENTER
                neighbors[6] = x > 0 && y < Settings.CELLS_Y-1 ? this.cells[x-1][y+1] : new Cell('0'); // BOTTOM LEFT
                neighbors[7] = x > 0 ? this.cells[x-1][y] : new Cell('0'); //MIDDLE LEFT
                snapshotCells[x][y].setNeighbors(neighbors);
                snapshotCells[x][y].updateLife();
            }
        }
        for(int x = 0; x < Settings.CELLS_X; x++) {
            for (int y = 0; y < Settings.CELLS_Y; y++) {
                this.cells[x][y] = new Cell(snapshotCells[x][y].getType());
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
}

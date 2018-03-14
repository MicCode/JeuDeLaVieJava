package jeudelavie;

public class Board {
    private int cellsX = 60;
    private int cellsY = 50;
    private Cell[][] cells;

    public Board(){
        this.initBoard();
    }
    public Board(int cellsX, int cellsY){
        this.cellsX = cellsX;
        this.cellsY = cellsY;
        this.initBoard();
    }

    private void initBoard(){
        this.cells = new Cell[cellsX][cellsY];
        for(int x = 0; x < this.cellsX; x++){
            for(int y = 0; y < this.cellsY; y++){
                double n = Math.random();
                if(n > 0.1) this.cells[x][y] = new Cell(0);
                else this.cells[x][y] = new Cell(1);
            }
        }
    }

    public void update(){
        Cell[][] snapshotCells = this.cells;
        for(int x = 0; x < cellsX; x++){
            for(int y = 0; y < cellsY; y++){
                Cell[] neighbors = new Cell[8];
                neighbors[0] = x > 0 && y > 0 ? this.cells[x-1][y-1] : new Cell(-1); //TOP LEFT
                neighbors[1] = y > 0 ? this.cells[x][y-1] : new Cell(-1); //TOP CENTER
                neighbors[2] = x < this.cellsX-1 && y > 0 ? this.cells[x+1][y-1] : new Cell(-1); //TOP RIGHT
                neighbors[3] = x < this.cellsX-1 ? this.cells[x+1][y] : new Cell(-1); //MIDDLE RIGHT
                neighbors[4] = x < this.cellsX-1 && y < this.cellsY-1 ? this.cells[x+1][y+1] : new Cell(-1); //BOTTOM RIGHT
                neighbors[5] = y < this.cellsY-1 ? this.cells[x][y+1] : new Cell(-1); //BOTTOM CENTER
                neighbors[6] = x > 0 && y < this.cellsY-1 ? this.cells[x-1][y+1] : new Cell(-1); // BOTTOM LEFT
                neighbors[7] = x > 0 ? this.cells[x-1][y] : new Cell(-1); //MIDDLE LEFT
                snapshotCells[x][y].setNeighbors(neighbors);
                snapshotCells[x][y].updateLife();
            }
        }
        this.cells = snapshotCells;
    }

    public void setCells(Cell[][] cells){
        this.cells = cells;
    }
    public Cell[][] getCells(){
        return cells;
    }
    public int getCellsX() {
        return cellsX;
    }
    public void setCellsX(int cellsX) {
        this.cellsX = cellsX;
    }
    public int getCellsY() {
        return cellsY;
    }
    public void setCellsY(int cellsY) {
        this.cellsY = cellsY;
    }
    public Cell getCell(int x, int y){
        return this.cells[x][y];
    }
}

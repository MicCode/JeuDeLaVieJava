package jeudelavie;

public class Board {
    private int cellsX = 240;
    private int cellsY = 200;
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
                if(n < 0.1) this.cells[x][y] = new Cell('A');
                else if(n < 0.2) this.cells[x][y] = new Cell('B');
                else if(n < 0.3) this.cells[x][y] = new Cell('C');
                else if(n < 0.4) this.cells[x][y] = new Cell('D');
                else if(n < 0.5) this.cells[x][y] = new Cell('E');
                else if(n < 0.6) this.cells[x][y] = new Cell('F');
                else if(n < 0.7) this.cells[x][y] = new Cell('G');
                else if(n < 0.8) this.cells[x][y] = new Cell('H');
                else if(n < 0.9) this.cells[x][y] = new Cell('I');
                else if(n < 1) this.cells[x][y] = new Cell('J');
                else this.cells[x][y] = new Cell('0');
            }
        }
    }

    public void update(){
        Cell[][] snapshotCells = this.cells;
        for(int x = 0; x < cellsX; x++){
            for(int y = 0; y < cellsY; y++){
                Cell[] neighbors = new Cell[8];
                neighbors[0] = x > 0 && y > 0 ? this.cells[x-1][y-1] : new Cell('0'); //TOP LEFT
                neighbors[1] = y > 0 ? this.cells[x][y-1] : new Cell('0'); //TOP CENTER
                neighbors[2] = x < this.cellsX-1 && y > 0 ? this.cells[x+1][y-1] : new Cell('0'); //TOP RIGHT
                neighbors[3] = x < this.cellsX-1 ? this.cells[x+1][y] : new Cell('0'); //MIDDLE RIGHT
                neighbors[4] = x < this.cellsX-1 && y < this.cellsY-1 ? this.cells[x+1][y+1] : new Cell('0'); //BOTTOM RIGHT
                neighbors[5] = y < this.cellsY-1 ? this.cells[x][y+1] : new Cell('0'); //BOTTOM CENTER
                neighbors[6] = x > 0 && y < this.cellsY-1 ? this.cells[x-1][y+1] : new Cell('0'); // BOTTOM LEFT
                neighbors[7] = x > 0 ? this.cells[x-1][y] : new Cell('0'); //MIDDLE LEFT
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

package jeudelavie;

public class Cell {
    private boolean active = true;
    private int value = 0;
    private Cell[] neighbors = new Cell[8];

    public Cell(){

    }
    public Cell(int value){
        if(value == -1) this.active = false;
        else this.active = true;
        this.value = value;
    }

    public void setNeighbors(Cell[] neighbors) {
        this.neighbors = neighbors;
    }

    public void updateLife(){
        int neighborsWeight = 0;
        for(int i = 0; i < 8; i++){
            neighborsWeight += this.neighbors[i].value > 0 ? this.neighbors[i].value : 0;
        }
        if(neighborsWeight == 3) this.value = 1;
        else if(neighborsWeight == 2 && this.value == 1) this.value = 1;
        else this.value = 0;
    }
    public int getValue(){
        return this.value;
    }
}

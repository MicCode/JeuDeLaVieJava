package jeudelavie;

public class Cell {
    private boolean active = true;
    private char type = 'A';
    private Cell[] neighbors = new Cell[8];

    public Cell(){

    }
    public Cell(char type){
        if(type == -1) this.active = false;
        else this.active = true;
        this.type = type;
    }

    public void setNeighbors(Cell[] neighbors) {
        this.neighbors = neighbors;
    }

    public void updateLife(){
        char majority = this.type;
        int[] counts = {0,0,0,0,0,0,0,0,0,0};
        int max = -1;

        for(int i = 0; i < 8; i++){
            switch(this.neighbors[i].type){
                case 'A' :
                    counts[0]++;
                    if(counts[0] > max) {
                        majority = 'A';
                        max = counts[0];
                    }
                    break;
                case 'B' :
                    counts[1]++;
                    if(counts[1] > max) {
                        majority = 'B';
                        max = counts[1];
                    }
                    break;
                case 'C' :
                    counts[2]++;
                    if(counts[2] > max) {
                        majority = 'C';
                        max = counts[2];
                    }
                    break;
                case 'D' :
                    counts[3]++;
                    if(counts[3] > max) {
                        majority = 'D';
                        max = counts[3];
                    }
                    break;
                case 'E' :
                    counts[4]++;
                    if(counts[4] > max) {
                        majority = 'E';
                        max = counts[4];
                    }
                    break;
                case 'F' :
                    counts[5]++;
                    if(counts[5] > max) {
                        majority = 'F';
                        max = counts[5];
                    }
                    break;
                case 'G' :
                    counts[6]++;
                    if(counts[6] > max) {
                        majority = 'G';
                        max = counts[6];
                    }
                    break;
                case 'H' :
                    counts[7]++;
                    if(counts[7] > max) {
                        majority = 'H';
                        max = counts[7];
                    }
                    break;
                case 'I' :
                    counts[8]++;
                    if(counts[8] > max) {
                        majority = 'I';
                        max = counts[8];
                    }
                    break;
                case 'J' :
                    counts[9]++;
                    if(counts[9] > max) {
                        majority = 'J';
                        max = counts[9];
                    }
                    break;
            }
        }
        if(max > 2) this.type = majority;
        else this.type = '0';
    }
    public char getType(){
        return this.type;
    }
}

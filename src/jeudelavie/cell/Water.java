package jeudelavie.cell;

import java.awt.*;

public class Water extends Cell {
    public Water(){
        this.type = 'w';
        this.color = Color.BLUE;
    }

    public Cell updateLife(){
        int treeSum = 0;
        int fireSum = 0;
        int waterSum = 0;
        for(int i = 0; i < 8; i++){
            if(this.neighbors[i] instanceof Tree) treeSum++;
            else if(this.neighbors[i] instanceof Fire) fireSum++;
            else if(this.neighbors[i] instanceof Water) waterSum++;
        }
        if(waterSum > 5) return new Tree();
        else if(fireSum > 4) return new Cell();
        else if(treeSum > 4) return new Tree();
        else return this;
    }
}

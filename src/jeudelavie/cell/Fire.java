package jeudelavie.cell;

import java.awt.*;

public class Fire extends Cell {
    public Fire(){
        this.type = 'f';
        this.color = Color.RED;
    }

    public Cell updateLife(){
        int waterSum = 0;
        int treeSum = 0;
        for(int i = 0; i < 8; i++){
            if(this.neighbors[i] instanceof Water) waterSum++;
            else if(this.neighbors[i] instanceof Tree) treeSum++;
        }
        if(waterSum > 2) return new Water();
        else if(treeSum == 0) return new Cell();
        else return this;
    }
}

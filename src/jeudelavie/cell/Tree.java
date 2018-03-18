package jeudelavie.cell;

import java.awt.*;

public class Tree extends Cell {
    public Tree(){
        this.type = 't';
        this.color = Color.GREEN;
    }

    public Cell updateLife(){
        int waterSum = 0;
        int fireSum = 0;
        for(int i = 0; i < 8; i++){
            if(this.neighbors[i] instanceof Water) waterSum++;
            else if(this.neighbors[i] instanceof Fire) fireSum++;
        }
        if(waterSum > fireSum + 1) return this;
        else if(fireSum >= 1) return new Fire();
        else return this;
    }
}

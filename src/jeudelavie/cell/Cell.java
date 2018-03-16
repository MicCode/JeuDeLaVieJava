package jeudelavie.cell;

import java.awt.*;

/**
 * Classe générique d'une cellule
 *
 * @author MicCode
 * @version 1.0
 */
public class Cell implements Cloneable{
    /**
     * Dit si la cellule est vivante ou morte
     */
    private boolean active = true;
    /**
     * TYpe de la cellule
     */
    protected char type = '0';
    /**
     * Couleur de la cellule
     */
    protected Color color = Color.BLACK;
    /**
     * Cellules voisines (sérialisée en sens horaire : haut/gauche, haut/centre, haut/droite, milieu/droite ...)
     */
    protected Cell[] neighbors = new Cell[8];

    /**
     * Constructeur avec un type prédéfini
     */
    public Cell(){

    }

    /**
     * Met à jour la liste des cellules voisines
     * @param neighbors
     */
    public void setNeighbors(Cell[] neighbors) {
        this.neighbors = neighbors;
    }

    /**
     * Détermine le statut de la cellule à l'étape n+1 en fonction de ses voisines
     */
    public Cell updateLife(){
        int waterSum = 0;
        int treeSum = 0;
        for(int i = 0; i < 8; i++){
            if(this.neighbors[i] instanceof Water) waterSum++;
            if(this.neighbors[i] instanceof Tree) treeSum++;
        }
        double r = Math.random();
        if(r < 0.001) return new Tree();
        else if(r < 0.002) return new Water();
        else if(treeSum > 2) return new Tree();
        else if(waterSum > 4) return new Tree();
        else if(waterSum > 2) return new Water();
        else return this;
    }

    public Color getColor(){
        return this.color;
    }

    public Object clone(){
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        return o;
    }
}

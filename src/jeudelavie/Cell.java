package jeudelavie;

/**
 * Classe générique d'une cellule
 *
 * @author MicCode
 * @version 1.0
 */
public class Cell {
    /**
     * Dit si la cellule est vivante ou morte
     */
    private boolean active = true;
    /**
     * TYpe de la cellule
     */
    private char type = 'A';
    /**
     * Cellules voisines (sérialisée en sens horaire : haut/gauche, haut/centre, haut/droite, milieu/droite ...)
     */
    private Cell[] neighbors = new Cell[8];

    /**
     * Constructeur
     */
    public Cell(){

    }

    /**
     * Constructeur avec un type prédéfini
     * @param type
     */
    public Cell(char type){
        if(type == -1) this.active = false;
        else this.active = true;
        this.type = type;
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
    public void updateLife(){
        char majority = this.type;
        int[] counts = {0,0,0,0};
        int max = -1;

        for(int i = 0; i < 8; i++){
            switch(this.neighbors[i].type){
                case 'A' :
                    counts[0]++;
                    if(counts[0] > max) {
                        majority = 'A';
                        max = counts[0];
                    }
                    else if(counts[0] == max) majority = this.getRandomType();
                    break;
                case 'B' :
                    counts[1]++;
                    if(counts[1] > max) {
                        majority = 'B';
                        max = counts[1];
                    }
                    else if(counts[1] == max) majority = this.getRandomType();
                    break;
                case 'C' :
                    counts[2]++;
                    if(counts[2] > max) {
                        majority = 'C';
                        max = counts[2];
                    }
                    else if(counts[2] == max) majority = this.getRandomType();
                    break;
                case 'D' :
                    counts[3]++;
                    if(counts[3] > max) {
                        majority = 'D';
                        max = counts[3];
                    }
                    else if(counts[3] == max) majority = this.getRandomType();
                    break;
            }
        }
        if(max > 2) this.type = majority;
        else this.type = '0';
    }

    /**
     * Renvoit le type de la cellule
     * @return
     */
    public char getType(){
        return this.type;
    }

    /**
     * Renvoit un type aléatoire
     * @return
     */
    private char getRandomType(){
        double n = Math.random();
        if(n < 0.3) return 'A';
        else if(n < 0.6) return 'B';
        else if(n < 0.8) return 'C';
        else if(n <= 1) return 'D';
        else return '0';
    }
}

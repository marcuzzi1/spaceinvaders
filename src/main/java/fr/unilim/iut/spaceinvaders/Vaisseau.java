package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

    private int x;
    private int y;
    private int longueur;
    private int hauteur;

    public Vaisseau(int x, int y) {
        this.x = x;
        this.y = y;
        this.longueur = 1;
        this.hauteur = 1;
    }

    public Vaisseau(int longueur, int hauteur, int x, int y) {
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.hauteur = hauteur;
    }

    public boolean occupeLaPosition(int x, int y) {
        if ((this.x <= x) && (x <= this.x + this.longueur - 1))
            if ((this.y - this.hauteur + 1 <= y) && (y <= this.y))
                return true;

        return false;
    }

    public void seDeplacerVersLaDroite() {
        this.x += 1;
    }

    public int abscisse() {
        return this.x;
    }

    public void seDeplacerVersLaGauche() {
        this.x -= 1;
    }

}

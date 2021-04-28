package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

    private static final char MARQUE_FIN_LIGNE = '\n';
    private static final char MARQUE_VIDE = '.';
    private static final char MARQUE_VAISSEAU = 'V';
    private int longueur;
    private int hauteur;
    private Vaisseau vaisseau;

    public SpaceInvaders(int longueur, int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
    }

    @Override
    public String toString() {
        return recupererEspaceJeuDansChaineASCII();
    }

    public String recupererEspaceJeuDansChaineASCII() {
        StringBuilder espaceDeJeu = new StringBuilder();
        for (int x = 0; x < hauteur; x++) {
            for (int y = 0; y < longueur; y++) {
                espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
            }
            espaceDeJeu.append(MARQUE_FIN_LIGNE);
        }
        return espaceDeJeu.toString();
    }

    private char recupererMarqueDeLaPosition(int x, int y) {
        char marque;
        if (this.aUnVaisseauQuiOccupeLaPosition(x, y)) {
            marque = MARQUE_VAISSEAU;
        } else {
            marque = MARQUE_VIDE;
        }
        return marque;
    }

    private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
        return this.aUnVaisseau() && this.vaisseau.occupeLaPosition(x, y);
    }

    public void positionnerUnNouveauVaisseau(int x, int y) {
        if (!estDansEspaceJeu(x, y))
            throw new HorsEspaceJeuException("Vous êtes en dehors de l'espace jeu");
        this.vaisseau = new Vaisseau(x, y);
    }

    private boolean estDansEspaceJeu(int x, int y) {
        return x >= 0 && x < this.longueur && y >= 0 && y < this.hauteur;
    }

    private boolean aUnVaisseau() {
        return this.vaisseau != null;
    }

    public void deplacerVaisseauVersLaDroite() {
        this.vaisseau.seDeplacerVersLaDroite();
    }

}

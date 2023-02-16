package fr.victork.chessGame.entity;

public class Knight extends ChessPiece {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    //--------------------- CONSTRUCTORS ---------------------------------------
    public Knight(int x, int y, int color) {
        super(x, y, color);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    @Override
    public boolean canGo(int x, int y) {
        int xDistance = Math.abs(this.getX() - x);
        int yDistance = Math.abs(this.getY() - y);
        int hypotenuse = (xDistance * xDistance) + (yDistance * yDistance);

        return (hypotenuse == 5 &&
                (this.getX() != x &&
                        this.getY() != y) &&
                isInTheChessboard(x, y));

    }

    public boolean canTake(ChessPiece piece) {
        return canGo(piece.getX(), piece.getY());
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}

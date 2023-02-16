package fr.victork.chessGame.entity;

public class Pawn extends ChessPiece {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------

    @Override
    public boolean canGo(int x, int y) {
        return (
                isInTheChessboard(x, y) &&
                        this.getX() == x &&
                        y > this.getY() &&
                        y - this.getY() <= 2
        );
    }

    @Override
    public boolean canTake(ChessPiece piece) {
        return (
                piece.getY() - this.getY() == 1 &&
                        Math.abs(this.getX() - piece.getX()) == 1

        );
    }

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Pawn(int x, int y, int color) {
        super(x, y, color);
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}

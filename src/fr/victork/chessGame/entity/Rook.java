package fr.victork.chessGame.entity;

public class Rook extends ChessPiece {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    //--------------------- CONSTRUCTORS ---------------------------------------
    public Rook(int x, int y, int color) {
        super(x, y, color);
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------

    @Override
    public boolean canGo(int x, int y) {
        return (
                isInTheChessboard(x, y) &&
                        movingOnline(x, y, this)
        );
    }

    @Override
    public boolean canTake(ChessPiece piece) {
        return canGo(piece.getX(), piece.getY());
    }

    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}

package fr.victork.chessGame.entity;

public class Bishop extends ChessPiece {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    @Override
    public boolean canGo(int x, int y) {
        return (
                diagonalMovement(x, y, this) &&
                        isInTheChessboard(x, y)
        );
    }

    public boolean canTake(ChessPiece piece) {
        return canGo(piece.getX(), piece.getY());
    }

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Bishop(int x, int y, int color) {
        super(x, y, color);
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}

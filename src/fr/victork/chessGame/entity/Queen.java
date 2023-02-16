package fr.victork.chessGame.entity;

public class Queen extends ChessPiece {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    //--------------------- CONSTRUCTORS ---------------------------------------
    public Queen(int x, int y, int color) {
        super(x, y, color);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    @Override
    public boolean canGo(int x, int y) {
        return (
                isInTheChessboard(x, y) &&
                        movingOnline(x, y, this) ||
                        diagonalMovement(x, y, this)
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

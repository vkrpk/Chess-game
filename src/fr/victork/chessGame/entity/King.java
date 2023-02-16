package fr.victork.chessGame.entity;

public class King extends ChessPiece {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    //--------------------- CONSTRUCTORS ---------------------------------------
    public King(int x, int y, int color) {
        super(x, y, color);
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------

    @Override
    public boolean canGo(int x, int y) {
        int displacementLengthX = Math.abs(this.getX() - x);
        int displacementLengthY = Math.abs(this.getY() - y);
        return (isInTheChessboard(x, y) &&
                displacementLengthX <= 1 &&
                displacementLengthY <= 1 &&
                (this.getX() != x ||
                        this.getY() != y)
        );
    }

    public boolean canTake(ChessPiece piece) {
        return canGo(piece.getX(), piece.getY());
    }

    ;

    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}

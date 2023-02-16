package fr.victork.chessGame.entity;

import fr.victork.chessGame.tools.MethodsCommonToPieces;

abstract public class ChessPiece implements MethodsCommonToPieces {
    //--------------------- CONSTANTS ------------------------------------------
    public static final int WHITE_COLOR = 1;
    public static final int BLACK_COLOR = 2;
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int x;
    private int y;
    private int color;
    //--------------------- CONSTRUCTORS ---------------------------------------

    public ChessPiece(int x, int y, int color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    public int colorBoxChess() {
        if ((this.getX() + this.getY()) % 2 == 0) {
            return BLACK_COLOR;
        } else {
            return WHITE_COLOR;
        }
    }

    public int incorrectPosition(int number) {
        if (number < 0) {
            return 0;
        } else {
            return 7;
        }
    }

    public int incorrectColor(int number) {
        if (number < WHITE_COLOR) {
            return WHITE_COLOR;
        } else {
            return BLACK_COLOR;
        }
    }


    //--------------------- ABSTRACT METHODS -----------------------------------
    public abstract boolean canGo(int x, int y);

    public abstract boolean canTake(ChessPiece piece);
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x >= 0 && x <= 7) {
            this.x = x;
        } else {
            this.x = incorrectPosition(x);
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y >= 0 && y <= 7) {
            this.y = y;
        } else {
            this.y = incorrectPosition(y);
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        if (color == WHITE_COLOR || color == BLACK_COLOR) {
            this.color = color;
        } else {
            this.color = incorrectColor(color);
        }
    }
    //--------------------- TO STRING METHOD------------------------------------
}

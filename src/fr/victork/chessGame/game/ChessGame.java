package fr.victork.chessGame.game;

import fr.victork.chessGame.entity.*;

public class ChessGame {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private ChessPiece[][] board = new ChessPiece[8][8];

    //--------------------- CONSTRUCTORS ---------------------------------------
    public ChessGame() {
        for (int i = 0; i < 8; i++) {
            this.board[i][1] = new Pawn(i, 1, ChessPiece.WHITE_COLOR);
            this.board[i][6] = new Pawn(i, 6, ChessPiece.BLACK_COLOR);
        }
        this.board[0][0] = new Rook(0, 0, ChessPiece.WHITE_COLOR);
        this.board[7][0] = new Rook(7, 0, ChessPiece.WHITE_COLOR);
        this.board[0][7] = new Rook(0, 7, ChessPiece.BLACK_COLOR);
        this.board[7][7] = new Rook(7, 7, ChessPiece.BLACK_COLOR);

        this.board[1][0] = new Knight(1, 0, ChessPiece.WHITE_COLOR);
        this.board[6][0] = new Knight(6, 0, ChessPiece.WHITE_COLOR);
        this.board[1][7] = new Knight(1, 7, ChessPiece.BLACK_COLOR);
        this.board[6][7] = new Knight(6, 7, ChessPiece.BLACK_COLOR);

        this.board[2][0] = new Bishop(2, 0, ChessPiece.WHITE_COLOR);
        this.board[5][0] = new Bishop(5, 0, ChessPiece.WHITE_COLOR);
        this.board[2][7] = new Bishop(2, 7, ChessPiece.BLACK_COLOR);
        this.board[5][7] = new Bishop(5, 7, ChessPiece.BLACK_COLOR);

        this.board[3][0] = new Queen(3, 0, ChessPiece.WHITE_COLOR);
        this.board[3][7] = new Queen(3, 7, ChessPiece.BLACK_COLOR);

        this.board[4][0] = new King(4, 0, ChessPiece.WHITE_COLOR);
        this.board[4][7] = new King(4, 7, ChessPiece.BLACK_COLOR);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    public ChessPiece getPieceAt(int x, int y) {
        // Returns the piece to the specified position on the chessboard
        return board[x][y];
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        // Moves the piece from the starting position to the ending position on the chessboard
        ChessPiece piece = board[fromRow][fromCol];
        board[fromRow][fromCol] = null;
        board[toRow][toCol] = piece;
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------

    public ChessPiece[][] getBoard() {
        return board;
    }


    //--------------------- TO STRING METHOD------------------------------------
}

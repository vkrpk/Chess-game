package fr.victork.chessGame.main;

import fr.victork.chessGame.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Knight blackKnight = new Knight(3, 2, ChessPiece.BLACK_COLOR);
        Knight whiteKnight = new Knight(6, 3, ChessPiece.BLACK_COLOR);
        Bishop bishopWhite = new Bishop(1, 1, ChessPiece.WHITE_COLOR);
        Bishop bishopBlack = new Bishop(4, 4, ChessPiece.BLACK_COLOR);
        King king = new King(5, 5, ChessPiece.BLACK_COLOR);
        Pawn pawn = new Pawn(5, 3, ChessPiece.BLACK_COLOR);

        List<ChessPiece> chessPieceArray = new ArrayList<>();
        chessPieceArray.add(blackKnight); // false
        chessPieceArray.add(whiteKnight); // true
        chessPieceArray.add(bishopWhite); // true
        chessPieceArray.add(bishopBlack); // false
        for (ChessPiece piece: chessPieceArray
             ) {
            System.out.println(piece.canGo(5, 5));
        }
        System.out.println(king.canGo(7, 5));
        System.out.println(pawn.canGo(2, 3));
        System.out.println(pawn.canTake(bishopBlack));
    }
}
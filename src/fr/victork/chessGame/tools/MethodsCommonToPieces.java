package fr.victork.chessGame.tools;

import fr.victork.chessGame.entity.ChessPiece;

public interface MethodsCommonToPieces {
    default public boolean checkIfPieceMovesAndIsInTheBoard(int futureX, int futureY, ChessPiece piece) {
        return piece.getX() != futureX &&
                piece.getY() != futureY &&
                isInTheChessboard(futureX, futureY);
    }

    default public boolean isInTheChessboard(int x, int y) {
        return (x >= 0 && x <= 7) && (y >= 0 && y <= 7);
    }

    default public boolean movingOnline(int x, int y, ChessPiece piece) {
        return (
                (x != piece.getX()) ^ (y != piece.getY())
        );
    }

    default public boolean diagonalMovement(int x, int y, ChessPiece piece) {
        return (
                ((piece.getX() + x) == (piece.getY() + y)) &&
                        ((piece.getX() != x) &&
                                (piece.getY() != y))
        );
    }
}

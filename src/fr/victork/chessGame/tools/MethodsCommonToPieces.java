package fr.victork.chessGame.tools;

import fr.victork.chessGame.entity.ChessPiece;

public interface MethodsCommonToPieces {
    default public boolean checkIfPieceMovesAndIsInTheBoard(int futureX, int futureY, ChessPiece piece) {
        return piece.getX() != futureX &&
                piece.getY() != futureY &&
                isInTheChessboard(futureX, futureY);
    }

    default public boolean isInTheChessboard(int x, int y) {
        return (x >= 1 && x <= 8) && (y >= 1 && y <= 8);
    }
}

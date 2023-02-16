package fr.victork.chessGame.GUI;

import fr.victork.chessGame.entity.ChessPiece;
import fr.victork.chessGame.game.ChessGame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ChessGUI extends JFrame {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private JPanel boardPanel;
    private JLabel[][] boardLabels;
    private ChessGame chessGame;

    // private
    //--------------------- CONSTRUCTORS ---------------------------------------
    public ChessGUI(ChessGame chessGame) {
        this.setChessGame(chessGame);
        setTitle("Chess game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        //setSize(400, 500);
        setLayout(new BorderLayout());
        setVisible(true);

        // Creation of the chess board
        boardPanel = new JPanel();
        boardLabels = new JLabel[8][8];
        boardPanel.setLayout(new GridLayout(8, 8));
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JLabel label = new JLabel();
                boardLabels[col][row] = label;
                boardPanel.add(label);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
        pack();

        updateGUI();
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    private void updateGUI() {
        // Updates the board display
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessPiece piece = getChessGame().getPieceAt(x, y);
                ImageIcon icon = getIconForPiece(piece);
                System.out.println("icon:" + icon);
                boardLabels[x][y].setIcon(icon);
            }
        }
    }

    private ImageIcon getIconForPiece(ChessPiece piece) {
        if (piece == null) {
            return null;
        }
        int color = piece.getColor();
        //System.out.println("color:" + color);
        String colorPiece;
        if (color == 1) {
            colorPiece = "WHITE_COLOR";
        } else {
            colorPiece = "BLACK_COLOR";
        }
        String type = piece.getClass().getSimpleName();
        String filename = "images/" + colorPiece + "/" + type + ".png";
        //System.out.println("filename:" + filename);
        String imagePath = "C:\\Dev\\Java\\chess_game\\images\\" + colorPiece + "\\" + type + ".png";
        File imageFile = new File(imagePath);
        ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());

      /*  ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(filename)));
        System.out.println("icon:" + icon);*/
        return icon;
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(JPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    public JLabel[][] getBoardLabels() {
        return boardLabels;
    }

    public void setBoardLabels(JLabel[][] boardLabels) {
        this.boardLabels = boardLabels;
    }

    public ChessGame getChessGame() {
        return chessGame;
    }

    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

    //--------------------- TO STRING METHOD------------------------------------
}

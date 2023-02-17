package fr.victork.chessGame.GUI;

import fr.victork.chessGame.entity.ChessPiece;
import fr.victork.chessGame.game.ChessGame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

public class ChessGUI extends JFrame {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private JPanel boardPanel;
    private JLabel[][] boardLabels;
    private ChessGame chessGame;

    //--------------------- CONSTRUCTORS ---------------------------------------
    public ChessGUI(ChessGame chessGame) {
        this.setChessGame(chessGame);
        setTitle("Chess game");

        // Configure Default Close Operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the smallest dimension
        int minDimension = Math.min(screenSize.width, screenSize.height);

        // Assign the square dimension to the window
        // setPreferredSize(new Dimension(minDimension, minDimension));

        setSize(minDimension, minDimension);

        int boardSize = minDimension - 100; // Adjust the margin as needed
        int marginX = (minDimension - boardSize) / 2;
        int marginY = (minDimension - boardSize) / 2;


        // Creation of the chess board
        boardPanel = new JPanel();
        boardPanel.setBorder(BorderFactory.createEmptyBorder(marginY, marginX, marginY, marginX));

        // Set the background color of the board panel
        boardPanel.setBackground(new Color(240, 217, 181)); // Use your preferred color

        boardLabels = new JLabel[8][8];

        boardPanel.setLayout(new GridLayout(8, 8));

        // Create a 1 pixel black border
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JLabel label = new JLabel();
                boardLabels[col][row] = label;
                boardPanel.add(label);
                label.setBorder(border);
            }
        }

        add(boardPanel, BorderLayout.CENTER);
        // pack();

        setVisible(true);

        updateGUI();
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    private void updateGUI() {
        Color customColorGreen = new Color(119, 149, 86);
        Color customColorWhite = new Color(238, 238, 210);

        // Updates the board display
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessPiece piece = getChessGame().getPieceAt(x, y);
                boardLabels[x][y].setOpaque(true);
                boardLabels[x][y].setBackground((x + y) % 2 == 0 ? customColorWhite : customColorGreen);

                // Center icons
                boardLabels[x][y].setHorizontalAlignment(SwingConstants.CENTER);

               /* if (piece == null) {
                    continue;
                }*/
                ImageIcon icon = getIconForPiece(piece);
                boardLabels[x][y].setIcon(icon);
            }
        }
    }

    private ImageIcon getIconForPiece(ChessPiece piece) {
        if (piece == null) {
            return null;
        }
        int color = piece.getColor();
        String colorPiece;
        if (color == 1) {
            colorPiece = "WHITE_COLOR";
        } else {
            colorPiece = "BLACK_COLOR";
        }
        String type = piece.getClass().getSimpleName();
        String filename = colorPiece + "/" + type + ".png";

        try {
            File imageFile = new File(
                    getClass()
                            .getClassLoader()
                            .getResource(filename)
                            .toURI()
            );
            ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
            return icon;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
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

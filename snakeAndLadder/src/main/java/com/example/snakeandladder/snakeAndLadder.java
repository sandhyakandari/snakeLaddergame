package com.example.snakeandladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class snakeAndLadder extends Application {
    public static final int tileSize=40,width=10,height=10,infoLine=tileSize*height+10;
    //button position   infoline=buttonline-30
    public static final int buttonLine=height*tileSize+40;
private static Dice dice=new Dice();
private Player playerOne,playerTwo;
private boolean gameStart=false,playerOneTurn=false,playerTwoTrun=false;
    private Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+80);
        root.setBackground(Background.fill(Color.BLACK));
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j <width; j++) {
                //add one tile in window and using for loop multiple tile add in window
                tile tile=new tile(tileSize);
                // Translate=in window where tile will appear place of tile(j*tile size)=xand y coordinate
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().addAll(tile);
            }
        }
        Image img=new Image("C:\\Users\\91952\\IdeaProjects\\snakeAndLadder\\src\\main\\resources\\snakebord.jpg");
        //to display img
        ImageView board=new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tileSize);
        board.setFitWidth(width*tileSize);

        //button creation
        Button playerOneButton=new Button("Player One");
        Button playerTwoButton=new Button("Player Two");
        Button startButton=new Button("Start");
       // set button positon x and y coordinates
        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setTranslateX(20);
        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(300);
        startButton.setTranslateY(buttonLine);
        startButton.setTranslateX(170);
//set label
        Label playerOneLabel=new Label("");
        Label playerTwoLabel=new Label("");
        Label diceLabel=new Label("Let's start");
        diceLabel.setTextFill(Color.WHITE);
diceLabel.setFont(new Font(15));
        //fix postion of these label
        playerOneLabel.setTranslateX(20);
        playerOneButton.setDisable(true);
        playerOneLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateX(300);
        playerTwoButton.setDisable(true);
        diceLabel.setTranslateX(160);
        diceLabel.setTranslateY(infoLine);


        playerOne=new Player(tileSize, Color.BLACK,"Amit");
        playerTwo=new Player(tileSize-5,Color.WHITE,"Sumit");
//to see img

//player action
        //on player one button roll dice display value
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameStart) {
                    if (playerOneTurn) {
                        int diceValue = dice.getRollDiceValue();
                        diceLabel.setText("dice value:" + diceValue);
                        diceLabel.setTextFill(Color.WHITE);
                        playerOne.movePlayer(diceValue);
                        //winneing condition

                        if(playerOne.isWinner()){
                            diceLabel.setText("winner is "+playerOne.getName());
                            diceLabel.setTextFill(Color.WHITE);
                            diceLabel.setStyle("-font-size:16pt");
                            playerOneTurn=false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                            playerTwoTrun=true;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                            startButton.setDisable(false);
                            startButton.setText("restart");
                            gameStart=false;
                        }

      else {
                            playerOneTurn = false;
                            playerTwoTrun = true;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                            playerOneLabel.setTextFill(Color.WHITE);
                            playerTwoButton.setDisable(false);
                            playerTwoLabel.setText("Your turn " + playerTwo.getName());
                        // new change
                            playerTwoLabel.setTextFill(Color.WHITE);
                        }
                    }
                }
            }

        });

        //player two
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameStart) {
                    if (playerTwoTrun) {
                        int diceValue = dice.getRollDiceValue();
                        diceLabel.setText("dice value:" + diceValue);

                        diceLabel.setTextFill(Color.WHITE);
                        playerTwo.movePlayer(diceValue);
                        //winneing condition
                if(playerTwo.isWinner()){
                    diceLabel.setText("winner is "+playerTwo.getName());
                    diceLabel.setStyle("-font-size:16pt");
                    playerOneTurn=false;
                    playerOneButton.setDisable(true);
                    playerOneLabel.setText("");
                    playerTwoTrun=true;
                    playerTwoButton.setDisable(true);
                    playerTwoLabel.setText("");
                    startButton.setDisable(false);
                    startButton.setText("restart");
                }
                else {
                    playerOneTurn=true;
                    playerTwoTrun=false;
                    playerOneButton.setDisable(false);
                    playerOneLabel.setText("Your turn "+playerOne.getName());
                    playerOneLabel.setTextFill(Color.WHITE);
                    playerTwoButton.setDisable(true);
                    playerTwoLabel.setText(" ");
                }

                    }
                }
            }
        });
        //on start button game start
        startButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                   gameStart=true;
                                   diceLabel.setText("game started");
                                   diceLabel.setTextFill(Color.WHITE);
                                   startButton.setDisable(true);
                                   playerOneTurn=true;
                                   playerOneLabel.setText("Your turn "+playerOne.getName());
                                        playerOneLabel.setTextFill(Color.WHITE);
                                   playerOneButton.setDisable(false);
                                        playerOne.startingPosition();

                                   playerTwoTrun=false;
                                   playerTwoLabel.setText("");
                                   playerTwoButton.setDisable(true);
                                    playerTwo.startingPosition();}
                                }
        );
        root.getChildren().addAll(board,playerOneButton,playerTwoButton,startButton
        ,playerOneLabel,playerTwoLabel,diceLabel
        ,playerOne.getCoin(),playerTwo.getCoin());

        return root;

    }

    @Override
    public void start(Stage stage) throws IOException {
          Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.setResizable(false);
        Image Imag=new Image("C:\\Users\\91952\\IdeaProjects\\snakeAndLadder\\src\\main\\resources\\ic.jpg");
        stage.getIcons().add(Imag);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
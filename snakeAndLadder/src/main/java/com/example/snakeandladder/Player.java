package com.example.snakeandladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
//coin create coin,currentposition ,name
   private Circle coin;
private int currentPosition;
private String name;
private static Board gameBoard=new Board();
//makig coin
public Player(int tileSize, Color coinColor,String playerName){
    coin=new Circle(tileSize/2);
    coin.setFill(coinColor);
    // coin is set at 1;
      currentPosition=1;
      //initial position of coin
      movePlayer(0);
    name=playerName;
}

//to move player
    public  void movePlayer(int diceValue){
    if(currentPosition+diceValue<=100)
        currentPosition+=diceValue;
    TranslateTransition secondMove=null, firstMove=translateAnimation(diceValue);
        translateAnimation(diceValue);
        int newPosition=gameBoard.getNewPosition(currentPosition);
        if(newPosition!=currentPosition && newPosition!=-1){
            currentPosition=newPosition;
            secondMove=translateAnimation(6);
        }
        if(secondMove==null){
            firstMove.play();
        }
        else{
            SequentialTransition sequentialTransition=new SequentialTransition(firstMove,
                    new PauseTransition(Duration.millis(1000)),secondMove);
            sequentialTransition.play();
        }

   //now coment this because we use animation to move player

//int x= gameBoard.getXCoordinate(currentPosition);
//int y= gameBoard.getYCoordinate(currentPosition);
//coin.setTranslateX(x);
//coin.setTranslateY(y);

    }
//animation of coin
    private TranslateTransition translateAnimation(int diceValue){
        TranslateTransition animate=new TranslateTransition(Duration.millis(200*diceValue),coin);
        animate.setToY(gameBoard.getYCoordinate(currentPosition));
        animate.setToX(gameBoard.getXCoordinate(currentPosition));
        animate.setAutoReverse(false);
       return animate;
    }
    //to get initial opostin after winner
    public void startingPosition(){
    currentPosition=0;
    movePlayer(1);

    }
    boolean isWinner(){
    if(currentPosition==100){
        return true;
    }
    return false;
    }
    public Circle getCoin() {
        return coin;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}

package com.example.snakeandladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>>positionCoordinates;
ArrayList<Integer>snakeLadderPosition;
    public Board(){
        positionCoordinates=new ArrayList<>();
        populatePositionCoordinates();
       //function snake and ladder move
        populateSnakeLadder();
    }
private  void populatePositionCoordinates(){
        positionCoordinates.add(new Pair<>(0,0));
    for (int i = 0; i <snakeAndLadder.height ; i++) {
        for (int j = 0; j <snakeAndLadder.width ; j++) {
            //genrate xcoordinate
           int xCord=0;
        if(i%2==0){
        xCord=j*snakeAndLadder.tileSize+snakeAndLadder.tileSize/2;}
        else{
            xCord=snakeAndLadder.tileSize*snakeAndLadder.height-(j*snakeAndLadder.tileSize)-snakeAndLadder.tileSize/2;
           }
            //genrate ycoord
            int yCord=snakeAndLadder.tileSize*snakeAndLadder.height-(i*snakeAndLadder.tileSize)-snakeAndLadder.tileSize/2;
            positionCoordinates.add(new Pair<>(xCord,yCord));
        }

    }
}
private void populateSnakeLadder(){
        snakeLadderPosition=new ArrayList<>();
    for (int i = 0; i <101 ; i++) {
        snakeLadderPosition.add(i);
    }
    snakeLadderPosition.set(4,25);
    snakeLadderPosition.set(21,39);
    snakeLadderPosition.set(29,74);
    snakeLadderPosition.set(43,76);
    snakeLadderPosition.set(63,80);
    snakeLadderPosition.set(71,89);
    snakeLadderPosition.set(98,55);
    snakeLadderPosition.set(92,75);
    snakeLadderPosition.set(82,42);
    snakeLadderPosition.set(73,51);
    snakeLadderPosition.set(56,19);
    snakeLadderPosition.set(47,15);
    snakeLadderPosition.set(30,7);

}
public int getNewPosition(int currentPosition){
        if(currentPosition>0 && currentPosition<=100){
            return snakeLadderPosition.get(currentPosition);
        }
        return -1;
}
//to get x cordinate to player move player function
int getXCoordinate(int position){
        if(position>=1 && position<=100)
            return  positionCoordinates.get(position).getKey();
        return -1;

}
    int getYCoordinate(int position){
        if(position>=1 && position<=100)
            return  positionCoordinates.get(position).getValue();
        return -1;
    }
  //  public static void main(String[] args) {
      //  Board b=new Board();
       // for (int i = 0; i <b.positionCoordinates.size() ; i++) {
//System.out.println((b.positionCoordinates.get(i).getKey())+" "+b.positionCoordinates.get(i).getValue());
     //   }
   // }

}

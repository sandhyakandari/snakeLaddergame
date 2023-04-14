package com.example.snakeandladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class tile extends Rectangle {
    public tile(int tileSize){
        setWidth(tileSize);
        setHeight(tileSize);
        setFill(Color.AZURE);
        setStroke(Color.BLACK);
    }

}

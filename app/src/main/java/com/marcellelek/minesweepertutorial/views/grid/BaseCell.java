package com.marcellelek.minesweepertutorial.views.grid;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.marcellelek.minesweepertutorial.GameEngine;

/**
 * Created by Marcell on 2016. 04. 14..
 */
public abstract class BaseCell extends View {

    private int value;
    private boolean isBomb;
    private boolean isRevealed;
    private boolean isClicked;
    private boolean isFlagged;
    private boolean isGold;
    private Drawable[] goldstate;

    private int x , y;
    private int position;

    public BaseCell(Context context ){
        super(context);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        isBomb = false;
        isRevealed = false;
        isClicked = false;
        isFlagged = false;

        if( value == -1 ){
            isBomb = true;
        }else if(value ==-2) {
            isGold=true;
        }

        this.value = value;
    }

    public Drawable[] getGoldstate() {
        return goldstate;
    }

    public void setGoldstate(Drawable[] goldstate) {
        this.goldstate = goldstate;
    }

    public boolean isGold() {
        return isGold;
    }

    public void setGold(boolean gold) {
        isGold = gold;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed() {
        isRevealed = true;
        invalidate();
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {

            this.isClicked = true;
            this.isRevealed = true;

            invalidate();
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition( int x , int y ){
        this.x = x;
        this.y = y;

        this.position = y * GameEngine.WIDTH + x;

        invalidate();
    }

}

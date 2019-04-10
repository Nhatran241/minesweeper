package com.marcellelek.minesweepertutorial.views.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.marcellelek.minesweepertutorial.GameEngine;
import com.marcellelek.minesweepertutorial.R;

import java.util.Random;

/**
 * Created by Marcell on 2016. 04. 14..
 */
public class Cell extends BaseCell implements View.OnClickListener , View.OnLongClickListener{


    public Cell( Context context , int x , int y ){
        super(context);

        setPosition(x,y);

        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    public void onClick(View v) {
        if(isGold()&&isRevealed()&&!isFlagged()){
            Toast.makeText(getContext(), "ádasdasdasd", Toast.LENGTH_SHORT).show();
            setValue(0);
            setGold(false);
            invalidate();
        }
        if(!isFlagged()) {
            GameEngine.getInstance().click(getXPos(), getYPos());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        GameEngine.getInstance().flag( getXPos() , getYPos() );

        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawButton(canvas);

        if( isFlagged() ){
            drawFlag(canvas);
        }else if( isRevealed() && isBomb() && !isClicked() ){
            drawNormalBomb(canvas);
        }else {
            if( isClicked() ){
                if( getValue() == -1 ){
                    drawBombExploded(canvas);
                }else {
                    drawNumber(canvas);
                }
            }else{
                if(isGold()&&isRevealed()){
                    drawNumber(canvas);
                }else {
                    drawButton(canvas);
                }
            }
        }
    }


    private void drawBombExploded(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb_exploded);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawFlag( Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.flag);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawButton(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.button);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawNormalBomb(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb_normal);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }
    private void drawGold(){
        Drawable[] drawables = new Drawable[4];
        drawables[0]=ContextCompat.getDrawable(getContext(), R.drawable.tile000);
        drawables[1]=ContextCompat.getDrawable(getContext(), R.drawable.tile001);
        drawables[2]=ContextCompat.getDrawable(getContext(), R.drawable.tile002);
        drawables[3]=ContextCompat.getDrawable(getContext(), R.drawable.tile003);
        drawables[4]=ContextCompat.getDrawable(getContext(), R.drawable.tile004);
    }

    private void drawNumber( Canvas canvas ){
        Drawable drawable = null;

        switch (getValue() ){
            case -2:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.tile000);
                drawable.setBounds(getWidth()*1/6,getHeight()*1/6,getWidth()*5/6,getHeight()*5/6);
                break;
            case 0:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_0);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
            case 1:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_1);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
            case 2:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_2);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
            case 3:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_3);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
            case 4:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_4);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
            case 5:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_5);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
            case 6:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_6);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
            case 7:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_7);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
            case 8:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_8);
                drawable.setBounds(0,0,getWidth(),getHeight());
                break;
        }

        drawable.draw(canvas);
    }


}

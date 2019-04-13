package com.marcellelek.minesweepertutorial;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.marcellelek.minesweepertutorial.util.Generator;
import com.marcellelek.minesweepertutorial.views.grid.Cell;

/**
 * Created by Marcell on 2016. 04. 01..
 */
public class GameEngine {
    private static GameEngine instance;
    public static int LEVEL=1;

    public static int BOMB_NUMBER = 1;
    public static  int WIDTH = 6;
    public static  int HEIGHT = 6;

    private Context context;
    private GameStatesInterface gameStatesInterface;

    private Cell[][] MinesweeperGrid = new Cell[WIDTH][HEIGHT];
    public static int isEnd=1;
    public interface GameStatesInterface{
        void OnWin();
        void OnLose();
    }
    public static GameEngine getInstance() {
        if( instance == null ){
            instance = new GameEngine();
        }

        return instance;
    }

    private GameEngine(){ }

    public void createGrid(Context context){
        this.context = context;
        gameStatesInterface= (GameStatesInterface) context;
        // create the grid and store it
        int[][] GeneratedGrid = Generator.generate(BOMB_NUMBER,WIDTH, HEIGHT);
        MinesweeperGrid= new Cell[WIDTH][HEIGHT];
        setGrid(context,GeneratedGrid);

    }

    private void setGrid( final Context context, final int[][] grid ){
        Log.d("test", "setGrid: "+WIDTH+"/"+HEIGHT);
        for( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( MinesweeperGrid[x][y] == null ){
                        MinesweeperGrid[x][y] = new Cell(context, x, y);
                }
                MinesweeperGrid[x][y].setValue(grid[x][y]);
                MinesweeperGrid[x][y].invalidate();

            }
        }
    }

    public Cell getCellAt(int position) {
        int x = position % WIDTH;
        int y = position / WIDTH;

        return MinesweeperGrid[x][y];
    }

    public Cell getCellAt( int x , int y ){
        return MinesweeperGrid[x][y];
    }

    public void click( int x , int y ){
        if( x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT && !getCellAt(x,y).isClicked()) {
            Log.d("aaaaaa",x+"|"+y);
                getCellAt(x, y).setClicked();
                if (getCellAt(x, y).getValue() == 0||getCellAt(x, y).getValue() == -2) {
                    for (int xt = -1; xt <= 1; xt++) {
                        for (int yt = -1; yt <= 1; yt++) {
//                            if (xt != yt) {
                                click(x + xt, y + yt);
//                            }
                        }

                    }
                }
                if (getCellAt(x, y).isBomb()) {
                    onGameLost();
                    return;
                }
        }else {
        }
        if(isEnd==1) {
            checkEnd();
        }
    }

    private boolean checkEnd(){
//        Log.d("checkend", "checkEnd: ");
//        int notRevealed = WIDTH * HEIGHT;
//        for ( int x = 0 ; x < WIDTH ; x++ ){
//            for( int y = 0 ; y < HEIGHT ; y++ ){
//                if( getCellAt(x,y).isRevealed()){
//                    notRevealed--;
//                }
//
//                if( getCellAt(x,y).isFlagged() && getCellAt(x,y).isBomb() ){
//                    notRevealed--;
//                }
//            }
//        }
//
//        if(notRevealed == 0 ){
//            Log.d("checkend", "win: ");
//            gameStatesInterface.OnWin();
//        }
//        return false;
        int bombNotFound = BOMB_NUMBER;
        int notRevealed = (WIDTH * HEIGHT)-bombNotFound;
        int notRea=(WIDTH*HEIGHT);
        for ( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
//                if( getCellAt(x,y).isRevealed() || getCellAt(x,y).isFlagged() ) {

                if( getCellAt(x,y).isRevealed()){
                    notRevealed--;
                    notRea--;
                }

                if( getCellAt(x,y).isFlagged() && getCellAt(x,y).isBomb() ){
                    bombNotFound--;
                }
            }
        }
        if( notRea==BOMB_NUMBER ){
                gameStatesInterface.OnWin();
                isEnd = 2;
            return false;
        }
        if( bombNotFound == 0 && notRevealed == 0 ){
            gameStatesInterface.OnWin();
            isEnd=2;
        }
        return false;
    }

    public void flag( int x , int y ){
        if(!getCellAt(x,y).isRevealed()) {
            boolean isFlagged = getCellAt(x, y).isFlagged();
            getCellAt(x, y).setFlagged(!isFlagged);
            getCellAt(x, y).invalidate();
            checkEnd();
        }
    }

    private void onGameLost(){
        // handle lost game
        gameStatesInterface.OnLose();
        for ( int x = 0 ; x < WIDTH ; x++ ) {
            for (int y = 0; y < HEIGHT; y++) {
                if(!getCellAt(x,y).isGold()) {
                    getCellAt(x, y).setRevealed();
                }
            }
        }
    }
}

package com.example.androidstudio2dgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/**
 * Game manages all objects in the game and is responsible for updating all states and render all
 * objects to the screen
 */

class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameLoop gameLoop;
    private Context context;

    public Game(Context context) {
        super(context);

        //Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

         this.context = context;
         gameLoop = new GameLoop(this, surfaceHolder);

        setFocusable(true);
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
         gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawUPS(canvas);
        drawFPS(canvas);
    }

    public void drawUPS(Canvas canvas){
        String avergeUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS: " + avergeUPS, 200, 200, paint);
    }
    public void drawFPS(Canvas canvas){
        String avergeFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS: " + avergeFPS, 200, 400, paint);
    }

    public void update() {
        //Update game state
    }
}

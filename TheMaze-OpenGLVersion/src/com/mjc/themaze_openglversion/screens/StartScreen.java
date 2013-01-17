package com.mjc.themaze_openglversion.screens;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.mjc.themaze_openglversion.R;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class StartScreen implements Screen{

	Texture background;
	
	Button startButton;
	Button continueButton;
	Button exitButton;
	Button soundFXButton;
	Button musicButton;
	
	public StartScreen(Resources r){
		setBackground(r);
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		
		
		
	}
	
	private void setBackground(Resources r){
		
		Bitmap bkg = BitmapFactory.decodeResource(r, R.drawable.startscreen_background);
		
	}

}

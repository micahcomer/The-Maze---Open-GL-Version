package com.mjc.themaze_openglversion;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Screen;
import com.mjc.themaze_openglversion.screens.GameScreen;
import com.mjc.themaze_openglversion.screens.LoadScreen;
import com.mjc.themaze_openglversion.screens.PauseScreen;
import com.mjc.themaze_openglversion.screens.StartScreen;

public class GameApplication implements ApplicationListener{

	private static StartScreen startScreen;
	private static LoadScreen loadScreen;
	private static GameScreen gameScreen;
	private static PauseScreen pauseScreen;
	private Screen currentScreen;
	
	private long delta;
	
	@Override
	public void create() {
		//Game Screen Manager initialization code should go here.
		startScreen.show();
		loadScreen.hide();
		gameScreen.hide();
		pauseScreen.hide();
		currentScreen = startScreen;
	}

	@Override
	public void dispose() {
		//Code for final disposal of GSM should go here.
		
	}

	@Override
	public void pause() {
		// Code to pause the game and save any needed information should go here.
		
	}

	@Override
	public void render() {
		currentScreen.render(delta);		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// Code to deal with window resizing should go here.
		
	}

	@Override
	public void resume() {
		// Unpausing code should go here.
		
	}

}

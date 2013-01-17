package com.mjc.themazeopenglversion;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mjc.themazeopenglversion.screens.GameScreen;
import com.mjc.themazeopenglversion.screens.LoadScreen;
import com.mjc.themazeopenglversion.screens.PauseScreen;
import com.mjc.themazeopenglversion.screens.StartScreen;

public class GameApplication implements ApplicationListener{

	private AssetManager assetManager;
	private SpriteBatch spriteBatch;
	
	private StartScreen startScreen;
	private LoadScreen loadScreen;
	private GameScreen gameScreen;
	private PauseScreen pauseScreen;
	private Screen currentScreen;
	
	private long delta;
	
	@Override
	public void create() {
		//Game Screen Manager initialization code should go here.
		assetManager = new AssetManager();
		spriteBatch = new SpriteBatch();
		startScreen = new StartScreen(assetManager, spriteBatch);
		loadScreen = new LoadScreen();
		gameScreen = new GameScreen();
		pauseScreen = new PauseScreen();
		
		
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

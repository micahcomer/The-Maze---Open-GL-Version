package com.mjc.themazeopenglversion;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mjc.themazeopenglversion.screens.GameScreen;
import com.mjc.themazeopenglversion.screens.LoadScreen;
import com.mjc.themazeopenglversion.screens.PauseScreen;
import com.mjc.themazeopenglversion.screens.StartScreen;

public class GameApplication extends Game implements ApplicationListener{

	private AssetManager assetManager;
	private SpriteBatch spriteBatch;
	
	StartScreen startScreen;
	LoadScreen loadScreen;
	GameScreen gameScreen;
	PauseScreen pauseScreen;
	
	Audio audio;
	boolean soundFXEnabled = true;
	boolean musicEnabled = true;
	
	@Override
	public void create() {
		//Game Screen Manager initialization code should go here.
		assetManager = new AssetManager();
		spriteBatch = new SpriteBatch();
		audio = Gdx.audio;
		startScreen = new StartScreen(assetManager, spriteBatch, this, audio);
		loadScreen = new LoadScreen(assetManager, this, spriteBatch);
		gameScreen = new GameScreen();
		pauseScreen = new PauseScreen();				
		setScreen(startScreen);
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
	this.getScreen().render(Gdx.graphics.getDeltaTime());			
	}

	@Override
	public void resize(int arg0, int arg1) {
		// Code to deal with window resizing should go here.
		
	}

	@Override
	public void resume() {
		// Unpausing code should go here.
		
	}
	
	public void startGame(){
		setScreen(loadScreen);
	}
	
	public void toggleMusic(){
		musicEnabled = !musicEnabled;
	}
	
	public void toggleSoundFX(){
		soundFXEnabled = !soundFXEnabled;
	}

}

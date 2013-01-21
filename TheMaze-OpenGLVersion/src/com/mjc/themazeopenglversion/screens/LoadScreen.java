package com.mjc.themazeopenglversion.screens;

import android.graphics.Point;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LoadScreen implements Screen{

	Game game;
	AssetManager assetManager;
	Point screenDimensions;
	SpriteBatch spriteBatch;
	Texture background;
	
	public LoadScreen(AssetManager assetManager, Game game, SpriteBatch spriteBatch){
		this.assetManager = assetManager;
		this.game = game;
		loadAssets();
		screenDimensions = new Point (Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.spriteBatch = spriteBatch;
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
		
		spriteBatch.begin();
		spriteBatch.draw(background, 0, 0, screenDimensions.x, screenDimensions.y, 0,0, background.getWidth(), background.getHeight(), false, false); 
		spriteBatch.end();
		
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
		// TODO Auto-generated method stub
		
	}
	
	private void loadAssets(){
		assetManager.load("loadingbackground.png", Texture.class);
		assetManager.finishLoading();
		background = assetManager.get("loadingbackground.png", Texture.class);
	}

}

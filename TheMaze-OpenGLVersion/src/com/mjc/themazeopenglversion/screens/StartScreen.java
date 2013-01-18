package com.mjc.themazeopenglversion.screens;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class StartScreen implements Screen{

	Texture background;	
	Vector2 screenDimensions; 
	
	Button startButton;
	Button continueButton;
	Button exitButton;
	Button soundFXButton;
	Button musicButton;
	
	SpriteBatch spriteBatch;
	
	public StartScreen(AssetManager assetManager, SpriteBatch spriteBatch){
		screenDimensions = new Vector2 (Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		setBackground(assetManager);
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
	
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		spriteBatch.begin();
		//FIRST 2 float Coordinates are the BOTTOM-left corner of the screen!
		//800 and 433 are the height of the actual bmp before I had to increase the size to powers of two.
	
		
		spriteBatch.draw(background, 0f, 0f, screenDimensions.x, screenDimensions.y, 0,0,800,433,false, false);
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
		
		
		
	}
	
	private void setBackground(AssetManager assetManager){
		
		assetManager.load("startscreen_background.png", Texture.class);		
		while (!assetManager.update()){ }		
		background = assetManager.get("startscreen_background.png", Texture.class);
		
		
	}

}

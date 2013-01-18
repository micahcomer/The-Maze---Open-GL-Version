package com.mjc.themazeopenglversion.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class StartScreen implements Screen, EventListener{

	Texture background;	
	Vector2 screenDimensions; 
	
	Button startButton;
	Button continueButton;
	Button exitButton;
	Button soundFXButton;
	Button musicButton;
	
	SpriteBatch spriteBatch;
	
	private Stage stage;
	
	public StartScreen(AssetManager assetManager, SpriteBatch spriteBatch){
		
		screenDimensions = new Vector2 (Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		setStage();		
		setBackground(assetManager);
		this.spriteBatch = spriteBatch;
		
	}
	
	private void setStage(){
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
	}
	
	private void setBackground(AssetManager assetManager){
		
		assetManager.load("startscreen_background.png", Texture.class);		
		assetManager.load("button_start.png", Texture.class);			
		assetManager.finishLoading();			
		background = assetManager.get("startscreen_background.png", Texture.class);
		Texture startButtonTexture = assetManager.get("button_start.png", Texture.class);
		TextureRegion startButtonTR = new TextureRegion(startButtonTexture);
		TextureRegionDrawable startButtonTRD = new TextureRegionDrawable(startButtonTR);
		startButton = new Button(startButtonTRD);	
		startButton.setBounds(0f, 0f, 400, 100);
		startButton.setPosition(((float)screenDimensions.x)*(3.5f/5f), (float)(screenDimensions.y)*(3f/4f));
		startButton.addListener(this);
		stage.addActor(startButton);		
		
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
		
		stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
	
	@Override
	public boolean handle(Event e) {
		
		if (e.getListenerActor() == startButton){
			startGame();
			return true;
		}
		else{
			return false;
		}
	}

	private void startGame(){
		
	}
	

}

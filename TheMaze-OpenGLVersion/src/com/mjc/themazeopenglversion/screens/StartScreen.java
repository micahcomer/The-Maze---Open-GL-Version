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
		
		//Apparently I need to "create a 'stage' and add 'actors' to it.  I don't really get this part, but I just followed the documentation.
		setStage();		
		
		//This started out just setting the background, but I added the start button in this method too.  Buttons should be split out separately later.
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
		
		//Queue assets to load...
		assetManager.load("startscreen_background.png", Texture.class);		
		assetManager.load("button_start.png", Texture.class);
		
		//Wait till they finish loading...
		assetManager.finishLoading();		
		
		//Assign the assets that just loaded...
		background = assetManager.get("startscreen_background.png", Texture.class);
		Texture startButtonTexture = assetManager.get("button_start.png", Texture.class);
		
		//Run "texture through 2 other thingys to turn it into a "TextureRegiionDrawable, which is what the "Button" constructor needs.
		TextureRegion startButtonTR = new TextureRegion(startButtonTexture);
		TextureRegionDrawable startButtonTRD = new TextureRegionDrawable(startButtonTR);
		
		//Create the start button
		startButton = new Button(startButtonTRD);	
		
		//Define how big it is.
		startButton.setBounds(0f, 0f, 400, 100);
		
		//Move it to where it should go on the screen.
		startButton.setPosition(((float)screenDimensions.x)*(3.5f/5f), (float)(screenDimensions.y)*(3f/4f));
		
		//Tell it to notify this class (StartScreen) when clicked.
		startButton.addListener(this);
		
		//Add it to the stage so it will "act" and "draw" when the stage does.
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

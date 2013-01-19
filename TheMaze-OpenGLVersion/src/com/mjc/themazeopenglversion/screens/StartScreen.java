package com.mjc.themazeopenglversion.screens;

import android.view.ViewGroup.MarginLayoutParams;

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
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mjc.themazeopenglversion.GameApplication;

public class StartScreen implements Screen, EventListener{

	GameApplication game;
	
	Texture background;	
	Vector2 screenDimensions; 
	
	Button startButton;
	Button continueButton;
	Button exitButton;
	Button soundFXButton;
	Button musicButton;
	
	int borderAmount;
	int lineSpacing;
	int buttonColumnWidth;
	int buttonRowHeight;
	
	
	SpriteBatch spriteBatch;
	
	private Stage stage;
	
	public StartScreen(AssetManager assetManager, SpriteBatch spriteBatch, GameApplication game){
		
		screenDimensions = new Vector2 (Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		borderAmount = 50;
		lineSpacing = 50;
		buttonColumnWidth = 400;
		buttonRowHeight = (int)((screenDimensions.y - (2*borderAmount + 3*lineSpacing))/4);
		
		//Apparently I need to "create a 'stage' and add 'actors' to it.  I don't really get this part, but I just followed the documentation.
		setStage();				
		loadAssets(assetManager);		
		setBackground(assetManager);		
		createButtons(assetManager);
		this.spriteBatch = spriteBatch;
		
		this.game = game;
	}
	
	private void setStage(){
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
	}
	
	private void setBackground(AssetManager assetManager){
		
		//Assign the assets that just loaded...
		background = assetManager.get("startscreen_background.png", Texture.class);
	}
	
	private void createButtons(AssetManager assetManager){
		
		createStartButton(assetManager);
		//createContinueButton(assetManager);
		//createExitButton(assetManager);
		//createSoundFXToggleButton(assetManager);
		//createMusicToggleButton(assetManager);
	}
	
	private void createStartButton(AssetManager assetManager){
		
		Texture startButtonTexture = assetManager.get("button_start.png", Texture.class);
		
		//Run "texture through 2 other thingys to turn it into a "TextureRegiionDrawable, which is what the "Button" constructor needs.
		TextureRegion startButtonTR = new TextureRegion(startButtonTexture);
		TextureRegionDrawable startButtonTRD = new TextureRegionDrawable(startButtonTR);
		
		//Create the start button
		startButton = new Button(startButtonTRD);
				
		//Define how big it is.
		startButton.setBounds(0f, 0f, buttonColumnWidth, buttonRowHeight);
		
		//Move it to where it should go on the screen.
		startButton.setPosition(screenDimensions.x - (borderAmount+buttonColumnWidth), screenDimensions.y - (borderAmount + buttonRowHeight));
		
		//Tell it to notify this class (StartScreen) when clicked.
		startButton.addListener(this);
		
		//Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(startButton);
		
		
	}
	private void createContinueButton(AssetManager assetManager){

		Texture continueButtonTextureActive = assetManager.get("button_continue.png", Texture.class);
		Texture continueButtonTextureInactive = assetManager.get("button_continue_inactive.png", Texture.class);
		
		//Run "texture through 2 other thingys to turn it into a "TextureRegiionDrawable, which is what the "Button" constructor needs.
		TextureRegion continueButtonActiveTR = new TextureRegion(continueButtonTextureActive);
		TextureRegion continueButtonInactiveTR = new TextureRegion(continueButtonTextureInactive);
		
		TextureRegionDrawable continueButtonActiveTRD = new TextureRegionDrawable(continueButtonActiveTR);
		TextureRegionDrawable continueButtonInactiveTRD = new TextureRegionDrawable(continueButtonInactiveTR);
		
		//Create the start button
		continueButton = new Button(continueButtonActiveTRD, continueButtonInactiveTRD);	
				
		//Define how big it is.
		continueButton.setBounds(0f, 0f, buttonColumnWidth, buttonRowHeight);
		
		//Move it to where it should go on the screen.
		continueButton.setPosition(lineSpacing + buttonColumnWidth, lineSpacing*3 + buttonRowHeight*2);
		
		//Tell it to notify this class (StartScreen) when clicked.
		continueButton.addListener(this);
		
		//Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(continueButton);			
		
	}
	private void createExitButton(AssetManager assetManager){

		Texture exitButtonTexture = assetManager.get("button_exit.png", Texture.class);
		
		//Run "texture through 2 other thingys to turn it into a "TextureRegiionDrawable, which is what the "Button" constructor needs.
		TextureRegion exitButtonTR = new TextureRegion(exitButtonTexture);
		TextureRegionDrawable exitButtonTRD = new TextureRegionDrawable(exitButtonTR);
		
		//Create the start button
		exitButton = new Button(exitButtonTRD);	
				
		//Define how big it is.
		exitButton.setBounds(0f, 0f, buttonColumnWidth, buttonRowHeight);
		
		//Move it to where it should go on the screen.
		exitButton.setPosition(lineSpacing + buttonColumnWidth, lineSpacing*2 + buttonRowHeight*1);
		
		//Tell it to notify this class (StartScreen) when clicked.
		exitButton.addListener(this);
		
		//Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(exitButton);	
		
	}
	private void createSoundFXToggleButton(AssetManager assetManager) {
		
		Texture soundFXButtonActiveTexture = assetManager.get("soundfxbutton_active.png", Texture.class);
		Texture soundFXButtonInactiveTexture = assetManager.get("soundfxbutton_inactive.png", Texture.class);
		
		//Run "texture through 2 other thingys to turn it into a "TextureRegiionDrawable, which is what the "Button" constructor needs.
		TextureRegion soundFXActiveButtonTR = new TextureRegion(soundFXButtonActiveTexture);
		TextureRegion soundFXInactiveButtonTR = new TextureRegion(soundFXButtonInactiveTexture);
		
		TextureRegionDrawable soundFXButtonActiveTRD = new TextureRegionDrawable(soundFXActiveButtonTR);
		TextureRegionDrawable soundFXButtonInactiveTRD = new TextureRegionDrawable(soundFXInactiveButtonTR);
		
		//Create the start button
		soundFXButton = new Button(soundFXButtonActiveTRD, soundFXButtonInactiveTRD);	
		
		//Define how big it is.
		soundFXButton.setBounds(0f, 0f, buttonRowHeight, buttonRowHeight);
		
		//Move it to where it should go on the screen.
		soundFXButton.setPosition(lineSpacing + buttonColumnWidth, lineSpacing);
		
		//Tell it to notify this class (StartScreen) when clicked.
		soundFXButton.addListener(this);
		
		//Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(soundFXButton);
		
	}
	private void createMusicToggleButton(AssetManager assetManager) {

		Texture musicButtonActiveTexture = assetManager.get("musicbutton_active.png", Texture.class);
		Texture musicButtonInactiveTexture = assetManager.get("musicbutton_inactive.png", Texture.class);
		
		//Run "texture through 2 other thingys to turn it into a "TextureRegiionDrawable, which is what the "Button" constructor needs.
		TextureRegion musicButtonActiveTR = new TextureRegion(musicButtonActiveTexture);
		TextureRegion musicButtonInactiveTR = new TextureRegion(musicButtonInactiveTexture);
		
		TextureRegionDrawable musicButtonActiveTRD = new TextureRegionDrawable(musicButtonActiveTR);
		TextureRegionDrawable musicButtonInactiveTRD = new TextureRegionDrawable(musicButtonInactiveTR);
		
		//Create the start button
		musicButton = new Button(musicButtonActiveTRD, musicButtonInactiveTRD);	
		
		//Define how big it is.
		musicButton.setBounds(0f, 0f, buttonColumnWidth, buttonRowHeight);
		
		//Move it to where it should go on the screen.
		musicButton.setPosition(lineSpacing+buttonRowHeight, lineSpacing);
		
		//Tell it to notify this class (StartScreen) when clicked.
		musicButton.addListener(this);
		
		//Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(musicButton);
		
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
			if (e.getListenerActor() == continueButton){
				continueGame();
				return true;
			}
			else{
				if (e.getListenerActor()== exitButton){
					exitGame();
					return true;
				}
				else {
					if (e.getListenerActor()==soundFXButton){
						toggleSoundFX();
						return true;
					}
					else{
						if (e.getListenerActor()==musicButton){
							toggleMusic();
							return true;
						}
						else{
							return false;
						}
					}
						
				}
			}
		}
	}

	private void toggleMusic() {
		// TODO Auto-generated method stub
		
	}

	private void toggleSoundFX() {
		// TODO Auto-generated method stub
		
	}

	private void exitGame() {
		// TODO Auto-generated method stub
		
	}

	private void continueGame() {
		// TODO Auto-generated method stub
		
	}

	private void startGame(){
		game.startGame();
	}
	

	private void loadAssets(AssetManager assetManager){
		
		//Queue assets to load...
		assetManager.load("startscreen_background.png", Texture.class);		
		assetManager.load("button_start.png", Texture.class);
		assetManager.load("button_continue.png", Texture.class);
		assetManager.load("button_continue_inactive.png", Texture.class);
		assetManager.load("button_exit.png", Texture.class);
		assetManager.load("musicbutton_active.png", Texture.class);
		assetManager.load("musicbutton_inactive.png", Texture.class);
		assetManager.load("soundfxbutton_active.png", Texture.class);
		assetManager.load("soundfxbutton_inactive.png", Texture.class);
				
		//Wait till they finish loading...
		assetManager.finishLoading();		
	}
	
	
}

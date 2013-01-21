package com.mjc.themazeopenglversion.screens;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mjc.themazeopenglversion.GameApplication;


public class StartScreen implements Screen, EventListener {

	GameApplication game;

	Texture background;
	Vector2 screenDimensions;

	Button startButton;
	Button continueButton;
	Button exitButton;
	CheckBox soundFXButton;
	CheckBox musicButton;
	boolean musicButtonWasDown = false;
	boolean FXButtonWasDown = false;

	int horizontalBorderAmount;
	int verticalBorderAmount;
	int lineSpacing;
	int buttonColumnWidth;
	int buttonRowHeight;

	SpriteBatch spriteBatch;

	private Stage stage;
	
	private Sound clickSound;
	boolean soundFXEnabled = true;
	boolean musicEnabled = true;

	public StartScreen(AssetManager assetManager, SpriteBatch spriteBatch, GameApplication game, Audio audio) {

		screenDimensions = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		verticalBorderAmount = -25;
		horizontalBorderAmount = 45;
		lineSpacing = 50;
		buttonColumnWidth = 430;
		buttonRowHeight = (int) ((screenDimensions.y - (2 * horizontalBorderAmount + 3 * lineSpacing)) / 4);

		// Apparently I need to "create a 'stage' and add 'actors' to it. I
		// don't really get this part, but I just followed the documentation.
		setStage();
		loadAssets(assetManager);
		setBackground(assetManager);
		createButtons(assetManager);
		this.spriteBatch = spriteBatch;

		this.game = game;		
		clickSound = Gdx.audio.newSound(Gdx.files.internal("click.mp3") );
	}

	private void setStage() {

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
	}

	private void setBackground(AssetManager assetManager) {

		// Assign the assets that just loaded...
		background = assetManager.get("startscreen_background.png",
				Texture.class);
	}

	private void createButtons(AssetManager assetManager) {

		createStartButton(assetManager);
		createContinueButton(assetManager);
		createExitButton(assetManager);
		createSoundFXToggleButton(assetManager);
		createMusicToggleButton(assetManager);
	}

	private void createStartButton(AssetManager assetManager) {

		Texture startButtonTexture = assetManager.get("button_start.png",
				Texture.class);

		// Run
		// "texture through 2 other thingys to turn it into a "TextureRegiionDrawable,
		// which is what the "Button" constructor needs.
		TextureRegion startButtonTR = new TextureRegion(startButtonTexture);
		TextureRegionDrawable startButtonTRD = new TextureRegionDrawable(
				startButtonTR);

		// Create the start button
		startButton = new Button(startButtonTRD);

		// Define how big it is.
		startButton.setBounds(0f, 0f, buttonColumnWidth, buttonRowHeight);

		// Move it to where it should go on the screen.
		startButton
		.setPosition(screenDimensions.x
				- (verticalBorderAmount + buttonColumnWidth),
				screenDimensions.y
				- (horizontalBorderAmount + buttonRowHeight));
		startButton.setOrigin(startButtonTexture.getWidth()/2, startButtonTexture.getHeight()/2);

		// Tell it to notify this class (StartScreen) when clicked.
		startButton.addListener(this);
		startButton.addAction(getActionSequenceForButtons(new Random().nextFloat()));
		
		
		// Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(startButton);

	}
	
	private RepeatAction getActionSequenceForButtons(float delay){
		
		RepeatAction ra = new RepeatAction();
		SequenceAction sa = new SequenceAction();
		sa.addAction(Actions.delay(delay));
		sa.addAction(Actions.sizeBy(5, 5, .75f));
		sa.addAction(Actions.sizeBy(-5, -5, .75f));
		ra.setAction(sa);
		ra.setCount(RepeatAction.FOREVER);
		return ra;
	}

	private void createContinueButton(AssetManager assetManager) {

		Texture continueButtonTextureActive = assetManager.get(
				"button_continue.png", Texture.class);
		Texture continueButtonTextureInactive = assetManager.get(
				"button_continue_inactive.png", Texture.class);

		// Run
		// "texture through 2 other thingys to turn it into a "TextureRegiionDrawable,
		// which is what the "Button" constructor needs.
		TextureRegion continueButtonActiveTR = new TextureRegion(
				continueButtonTextureActive);
		TextureRegion continueButtonInactiveTR = new TextureRegion(
				continueButtonTextureInactive);

		TextureRegionDrawable continueButtonActiveTRD = new TextureRegionDrawable(
				continueButtonActiveTR);
		TextureRegionDrawable continueButtonInactiveTRD = new TextureRegionDrawable(
				continueButtonInactiveTR);

		// Create the start button
		continueButton = new Button(continueButtonActiveTRD,
				continueButtonInactiveTRD);
		continueButton.addAction(getActionSequenceForButtons(new Random().nextFloat()));
		// Define how big it is.
		continueButton.setBounds(0f, 0f, buttonColumnWidth, buttonRowHeight);

		// Move it to where it should go on the screen.
		continueButton
		.setPosition(
				screenDimensions.x
				- (verticalBorderAmount + buttonColumnWidth),
				screenDimensions.y
				- (horizontalBorderAmount + buttonRowHeight * 2 + lineSpacing));

		// Tell it to notify this class (StartScreen) when clicked.
		continueButton.addListener(this);

		// Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(continueButton);

	}

	private void createExitButton(AssetManager assetManager) {

		Texture exitButtonTexture = assetManager.get("button_exit.png",
				Texture.class);

		// Run
		// "texture through 2 other thingys to turn it into a "TextureRegiionDrawable,
		// which is what the "Button" constructor needs.
		TextureRegion exitButtonTR = new TextureRegion(exitButtonTexture);
		TextureRegionDrawable exitButtonTRD = new TextureRegionDrawable(
				exitButtonTR);

		// Create the start button
		exitButton = new Button(exitButtonTRD);

		// Define how big it is.
		exitButton.setBounds(0f, 0f, buttonColumnWidth, buttonRowHeight);

		// Move it to where it should go on the screen.
		exitButton
		.setPosition(
				screenDimensions.x
				- (verticalBorderAmount + buttonColumnWidth),
				screenDimensions.y
				- (horizontalBorderAmount + buttonRowHeight * 3 + lineSpacing * 2));

		// Tell it to notify this class (StartScreen) when clicked.
		exitButton.addListener(this);
		exitButton.addAction(getActionSequenceForButtons(new Random().nextFloat()));
		// Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(exitButton);

	}

	private void createSoundFXToggleButton(AssetManager assetManager) {

		Texture soundFXButtonActiveTexture = assetManager.get(
				"soundfxbutton_active.png", Texture.class);
		Texture soundFXButtonInactiveTexture = assetManager.get(
				"soundfxbutton_inactive.png", Texture.class);

		// Run
		// "texture through 2 other thingys to turn it into a "TextureRegiionDrawable,
		// which is what the "Button" constructor needs.
		TextureRegion soundFXActiveButtonTR = new TextureRegion(
				soundFXButtonActiveTexture);
		TextureRegion soundFXInactiveButtonTR = new TextureRegion(
				soundFXButtonInactiveTexture);

		TextureRegionDrawable soundFXButtonActiveTRD = new TextureRegionDrawable(
				soundFXActiveButtonTR);
		TextureRegionDrawable soundFXButtonInactiveTRD = new TextureRegionDrawable(
				soundFXInactiveButtonTR);

		// Create the start button
		CheckBoxStyle s = new CheckBoxStyle();
		s.font = new BitmapFont();			
		s.checkboxOn = soundFXButtonActiveTRD;
		s.checkboxOn.setMinHeight(buttonRowHeight);		
		s.checkboxOn.setMinWidth(buttonRowHeight);
		s.checkboxOff = soundFXButtonInactiveTRD;
		s.checkboxOff.setMinHeight(buttonRowHeight);
		s.checkboxOff.setMinWidth(buttonRowHeight);
		soundFXButton = new CheckBox("", s);
		soundFXButton.setChecked(true);


		// Define how big it is.
		soundFXButton.setBounds(0f, 0f, buttonRowHeight, buttonRowHeight);

		// Move it to where it should go on the screen.
		soundFXButton
		.setPosition(
				screenDimensions.x
				- (buttonColumnWidth + verticalBorderAmount * 4),
				screenDimensions.y
				- (horizontalBorderAmount + buttonRowHeight * 4 + lineSpacing * 3));



		// Tell it to notify this class (StartScreen) when clicked.
		soundFXButton.addListener(this);

		// Add it to the stage so it will "act" and "draw" when the stage does.
		stage.addActor(soundFXButton);

	}

	private void createMusicToggleButton(AssetManager assetManager) {

		Texture musicButtonActiveTexture = assetManager.get(
				"musicbutton_active.png", Texture.class);
		Texture musicButtonInactiveTexture = assetManager.get(
				"musicbutton_inactive.png", Texture.class);

		// Run
		// "texture through 2 other thingys to turn it into a "TextureRegiionDrawable,
		// which is what the "Button" constructor needs.
		TextureRegion musicButtonActiveTR = new TextureRegion(
				musicButtonActiveTexture);
		TextureRegion musicButtonInactiveTR = new TextureRegion(
				musicButtonInactiveTexture);

		TextureRegionDrawable musicButtonActiveTRD = new TextureRegionDrawable(
				musicButtonActiveTR);
		TextureRegionDrawable musicButtonInactiveTRD = new TextureRegionDrawable(
				musicButtonInactiveTR);

		// Create the start button
		CheckBoxStyle s = new CheckBoxStyle();
		s.font = new BitmapFont();			
		s.checkboxOn = musicButtonActiveTRD;
		s.checkboxOn.setMinHeight(buttonRowHeight);		
		s.checkboxOn.setMinWidth(buttonRowHeight);
		s.checkboxOff = musicButtonInactiveTRD;
		s.checkboxOff.setMinHeight(buttonRowHeight);
		s.checkboxOff.setMinWidth(buttonRowHeight);		
		musicButton = new CheckBox("", s);
		musicButton.setChecked(true);

		// Define how big it is.
		musicButton.setBounds(0f, 0f, buttonRowHeight, buttonRowHeight);

		// Move it to where it should go on the screen.
		musicButton
		.setPosition(
				screenDimensions.x
				- (-verticalBorderAmount * 2 + buttonRowHeight),
				screenDimensions.y
				- (horizontalBorderAmount + buttonRowHeight * 4 + lineSpacing * 3));

		// Tell it to notify this class (StartScreen) when clicked.
		musicButton.addListener(this);

		// Add it to the stage so it will "act" and "draw" when the stage does.
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
		// FIRST 2 float Coordinates are the BOTTOM-left corner of the screen!
		// 800 and 433 are the height of the actual bmp before I had to increase
		// the size to powers of two.
		spriteBatch.draw(background, 0f, 0f, screenDimensions.x,
				screenDimensions.y, 0, 0, 800, 433, false, false);
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

		if ((e instanceof InputEvent) && ((InputEvent)e).getType().equals(InputEvent.Type.touchDown)){

			if (e.getListenerActor() == startButton) {
				playClick();
				startGame();
				return true;
			} else {
				if (e.getListenerActor() == continueButton) {
					playClick();
					continueGame();
					return true;
				} else {
					if (e.getListenerActor() == exitButton) {
						playClick();
						exitGame();
						return true;
					}else			
						if (e instanceof InputEvent){
							if (e.getListenerActor().equals(musicButton)){
								playClick();
								toggleMusic();
								return true;
							}
							else{
								if (e.getListenerActor().equals(soundFXButton)){							
									toggleSoundFX();
									playClick();
									return true;
								}
								else{
									return false;
								}
							}
						}else{
							return false;
						}
				}
			}
		}else
		{
			return false;
		}
	}

	private void startGame() {
		game.startGame();
	}

	private void continueGame() {
		// TODO Auto-generated method stub
	
	}

	private void exitGame() {
		Gdx.app.exit();
	}

	private void toggleMusic(){
		musicEnabled = !musicEnabled;
		game.toggleMusic();
	}

	private void toggleSoundFX(){
		soundFXEnabled = !soundFXEnabled;
		game.toggleSoundFX();
	}

	private void playClick(){
		if ((soundFXEnabled)){
			clickSound.play(1.0f);
		}
	}

	private void loadAssets(AssetManager assetManager) {

		// Queue assets to load...
		assetManager.load("startscreen_background.png", Texture.class);
		assetManager.load("button_start.png", Texture.class);
		assetManager.load("button_continue.png", Texture.class);
		assetManager.load("button_continue_inactive.png", Texture.class);
		assetManager.load("button_exit.png", Texture.class);
		assetManager.load("musicbutton_active.png", Texture.class);
		assetManager.load("musicbutton_inactive.png", Texture.class);
		assetManager.load("soundfxbutton_active.png", Texture.class);
		assetManager.load("soundfxbutton_inactive.png", Texture.class);

		// Wait till they finish loading...
		assetManager.finishLoading();
	}

}

package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BetaGame;

public class MainMenuScreen implements Screen {
	private static final int EXIT_BUTTON_WIDTH = 250;
	private static final int EXIT_BUTTON_HEIGHT = 200;
	private static final int PLAY_BUTTON_WIDTH = 300;
	private static final int PLAY_BUTTON_HEIGHT = 250;
	BetaGame game;
	Texture exitButtonActive;
	Texture exitButtonInactive;
	Texture playButtonActive;
	Texture playButtonInactive;
	
	public MainMenuScreen(BetaGame game){
		this.game =game;
		exitButtonActive = new Texture("exit_button.png");
		playButtonActive = new Texture("play_button.png");
		exitButtonInactive = new Texture("Exit2.png");
		playButtonInactive = new Texture("Play2.png");
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	
		game.batch.begin();
		int x = (BetaGame.WIDTH /2) - (EXIT_BUTTON_WIDTH/2);
		int y = 100;
		if(Gdx.input.getX()< x + EXIT_BUTTON_WIDTH && Gdx.input.getX()> x && BetaGame.HEIGHT -Gdx.input.getY() < y + EXIT_BUTTON_HEIGHT && BetaGame.HEIGHT - Gdx.input.getY() >y){ 
			game.batch.draw(exitButtonActive, x, y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);		
			if(Gdx.input.isTouched()){
				Gdx.app.exit();
			}
		}else{
			game.batch.draw(exitButtonInactive, x, y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);		
		}
		int w = BetaGame.WIDTH / 2 - PLAY_BUTTON_WIDTH/2;
		int z = 300;
		if(Gdx.input.getX()< w + PLAY_BUTTON_WIDTH && Gdx.input.getX()> w && BetaGame.HEIGHT - Gdx.input.getY() < z + PLAY_BUTTON_HEIGHT && BetaGame.HEIGHT - Gdx.input.getY() >z){ 
			game.batch.draw(playButtonActive, w, z, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);		
			if(Gdx.input.isTouched()){
				game.setScreen(new GameScreen(game));
			}
		}else{
			game.batch.draw(playButtonInactive, w, z, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);		
		}
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

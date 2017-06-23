package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.gameOver;

public class BetaGame extends Game {
	
	public SpriteBatch batch;
	public static final int WIDTH = 780;
	public static final int HEIGHT = 600;
	
	@Override
	public void create () {	
		
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
			
		
	}
	

}

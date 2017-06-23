package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.BetaGame;

public class gameOver implements Screen{
	private static final int WIDTH = 350;
	private static final int HEIGHT = 100;
	Texture gameOver;
	BitmapFont scoreFont;
	
	BetaGame game;
	int score, highscore; 
	
	public gameOver(BetaGame game, int score){
		this.game = game;
		this.score = score;
		
		Preferences pref = Gdx.app.getPreferences("Face Shooter");
		this.highscore = pref.getInteger("highscore", 0);
		
		if(score > highscore){
			pref.putInteger("highscore", score);
			pref.flush();
		}
		
		gameOver = new Texture("gameOver.png");
		scoreFont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		game.batch.begin();
		
		game.batch.draw(gameOver, Gdx.graphics.getWidth()/2 - WIDTH/2, Gdx.graphics.getHeight()/2 + 70,WIDTH,HEIGHT);		


		GlyphLayout scoreLayout = new GlyphLayout(scoreFont, "Score: \n" + score, Color.WHITE,0,Align.left,false);
		GlyphLayout highscoreLayout = new GlyphLayout(scoreFont, "HighScore: \n" + highscore, Color.WHITE,0,Align.left,false);
		
		scoreFont.draw(game.batch, highscoreLayout, Gdx.graphics.getWidth()/2 - highscoreLayout.width /2 + 30, Gdx.graphics.getHeight()/2);
		scoreFont.draw(game.batch, scoreLayout, Gdx.graphics.getWidth()/2 - scoreLayout.width /2, Gdx.graphics.getHeight()/2 -highscoreLayout.height- HEIGHT/2 - 30);

		
		game.batch.end();
		// TODO Auto-generated method stub
		
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

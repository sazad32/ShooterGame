package com.mygdx.game.screens;

import java.util.*; 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.game.BetaGame;
import com.mygdx.game.entities.Bullets;
import com.mygdx.game.entities.shootme;
import com.mygdx.game.tools.collision;

public class GameScreen implements Screen{
	public static final float SPEED = 300;
	public static final int GUNHEIGHT = 108; 
	public static final int GUNWIDTH = 158;
	
	public static final float MINMETIME = 0.5f;
	public static final float MAXMETIME = 0.6f;
	
	
	Random random;
	float meSpawnTime;
	Texture img;
	float x,y;
	BetaGame game;
	float health = 1;
	Texture blank;
	
	ArrayList<Bullets> bullet; 
	ArrayList<shootme> me;
	BitmapFont scoreFont;
	int score;
	
	collision playerRect;
	public GameScreen(BetaGame game){
		this.game = game;
		y = BetaGame.HEIGHT / 2 - GUNHEIGHT /2; 
		bullet = new ArrayList<Bullets>();
		me = new ArrayList<shootme>();
		scoreFont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
		random = new Random();
		meSpawnTime = random.nextFloat() * (MAXMETIME - MINMETIME) + MINMETIME;
		blank = new Texture("blank.png");
		playerRect = new collision(0, 0, GUNWIDTH, GUNHEIGHT);
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		img = new Texture("gun.png");
	}

	@Override
	public void render(float delta) {		
		
		//shooting
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
			bullet.add(new Bullets(x+150,y+70));			
		}
		
		meSpawnTime -= delta; 
		if(meSpawnTime <= 0){
			meSpawnTime = random.nextFloat() * (MAXMETIME - MINMETIME) + MINMETIME;
			me.add(new shootme(random.nextInt(BetaGame.HEIGHT - shootme.HEIGHT)));
		}
		ArrayList<shootme> meRemove = new ArrayList<shootme>();
		for(shootme i:me){
			i .update(delta);
			if(i.remove){
				meRemove.add(i);
			}
		}
		
		
		ArrayList<Bullets> bulletsToRemove = new ArrayList<Bullets>();
		for (Bullets bullets: bullet){
			bullets.update(delta);
			if(bullets.remove){
				bulletsToRemove.add(bullets);
			}			
		}
		
		//spawning me		
			
		
		
		
		//moving
		if(Gdx.input.isKeyPressed(Keys.UP)){
			y += SPEED * Gdx.graphics.getDeltaTime();
			if(y + GUNHEIGHT > Gdx.graphics.getBackBufferHeight()){
				y = Gdx.graphics.getBackBufferHeight() - GUNHEIGHT;
			}
		}if(Gdx.input.isKeyPressed(Keys.DOWN)){
			y -= SPEED * Gdx.graphics.getDeltaTime();
			if(y<0){
				y = 0;
			}
		}
		
		
		playerRect.move(x,y);
		
		//checking collision
		for(Bullets bullets: bullet){
			for(shootme i: me){
				if(bullets.getCollisionRect().collideswith(i.getCollisionRect())){							
					meRemove.add(i);
					bulletsToRemove.add(bullets);						
					score+=100;
					
				}
			}
			
		}bullet.removeAll(bulletsToRemove);
		me.removeAll(meRemove);
		
		for(shootme i: me){
			if(i.getCollisionRect().collideswith(playerRect)){
				meRemove.add(i);
				health -= 0.1;
				
				if(health <=0){
					this.dispose();
					game.setScreen(new gameOver(game, score));
					return;
				}
			}
		}me.removeAll(meRemove);
		
		

		Gdx.gl.glClearColor(1f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	
		
		
		game.batch.begin();
		GlyphLayout scoreLayout = new GlyphLayout(scoreFont, "" + score);
		scoreFont.draw(game.batch, scoreLayout, Gdx.graphics.getWidth()/2 - scoreLayout.width /2, Gdx.graphics.getHeight() - scoreLayout.height - 10);
		
		for (Bullets bullets: bullet){
			bullets.render(game.batch);
		}
		for (shootme i: me){
			i.render(game.batch);
		}
		
		if(health > 0.6f){
			game.batch.setColor(Color.GREEN);
		}
		else if(health > 0.2f){
			game.batch.setColor(Color.GOLD);
		}
		else{
			game.batch.setColor(Color.RED);
		}
		
		game.batch.draw(blank, 0,0, Gdx.graphics.getWidth() * health, 5);
		
		game.batch.setColor(Color.WHITE);
		
		game.batch.draw(img,x,y);
		
		
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

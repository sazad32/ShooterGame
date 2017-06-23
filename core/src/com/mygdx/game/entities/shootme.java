package com.mygdx.game.entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.BetaGame;
import com.mygdx.game.tools.collision;



public class shootme {
	public static final int SPEED = 1000;
	private static Texture texture;
	public static final int WIDTH = 32;
	public static final int HEIGHT = 32;
	float x,y;
	collision Rect;
	public boolean remove = false;
	
	public shootme(float y){
		this.x = BetaGame.WIDTH;
		this.y = y;
		this.Rect = new collision(x,y,WIDTH,HEIGHT);
		
		if(texture == null){
			texture = new Texture("me.png");		
		}
			
		
	}
	public void update(float deltaTime) {
		x -= SPEED * deltaTime;
		if (x <  -WIDTH){
			remove = true;
			
			
		}Rect.move(x,y);

	}
	public void render(SpriteBatch batch){
		batch.draw(texture, x, y, WIDTH, HEIGHT);
	}
	public collision getCollisionRect(){
		return Rect;
	}
}

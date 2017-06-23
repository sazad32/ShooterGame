package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.BetaGame;
import com.mygdx.game.tools.collision;

public class Bullets {
	
	public static final int SPEED = 1000;
	private static Texture texture;
	public static final int WIDTH = 3;
	public static final int HEIGHT = 12;
	float x,y;
	collision Rect;
	public boolean remove = false;
	
	public Bullets(float x, float y){
		this.x = x;
		this.y = y;
		
		this.Rect = new collision(x,y,WIDTH, HEIGHT); 
		
		if(texture == null){
			texture = new Texture("bullet.jpg");
		}
		
		}
	
	public void update(float deltaTime) {
		x += SPEED * deltaTime;
		if (x > BetaGame.WIDTH){
			remove = true;
			
		
		}Rect.move(x,y);
	}
	public void render (SpriteBatch batch) {
		batch.draw(texture, x, y, WIDTH,HEIGHT);
	}
	public collision getCollisionRect(){
		return Rect;
	}
	}
	



package com.mygdx.game.tools;

public class collision {
	float x,y;
	int width, height;
	
	public collision(float x, float y, int gunwidth, int gunheight){
		this.x = x;
		this.y = y;
		this.width = gunwidth;
		this.height = gunheight;
		
	}
	
	public void move (float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public boolean collideswith(collision rect){
		return x < rect.x + rect.width && y < rect.y + rect.height && x + width > rect.x && y + height > rect.y;
	}
}

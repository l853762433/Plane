package com.game.util;

import java.awt.image.BufferedImage;
import java.util.Random;

import com.game.main.Game;

public class Enemy extends Flyer {
	public Enemy(BufferedImage image,Integer x,Integer y) {
		// TODO Auto-generated constructor stub
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.speed = new Random().nextInt(10)+20;
	}
	@Override
	public void stepMove() {
		// TODO Auto-generated method stub
		this.y += speed;
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		boolean result = false;
		if(this.y>=Game.bgHeight){
			result = true;
		}
		return result;
	}
	
}

package com.game.util;

import java.awt.image.BufferedImage;

public class Bullet extends Flyer {
	public Hero hero;
	public Bullet(BufferedImage image,Integer x,Integer y,Hero hero) {
		// TODO Auto-generated constructor stub
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.speed = hero.speed*2;
		this.hero = hero;
	}
	@Override
	public void stepMove() {
		// TODO Auto-generated method stub
		this.y -= speed;
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		boolean result = false;
		if(this.y<=-this.height){
			result = true;
		}
		return result;
	}

}

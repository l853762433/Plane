package com.game.util;

import java.awt.image.BufferedImage;

import com.game.main.Game;

public class Hero extends Flyer {
	public char fangxiang;
	public Hero(BufferedImage image,Integer x,Integer y) {
		// TODO Auto-generated constructor stub
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.speed = 20;
	}

	@Override
	public void stepMove() {
		// TODO Auto-generated method stub
		switch (fangxiang) {
		case 'w':
			this.y -= speed;
			break;
		case 'a':
			this.x -= speed;
			break;
		case 's':
			this.y += speed;
			break;
		case 'd':
			this.x += speed;
			break;

		default:
			break;
		}
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		boolean result = true;
		if(this.y<0){
			this.y = 0;
		}else if(this.y>Game.bgHeight-this.height){
			this.y = Game.bgHeight-this.height;
		}else if(this.x<0){
			this.x = 0;
		}else if(this.x>Game.bgWidth-this.width){
			this.x = Game.bgWidth-this.width;
		}else{
			result = false;
		}
		return result;
	}
	public void shoot(){
		BufferedImage zd = Game.bulletImg;
		Bullet b = new Bullet(zd, this.x+(this.width-zd.getWidth())/2, this.y-zd.getHeight(), this);
		Game.bullets.add(b);
	}

}

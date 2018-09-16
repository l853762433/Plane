package com.game.util;

import java.awt.image.BufferedImage;

public abstract class Flyer {
	public Integer width;
	public Integer height;
	public Integer x;
	public Integer y;
	public Integer speed;
	public BufferedImage image;
	
	public abstract void stepMove();
	public abstract boolean outOfBounds();
	public boolean beShoot(Flyer flyer){
		boolean result = false;
		if(this.y<flyer.y+flyer.height&&this.y>flyer.y-this.height&&this.x>flyer.x-this.width&&this.x<flyer.x+flyer.width){
			result = true;
		}
		return result;
	}

}

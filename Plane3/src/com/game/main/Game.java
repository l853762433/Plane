package com.game.main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.game.util.Bullet;
import com.game.util.Enemy;
import com.game.util.Flyer;
import com.game.util.Hero;
public class Game extends JPanel implements KeyListener,ActionListener {
	public static BufferedImage bgImg;
	public static Integer bgWidth;
	public static Integer bgHeight;
	public static BufferedImage heroImg;
	public static Hero hero;
	public static final Integer toolHeight = 30;
	public static ArrayList<Bullet> bullets;
	public static ArrayList<Enemy> enemies;
	public static BufferedImage bulletImg;
	public Timer timer = new Timer(100, this);
	public static BufferedImage enemyImg;
	
	static{
		try {
			bgImg = ImageIO.read(new File("images/bg.jpg"));
			bgWidth = bgImg.getWidth();
			bgHeight = bgImg.getHeight();
			heroImg = ImageIO.read(new File("images/plane.png"));
			hero = new Hero(heroImg, (bgWidth-heroImg.getWidth())/2, bgHeight-heroImg.getHeight());
			bullets = new ArrayList<Bullet>();
			enemies = new ArrayList<Enemy>();
			bulletImg = ImageIO.read(new File("images/zd.png"));
			enemyImg = ImageIO.read(new File("images/enemy.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bgImg, 0, 0, null);
		g.drawImage(hero.image, hero.x, hero.y, null);
		hero.stepMove();
		hero.outOfBounds();
		
		ArrayList<Flyer> outFlyers = new ArrayList<Flyer>();
		for (Bullet bullet : bullets) {
			g.drawImage(bullet.image, bullet.x, bullet.y, null);
			bullet.stepMove();
			if(bullet.outOfBounds()){
				outFlyers.add(bullet);
			}
		}
		bullets.removeAll(outFlyers);
		outFlyers.clear();
		for (Enemy e : enemies) {
			g.drawImage(e.image, e.x, e.y, null);
			e.stepMove();
			if(e.outOfBounds()){
				outFlyers.add(e);
			}
		}
		enemies.removeAll(outFlyers);
		ArrayList<Flyer> hitZds = new ArrayList<Flyer>();
		ArrayList<Flyer> hitEnemies = new ArrayList<Flyer>();
		for (Enemy e : enemies) {
			for (Bullet bullet : bullets) {
				if(e.beShoot(bullet)){
					hitZds.add(bullet);
					hitEnemies.add(e);
				}
			}
			if(e.beShoot(hero)){
				hitEnemies.add(e);
			}
		}
		bullets.removeAll(hitZds);
		enemies.removeAll(hitEnemies);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(new Random().nextInt(5)<3){
			hero.shoot();
		}
		createEnemy();
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		hero.fangxiang = e.getKeyChar();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		hero.fangxiang = ' ';
	}
	
	public void start(){
		this.addKeyListener(this);
		this.setFocusable(true);
		timer.start();
	}
	
	public void createEnemy(){
		if(new Random().nextInt(5)<3){
			Enemy enemy = new Enemy(enemyImg, new Random().nextInt(bgWidth-enemyImg.getWidth()), -enemyImg.getHeight());
			enemies.add(enemy);
		}
	}
}

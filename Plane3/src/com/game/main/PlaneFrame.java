package com.game.main;

import javax.swing.JFrame;

public class PlaneFrame {
	public static void main(String[] args){
		Game game = new Game();
		game.start();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setSize(Game.bgWidth, Game.bgHeight+Game.toolHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

/*
 * World.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Village;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;


public class World extends JPanel{

	int w;
	int h;

	// Zone de nourritures disponibles dans le monde
	ArrayList<Point> foodZones;
	int foodQuantity=50;
	/** 
	 * Constructeur de la classe World 
	 */
	public World(int w, int h) {
		this.w = w;
		this.h = h;
		foodZones=new ArrayList<>();
		// food initialisation (randomly)
		for (int i=0; i<foodQuantity; i++) {
			Point p= new Point();
			double x = Math.random()*(w-0);
			double y = Math.random()*(h-2);
			p.x = (int)x ;
			p.y = (int)y ;
			foodZones.add(p);
		}

	}
	

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}
	
	public boolean isFood(int x, int y) {
		for (int i=0; i<foodQuantity; i++) {
			if (foodZones.get(i).x==x && foodZones.get(i).y==y)
				return true;
		}
		return false;

	}
	
	public boolean eatFood(int x, int y) {
		int d=-1;
		for (int i=0; i<foodQuantity; i++) {
			Rectangle RAnt = new Rectangle(x,y,10,10);
			Rectangle RFood = new Rectangle(foodZones.get(i).x, foodZones.get(i).y,10,10);

			if (RAnt.intersects(RFood))		
				d=i;
		}
		if (d!=-1) {
			foodZones.remove(d);
			foodQuantity--;
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Methode d'affichage de la zone
	 */
	@Override
	public void paint(Graphics g) { 
		
		// Drawing food zones
		for (int i=0; i<foodQuantity; i++) {
			Point p= new Point();
			g.setColor(Color.BLUE);
			g.fillRect(foodZones.get(i).x,foodZones.get(i).x,10,10);
		}


	} 
}

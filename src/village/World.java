/*
 * World.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


public class World extends JPanel{

	int w;
	int h;

	// Zone de nourritures disponibles dans le monde
	ArrayList<Point> preyZones;
        ArrayList<Point> woodZones;
        Village village;
        
        int preyQuantity=50;
        int woodQuantity=50;
	/** 
	 * Constructeur de la classe World 
	 */
	public World(int w, int h) {
                this.w = w;
		this.h = h;
                
                // Village initialisation
                village = new Village(0,0,450,450);
                
                // Prey and Wood initialisation
                initializePrey();
                initializeWood();
            

	}
       
        
	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}
        
        public Village getVillage() {
                return village;
        }
        
        public void initializePrey(){
                preyZones=new ArrayList<>();
		for (int i=0; i<preyQuantity; i++) {
			Point p= new Point();
                        
                        int minX= this.getVillage().getX()+this.getVillage().getW();
                        int maxX= this.w;
                        int minY= this.getVillage().getY()+this.getVillage().getH();
                        int maxY= this.h;
                               
                        Random r = new Random();
			double x = r.nextInt(maxX-minX) + minX;
			double y = r.nextInt(maxY-minY) + minY;
                        
			p.x = (int)x ;
			p.y = (int)y ;
			preyZones.add(p);
		}
        }
        
        public void initializeWood(){
                woodZones=new ArrayList<>();
		for (int i=0; i<woodQuantity; i++) {
			Point p= new Point();
                        
                        int minX= this.getVillage().getX()+this.getVillage().getW();
                        int maxX= this.w;
                        int minY= this.getVillage().getY()+this.getVillage().getH();
                        int maxY= this.h;
                               
                        Random r = new Random();
			double x = r.nextInt(maxX-minX) + minX;
			double y = r.nextInt(maxY-minY) + minY;
                        
			p.x = (int)x ;
			p.y = (int)y ;
			woodZones.add(p);
		}
        }
        
	
	public boolean isWood(int x, int y) {
                for (int i=0; i<woodQuantity; i++) {
			if (woodZones.get(i).x==x && woodZones.get(i).y==y)
				return true;
		}
		return false; 
            
	}
        
        
        public boolean isPrey(int x, int y) {
              for (int i=0; i<preyQuantity; i++) {
			if (preyZones.get(i).x==x && preyZones.get(i).y==y)
				return true;
		}
		return false;  
            
	}
	
	public void huntPrey(int x, int y) {
		int d=-1;
		for (int i=0; i<preyQuantity; i++) {
			Rectangle RAnt = new Rectangle(x,y,10,10);
			Rectangle RFood = new Rectangle(preyZones.get(i).x, preyZones.get(i).y,10,10);

			if (RAnt.intersects(RFood))		
				d=i;
		}
		if (d!=-1) {
			preyZones.remove(d);
			preyQuantity--;
		}
	}
        
        public void cutWood(int x, int y) {
		int d=-1;
		for (int i=0; i<woodQuantity; i++) {
			Rectangle RAnt = new Rectangle(x,y,10,10);
			Rectangle RFood = new Rectangle(woodZones.get(i).x, woodZones.get(i).y,10,10);

			if (RAnt.intersects(RFood))		
				d=i;
		}
		if (d!=-1) {
			woodZones.remove(d);
			woodQuantity--;
		}
	}

	/**
	 * Methode d'affichage de la zone
	 */
	@Override
	public void paint(Graphics g) { 
		
                // Drawing Prey zones
		for (int i=0; i<preyQuantity; i++) {
			Point p= new Point();
			g.setColor(Color.BLUE);
			g.fillRect(preyZones.get(i).x,preyZones.get(i).y,10,10);
		}
                
                // Drawing Wood zones
		for (int i=0; i<woodQuantity; i++) {
			Point p= new Point();
			g.setColor(Color.ORANGE);
			g.fillRect(woodZones.get(i).x,woodZones.get(i).y,10,10);
		}
		
		/*
		Point p_village = new Point();
		g.setColor(Color.BLUE);
		g.fillRect(village.getX(),village.getY(),village.getW(),village.getH());
                
                Point p_WoodStorage = new Point();
		g.setColor(Color.RED);
		g.fillRect(village.getFoodStorage().getX(),village.getFoodStorage().getY(),village.getFoodStorage().getW(),village.getFoodStorage().getH());
                
                Point p_FoodStorage = new Point();
		g.setColor(Color.ORANGE);
		g.fillRect(village.getWoodStorage().getX(),village.getWoodStorage().getY(),village.getWoodStorage().getW(),village.getWoodStorage().getH());
                */
	} 

}
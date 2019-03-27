/*
 * World.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package village;

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
	ArrayList<Point> preyZones;
        ArrayList<Point> woodZones;
        Village village;
        
        int preyQuantity;
        int woodQuantity;
	/** 
	 * Constructeur de la classe World 
	 */
	public World(int w, int h) {


	}
	

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}
	
	public boolean isWood(int x, int y) {

            
	}
        
        
        public boolean isPrey(int x, int y) {

            
	}
	
	public boolean huntPrey(int x, int y) {
		
	}
        
        public boolean cutWood(int x, int y) {
		
	}

	/**
	 * Methode d'affichage de la zone
	 */
	@Override
	public void paint(Graphics g) { 
		

	} 
}

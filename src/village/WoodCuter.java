
// Package
///////////////
package ants;


// Imports
///////////////

import jade.core.Agent;

import jade.core.behaviours.CyclicBehaviour;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class WoodCuter extends Agent {

 
	double x;
	double y;
        int minX;
        int maxX;
        int minY;
        int maxY;
                                
	private static World leMonde = APIMonde.getMonde();



	@Override
	protected void setup() {
		try {
                        minX= leMonde.getVillage().getX();
                        maxX= leMonde.getVillage().getX()+leMonde.getVillage().getW();
                        minY= leMonde.getVillage().getY();
                        maxY= leMonde.getVillage().getY()+leMonde.getVillage().getH();
			// Create a random position for the ant
			// initialize Position
                               
                        Random r = new Random();
			x = r.nextInt(maxX-minX) + minX;
			y = r.nextInt(maxY-minY) + minY;





			addBehaviour( new CyclicBehaviour( this ) {
				public void action() {
                                    erase();
                                    moveRandomly();
                                    draw();
                                    
                                    
                                    
				}
			} );
		}
		catch (Exception e) {
			System.out.println( "Saw exception in Ant agent: " + e );
			e.printStackTrace();
		}

	}


	// Internal implementation methods
	//////////////////////////////////



	protected void draw() {
		Graphics g = leMonde.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 10, 10);
		try{
			Thread.sleep (100);
		}catch (Exception e){

		}
		leMonde.paint(g);

	}

	protected void erase() {
		Graphics g = leMonde.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, 10, 10);
		leMonde.paint(g);
	}

	protected void moveRandomly() {
            
                double dirx = Math.random() ;
		double diry = Math.random() ;

		if (dirx>0.5) {
			x=x+(dirx+1);
		} else x=x-1;

		if (diry>0.5) {
			y=y+(diry+1);
		} else y=y-1;
            
	}

	protected void cutIfPossible() {


		
	}
        
        protected void leaveVillage(){
            
        }
        
        protected void searchWood(){
            
        }
        
        protected void backToVillage(){
            
        }
        
        protected void storeFood(){
            
        }
            

}

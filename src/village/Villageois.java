
// Package
///////////////
package village;


// Imports
///////////////

import jade.core.Agent;

import jade.core.behaviours.CyclicBehaviour;

import java.awt.Color;
import java.awt.Graphics;

public class Villageois extends Agent {

 
	double x;
	double y;
	private static World leMonde = APIMonde.getMonde();



	@Override
	protected void setup() {
		try {

			// Create a random position for the ant
			// initialize Position

			x = Math.random() * ( leMonde.getWidth() );
			y = Math.random() * ( leMonde.getHeight()  );





			addBehaviour( new CyclicBehaviour( this ) {
				public void action() {
                                    
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
		g.setColor(Color.RED);
		g.drawRect((int)x, (int)y, 10, 10);
		try{
			Thread.sleep (100);
		}catch (Exception e){

		}
		leMonde.paint(g);

	}

	protected void erase() {
		Graphics g = leMonde.getGraphics();
		g.setColor(Color.WHITE);
		g.drawRect((int)x, (int)y, 10, 10);
		leMonde.paint(g);
	}

	

        
        
       protected boolean checkStorage(){
		int foodQuantity = leMonde.getVillage().getFoodStorage().foodQuantity;
		int woodQunatity = leMonde.getVillage().getWoodStorage().woodQuantity;
		if(foodQuantity == 50 && woodQunatity == 50) {
			return true;
		} else {
			return false;
		}
           
       }
       
       protected void createAgent(){
		if(checkStorage()) {
			Villageois villageois = new Villageois();
		}
           
       }
       
       protected void clearStorage(){
		   leMonde.getVillage().getFoodStorage().foodQuantity = 0;
		   leMonde.getVillage().getWoodStorage().woodQuantity = 0;

       }
       
       
       
       
            

}

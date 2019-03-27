
// Package
///////////////
package Village;


// Imports
///////////////

import jade.core.Agent;

import jade.core.behaviours.CyclicBehaviour;

import java.awt.Color;
import java.awt.Graphics;


public class Ant extends Agent {


	double x;
	double y;
	int xb = 1;
	int yb = 1;
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

					erase();
					moveRandomly();
					//eatIfPossible();
					draw();
					/*try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/

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

	protected void moveRandomly() {
		int X = (int)x;
		int Y = (int)y;
		if(!eatIfPossible()) {//S'il ne trouve pas de nourriture, il se déplace linéarement
			if (X == 0 ){
				xb = 1;
			}
			if(X == leMonde.getWidth()) {//La fourmis ne dépasse pas le cadre
				xb = -1;
			}
			x += xb;

			if (Y == 0 ){
				yb = 1;
			}
			if(Y == leMonde.getHeight()) {//La fourmis ne dépasse pas le cadre
				yb = -1;
			}
			y += yb;
		}
		else {//La fourlis trouve la nourriture et commence le déplacement aléatoire
			double dirx = Math.random() ;
			double diry = Math.random() ;
			System.out.println("random");
			if (dirx>0.5) {
				x=x+(dirx+1);
			} else x=x-1;

			if (diry>0.5) {
				y=y+(diry+1);
			} else y=y-1;

		}

	}

	protected boolean eatIfPossible() {

		if(leMonde.eatFood((int)this.x, (int)this.y)){
			System.out.println("eat");
			return true;
		}
		return false;
		
	}


}

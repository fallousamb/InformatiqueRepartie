
// Package
///////////////
package village;


// Imports
///////////////

import jade.core.Agent;

import jade.core.behaviours.CyclicBehaviour;

import java.awt.Color;
import java.awt.Graphics;

public class Bucheron extends AgentOfVillage {


    double x;
    double y;
    private static World leMonde = APIMonde.getMonde();


    @Override
    protected void setup() {
        try {

            // Create a random position for the ant
            // initialize Position

            x = Math.random() * (leMonde.getWidth());
            y = Math.random() * (leMonde.getHeight());


            addBehaviour(new CyclicBehaviour(this) {
                public void action() {
                    erase();
                    moveRandomly();
                    if(cutIfPossible()){
                        backToVillage();
                        storeWood();
                    }
                    draw(Color.blue);
                }
            });
        } catch (Exception e) {
            System.out.println("Saw exception in Ant agent: " + e);
            e.printStackTrace();
        }

    }


    // Internal implementation methods
    //////////////////////////////////

    protected boolean cutIfPossible() {
       return leMonde.cutWood((int) x, (int) y);
    }

    protected void searchWood() {

    }

    protected void storeWood() {
        leMonde.getVillage().woodStorage.woodQuantity++;

    }


}

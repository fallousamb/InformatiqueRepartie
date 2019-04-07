
// Package
///////////////
package village;


// Imports
///////////////

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

import java.awt.*;

public class Chasseur extends AgentOfVillage {

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
                    if (huntIfPossible()) {
                        backToVillage();
                        storeFood();
                    }
                    draw(Color.RED);

                }
            });
        } catch (Exception e) {
            System.out.println("Saw exception in Ant agent: " + e);
            e.printStackTrace();
        }

    }


    protected boolean huntIfPossible() {
        if (leMonde.huntPrey((int) this.x, (int) this.y)) { //Le chasseur a attrapé une proie
            return true;
        }
        return false;
    }


    protected void searchPrey() {

    }


    /**
     * Cette méthode incrémente la quantité de nourriture dans le village
     */
    protected void storeFood() {
        //On incrémente la quantité de nourriture
        leMonde.village.getFoodStorage().foodQuantity++;

    }



}

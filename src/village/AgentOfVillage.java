package village;

import jade.core.Agent;

import java.awt.*;

public class AgentOfVillage extends Agent {
    double x;
    double y;
    private static World leMonde = APIMonde.getMonde();

    public static World getLeMonde() {
        return leMonde;
    }

    protected void draw(Color color) {
        Graphics g = leMonde.getGraphics();
        g.setColor(color);
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
        int X = (int) x;
        int Y = (int) y;
        double dirx = Math.random();
        double diry = Math.random();
        if (dirx > 0.5) {
            x = x + (dirx + 1);
        } else {
            x = x - 1;
        }
        if (diry > 0.5) {
            y = y + (diry + 1);
        } else y = y - 1;

    }

    protected void leaveVillage(){
        Village village = leMonde.getVillage();
        Point exitVillage = village.getExitVillage();
        mooveLinearly(exitVillage);
        /*while (x < exitVillage.x) {
            x++;
        }
        while (x > exitVillage.x) {
            x--;
        }

        while(y < exitVillage.y) {
            y++;
        }

        while (y > exitVillage.y) {
            y--;
        }*/
    }


    /**
     *
     * @return true si le chasseur est en dehors du village
     */
    public boolean isOutOfVillage() {
        Village village = leMonde.getVillage();
        int x1 = village.getX();
        int x2 = village.getX() + village.getW();
        int y1 = village.getY();
        int y2 = village.getY() + village.getH();
        if (x > x1 && x < x2 && y > y1 && y < y2) {
            return false;
        }

        return true;
    }

    protected void backToVillage(){
        Village village = leMonde.getVillage();
        Point exitVillage = village.getExitVillage();
        if(this.isOutOfVillage()) {//Le chasseur est en dehors du village
				/*Point coordonneesChasseur = new Point((int) this.x, (int)this.y);
				while (!coordonneesChasseur.equals(exitVillage)) {
					if (coordonneesChasseur.x < exitVillage.x) {
						coordonneesChasseur.x++;
					} else {
						coordonneesChasseur.x--;
					}
					if (coordonneesChasseur.y < exitVillage.y) {
						coordonneesChasseur.y++;
					} else {
						coordonneesChasseur.y--;
					}
				}*/
            mooveLinearly(exitVillage);
        }

    }

    /**
     *
     * @param target
     */
    private void mooveLinearly(Point target) {
        Point hunterPosition = new Point((int)x, (int)y);
        while (!hunterPosition.equals((Point)hunterPosition)) {
            hunterPosition.x = (hunterPosition.x < target.x)?hunterPosition.x++:hunterPosition.x--;
            hunterPosition.y = (hunterPosition.y < target.y)?hunterPosition.y++:hunterPosition.y--;
        }
    }

}

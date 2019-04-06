/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ants;

import java.awt.Point;

/**
 *
 * @author nikhlef
 */
public class Village {
    
    int h;
    int w;
    int x;
    int y;
    
    FoodStorage foodStorage;
    WoodStorage woodStorage;
    
    Point exitVillage;
    
    public Village(int x, int y, int w, int h) {
        this.h = h;
        this.w = w;
        this.x = x;
        this.y = y;
        
        exitVillage= new Point(x+w,y/2);
        
        foodStorage = new FoodStorage(x+15,y+15,200,200);
        woodStorage= new WoodStorage(x+230,y+15,200,200);
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public FoodStorage getFoodStorage() {
        return foodStorage;
    }

    public WoodStorage getWoodStorage() {
        return woodStorage;
    }
    
    
    
}

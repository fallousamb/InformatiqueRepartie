/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package village;

import java.awt.*;

/**
 *
 * @author nikhlef
 */
public class Village {
    
    int h;
    int w;
    int x;
    int y;
    Point exitVillage;
    FoodStorage foodStorage;
    WoodStorage woodStorage;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public FoodStorage getFoodStorage() {
        return foodStorage;
    }

    public void setFoodStorage(FoodStorage foodStorage) {
        this.foodStorage = foodStorage;
    }

    public WoodStorage getWoodStorage() {
        return woodStorage;
    }

    public void setWoodStorage(WoodStorage woodStorage) {
        this.woodStorage = woodStorage;
    }

    public Point getExitVillage() {
        return exitVillage;
    }

    public void setExitVillage(Point exitVillage) {
        this.exitVillage = exitVillage;
    }
}

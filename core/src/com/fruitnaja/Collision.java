package com.fruitnaja;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by nutno on 17/4/2560.
 */
public class Collision {
    public boolean intersection,top,buttom,left,right;

    public Collision() {
    }

    public Collision(boolean top, boolean buttom, boolean left, boolean right) {
        this.top = top;
        this.buttom = buttom;
        this.left = left;
        this.right = right;
    }

    public Collision(boolean intersection) {
        this.intersection = intersection;
    }

    public static Collision isCollision(Rectangle char_rect, Rectangle [][] obj_rect){
        Rectangle top,buttom,left,right;
        boolean tst=false,coll_buttom = false,coll_top = false,coll_left= false,coll_right = false;
        top = new Rectangle(char_rect.getX(),char_rect.getY()+32,48,2);
        buttom = new Rectangle(char_rect.getX(),char_rect.getY()-2,48,2);
        left = new Rectangle(char_rect.getX()-2,char_rect.getY(),2,32);
        right = new Rectangle(char_rect.getX()+48,char_rect.getY(),2,32);

        for (Rectangle[] x:obj_rect) {
            for (Rectangle y:x) {
                tst = Intersector.overlaps(char_rect,y);
                coll_top = Intersector.overlaps(top,y);
                coll_buttom = Intersector.overlaps(buttom,y);
                coll_left = Intersector.overlaps(left,y);
                coll_right = Intersector.overlaps(right,y);
                if(tst==true){
                    return new Collision(coll_top,coll_buttom,coll_left,coll_right);
                }
            }
        }
        //System.out.println("TST: "+tst+" T: "+coll_top+" B: "+coll_buttom+" L: "+coll_left+" R: "+coll_right);
        return new Collision(coll_top,coll_buttom,coll_left,coll_right);
    }


    public static boolean isCollision(Rectangle[][] decorator_rect, Rectangle fruit_rect){
        boolean tst;
        for (Rectangle[] x:decorator_rect) {
            for (Rectangle y:x) {
                tst = Intersector.overlaps(fruit_rect,y);
                if(tst==true){
                    return true;
                }
            }
        }
        return false;

    }
}
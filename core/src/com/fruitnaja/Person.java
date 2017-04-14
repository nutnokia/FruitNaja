package com.fruitnaja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by user on 9/4/2560.
 */
public abstract class Person implements Attackable {
    //private String name;
    private int hp;
    private int stamina;
    private Vector2 pos;
    private  boolean live;
    private static int idS = 0;
    private int id;
    ArrayList<Fruit> checkFruit = new ArrayList<Fruit>();
    ArrayList<Weapon> checkWeapon = new ArrayList<Weapon>();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public static int getIdS() {
        return idS;
    }

    public static void setIdS(int idS) {
        Person.idS = idS;
    }

    public Person(int hp, int stamina) {
        //this.name = name;
        this.hp = hp;
        this.stamina = stamina;
        this.pos = new Vector2(512/2,300/2);
        this.live = true;
        this.id = id;
        this.idS += 1;
    }



    public void move(){
        if((Gdx.input.isKeyPressed(Input.Keys.LEFT)||Gdx.input.isKeyPressed(Input.Keys.A))&&pos.x>0){
            pos.x-=100*Gdx.graphics.getDeltaTime();
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)||Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            pos.x+=100*Gdx.graphics.getDeltaTime();
        }
        else if ((Gdx.input.isKeyPressed(Input.Keys.W)||Gdx.input.isKeyPressed(Input.Keys.UP))){
            pos.y+=100*Gdx.graphics.getDeltaTime();
        }
        else if ((Gdx.input.isKeyPressed(Input.Keys.S)||Gdx.input.isKeyPressed(Input.Keys.DOWN))&&pos.y>0){
            pos.y-=100*Gdx.graphics.getDeltaTime();
        }
    }

    public void die(){
        if (hp==0){
            System.out.println("You Die");
            this.live = false;
        }
    }

    public void attack(){

    }

    public abstract void useSkill();


}

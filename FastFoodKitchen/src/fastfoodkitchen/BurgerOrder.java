/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodkitchen;

/**
 *
 * @author Tyler Foeller
 * 
 * This class is used to store information on burger orders
 */
public class BurgerOrder {
    //Fields
    private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieBurgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum = 101;

    //Constructors
    public BurgerOrder(int ham, int cheese, int veggie, int soda, boolean toGo, int order) {
        numHamburgers = ham;
        numCheeseburgers = cheese;
        numVeggieBurgers = veggie;
        numSodas = soda;
        orderToGo = toGo;
        orderNum = order;
    }
    
    //Getters
    public int getNumHamburgers() {
        return numHamburgers;
    }

    public int getNumCheeseburgers() {
        return numCheeseburgers;
    }

    public int getNumVeggieBurgers() {
        return numVeggieBurgers;
    }
    
    public int getNumBurgers() {
        return numHamburgers + numCheeseburgers + numVeggieBurgers;
    }

    public int getNumSodas() {
        return numSodas;
    }

    public boolean isOrderToGo() {
        return orderToGo;
    }

    public int getOrderNum() {
        return orderNum;
    }

    //Setters
    public void setNumHamburgers(int numHamburgers) {
        this.numHamburgers = numHamburgers;
    }

    public void setNumCheeseburgers(int numCheeseburgers) {
        this.numCheeseburgers = numCheeseburgers;
    }

    public void setNumVeggieBurgers(int numVeggieBurgers) {
        this.numVeggieBurgers = numVeggieBurgers;
    }

    public void setNumSodas(int numSodas) {
        this.numSodas = numSodas;
    }

    public void setOrderToGo(boolean orderToGo) {
        this.orderToGo = orderToGo;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    
    //toString
    @Override
    public String toString() {
        return "BurgerOrder{" + "numHamburgers=" + numHamburgers + ", numCheeseburgers=" + numCheeseburgers + ", numVeggieBurgers=" + numVeggieBurgers + ", numSodas=" + numSodas + ", orderToGo=" + orderToGo + ", orderNum=" + orderNum + '}';
    }
    
    
}

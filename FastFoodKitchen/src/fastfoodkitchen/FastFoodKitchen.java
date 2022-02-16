/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fastfoodkitchen;

import java.util.*;

/**
 *
 * @author Tyler Foeller
 */
public class FastFoodKitchen {
    //Fields
    private ArrayList<BurgerOrder> orderList = new ArrayList<BurgerOrder>();
    private static int nextOrderNum;

    //Constructors
    public FastFoodKitchen() {
        nextOrderNum = 101;
        orderList.add(new BurgerOrder(3,5,4,10,false,nextOrderNum));
        incrementOrderNum();
        orderList.add(new BurgerOrder(0,0,3,3,true,nextOrderNum));
        incrementOrderNum();
        orderList.add(new BurgerOrder(1,1,0,2,false,nextOrderNum));
    }
    
    
    //Getters
    public static int getNextOrderNum() {
        return nextOrderNum;
    }
    
    //ToString

    @Override
    public String toString() {
        return "FastFoodKitchen{" + "orderList=" + orderList + '}';
    }
    
    
    /**
     * IncrementOrderNum
     * 
     * method increases the order number
     */
    private static void incrementOrderNum() {
        nextOrderNum += 1;
    }
    
    /**
     * AddOrder
     * 
     * This method creates a new burgerOrder, adds it to the orderList, and returns the order number
     * 
     * @param ham number of hamburgers ordered
     * @param cheese number of cheeseburgers ordered
     * @param veggie number of veggie burgers ordered
     * @param soda number of sodas ordered
     * @param toGo boolean to determine if the order is to go
     * 
     * @return order number
     */
    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
        
        incrementOrderNum();
        int order = nextOrderNum;
        
        BurgerOrder newOrder = new BurgerOrder(ham,cheese,veggie,soda,toGo,order);
        orderList.add(newOrder);
        
        return order;
    }
    
    /**
     * CancelLastOrder
     * 
     * This method cancels the last order placed, and returns false if there are no orders in orderList
     * 
     * @return wether or not the order was cancelled
     */
    public boolean cancelLastOrder() {
        if (orderList.isEmpty()) {
            return false;
        }
        else {
            orderList.remove(orderList.size() - 1);
            nextOrderNum -= 1;
            return true;
        }
    }
    
    /**
     * GetNumOrdersPending
     * 
     * This method checks the size of orderList and returns the size
     * 
     * @return number of orders pending in orderList
     */
    public int getNumOrdersPending() {
        return orderList.size();
    }
    
    /**
     * IsOrderDone
     * 
     * This method checks by orderID whether or not the order is in orderList
     * 
     * @param orderId the order id number
     * 
     * @return boolean of wether or not the order is in orderList
     */
    public boolean isOrderDone(int orderID) {
        int orderIndex = -1;
        
        for (int i = 0; i < orderList.size();i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                orderIndex = i;
            }
        }
        
        if (orderIndex >= 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * CancelOrder
     * 
     * This method searches the orderList for a burgerOrder with the order number of orderID
     * 
     * @param orderId order Id number
     * 
     * @return boolean of whether or not the order was cancelled
     */
    public boolean cancelOrder(int orderID) {
        boolean orderCancelled = false;
        
        for (int i = 0; i < orderList.size();i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                orderList.remove(i);
                orderCancelled = true;
            }
        }
        
        return orderCancelled;
    }
    
    /**
     * FindOrderSeq
     * 
     * This method searchers orderList for a given orderID using a sequential and returns the index of where it is at
     * 
     * @param orderID
     * 
     * @return index of order
     */
    public int findOrderSeq(int orderID) {
        int order = 0;
        while (!(order >= orderList.size())){
            if (orderList.get(order).getOrderNum() == orderID) {
                return order;
            }
            order++;
        }
        
        return -1;
    }
    
    /**
     * FindOrderBin
     * 
     * This method searchers orderList for a given orderID using a Binary search and returns the index of where it is at
     * 
     * @param orderID
     * 
     * @return index of order
     */
    public int findOrderBin(int orderID) {
        int left = 0;
        int right = orderList.size() - 1;
        
        while (left <= right) {
            int middle = (left + right) / 2;
            
            if (orderList.get(middle).getOrderNum() < orderID) {
                right = middle - 1;
            }
            else if (orderList.get(middle).getOrderNum() > orderID) {
                left = middle + 1;
            }
            else {
                return middle;
            }
        }
        
        return -1;
    }
    
    /**
     * selectionSort
     * 
     * this method sorts orderList using the selection sort method by the number of total burgers 
     */
    public void selectionSort() {
         for (int i = 0; i < orderList.size(); i++) {
             int minIndex = i;
             for (int j = i + 1; j < orderList.size(); j++) {
                 
                 if (orderList.get(j).getNumBurgers()< orderList.get(minIndex).getNumBurgers()) {
                     minIndex = j;
                 }
             }
             BurgerOrder temp = orderList.get(i);
             orderList.add(i,orderList.get(minIndex));
             orderList.remove(minIndex+1);
             orderList.add(minIndex, temp);
             orderList.remove(i+1);
         }
    }
    
    /**
     * insertionSort
     * 
     * this method sorts orderList using the insertion sort method by the number of total burgers 
     */
    public void insertionSort() {
        for (int i = 1; i < orderList.size(); i++) {
            BurgerOrder temp = orderList.get(i);
            int possibleIndex = i;
            
            while (possibleIndex > 0 && temp.getNumBurgers() < orderList.get(possibleIndex - 1).getNumBurgers()) {
                orderList.add(possibleIndex,orderList.get(possibleIndex - 1));
                orderList.remove(possibleIndex - 1);
                possibleIndex--;
            }
            
            orderList.add(possibleIndex,temp);
            orderList.remove(i+1);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // PartA toString Test
        /**BurgerOrder order1 = new BurgerOrder(3,5,4,10,false,101);
        BurgerOrder order2 = new BurgerOrder(0,0,3,3,true,102);
        BurgerOrder order3 = new BurgerOrder(1,1,0,2,false,103);
        
        order1.setNumSodas(12);
        order3.setOrderToGo(true);
        
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        */
        
        //PartB
        //copied from https://gist.github.com/nanajjar/c9ee149e05886d7694bafb397798b8e5 as instructed to
        /**FastFoodKitchen kitchen = new FastFoodKitchen();
        Scanner sc = new Scanner(System.in);
        // see what the user wants to do
        System.out.println("Please select from the following menu of options, by typing a number:");
        System.out.println("\t 1. Order food");
        System.out.println("\t 2. Cancel last order");
        System.out.println("\t 3. Cancel specfic order");//Part C
        System.out.println("\t 4. Show number of orders currently pending");
        System.out.println("\t 5. Find certain order status");//Part C
        System.out.println("\t 6. Exit");

        int num = sc.nextInt();
        switch (num) {
        case 1:
            System.out.println("How many hamburgers do you want?");
            int ham = sc.nextInt();
            System.out.println("How many cheeseburgers do you want?");
            int cheese = sc.nextInt();
            System.out.println("How many veggieburgers do you want?");
            int veggie = sc.nextInt();
            System.out.println("How many sodas do you want?");
            int sodas = sc.nextInt();
            System.out.println("Is your order to go? (Y/N)");
            char letter = sc.next().charAt(0);
            boolean TOGO = false;
            if (letter == 'Y' || letter == 'y') {
                TOGO = true;
            }
            int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
            System.out.println("Thank-you. Your order number is " + orderNum);
            System.out.println();
            break;
        case 2:   
            boolean ready = kitchen.cancelLastOrder();
            if (ready) {
                System.out.println("Thank you. The last order has been canceled");
            } else {
                System.out.println("Sorry. There are no orders to cancel.");
            }
            System.out.println();
            break;
        case 3://Part C
            System.out.println("What is the order number of the order that needs to be cancelled?");
            int orderID = sc.nextInt();
            
            boolean orderCancel = kitchen.cancelOrder(orderID);
            
            if (orderCancel) {
                System.out.println("Order " + orderID + " was successfuly cancelled");
            }
            else {
                System.out.println("Could not find Order " + orderID + ". It has either been finished or does not exist.");
            }
            break;  
        case 4:
            System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
            break;
        case 5://Part C
            System.out.println("What is the order number that needs to be checked?");
            int orderIdent = sc.nextInt();
            
            boolean orderStatus = kitchen.isOrderDone(orderIdent);
            
            if (orderStatus) {
              System.out.println("Order " + orderIdent + " is done or does not exist.");  
            }
            else {
              System.out.println("Order " + orderIdent + " is still in progress. Peaase wait.");
            }
            break;
        case 6:
            break;
        default:
            System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, or a 6");
        }
        */
        
        //Lab 3
        FastFoodKitchen kitchen = new FastFoodKitchen();
        kitchen.addOrder(2, 2, 1, 5, false);
        kitchen.addOrder(0, 1, 0, 1, true);
        kitchen.addOrder(5, 5, 5, 15, false);
        
        //Part A
        int orderFind = 105;
        System.out.println("Finding Order Number Sequentially:" + orderFind);
        if (kitchen.findOrderSeq(orderFind) == -1 ) {
            System.out.println("Order not found.");
        }
        else {
            System.out.println("Order found at index " + kitchen.findOrderSeq(orderFind) + " in orderList.");
        }
        
        //Part B
        orderFind = 103;
        System.out.println("Finding Order Number Binarilly:" + orderFind);
        if (kitchen.findOrderBin(orderFind) == -1 ) {
            System.out.println("Order not found.");
        }
        else {
            System.out.println("Order found at index " + kitchen.findOrderBin(orderFind) + " in orderList.");
        }
        
        //Part C
        System.out.println(kitchen.toString());
        System.out.println("Ordering List using a selection sort...");
        kitchen.selectionSort();
        System.out.println(kitchen.toString());
        
        //Part D
        FastFoodKitchen kitchen2 = new FastFoodKitchen();
        kitchen2.addOrder(2, 2, 1, 5, false);
        kitchen2.addOrder(0, 1, 0, 1, true);
        kitchen2.addOrder(5, 5, 5, 15, false);
        
        System.out.println(kitchen2.toString());
        System.out.println("Ordering List using a selection sort...");
        kitchen2.insertionSort();
        System.out.println(kitchen2.toString());
    }
    
}

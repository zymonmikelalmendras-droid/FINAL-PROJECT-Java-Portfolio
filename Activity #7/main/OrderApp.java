package com.store.main;

import com.store.order.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {
    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();

        orders.add(new OnlineOrder(1, 150.50));
        orders.add(new OnlineOrder(2, 299.99));
        orders.add(new OnlineOrder(3, 0));

        orders.get(1).processOrder();
        ((OnlineOrder) orders.get(1)).pay();

        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
            } else {
                System.out.println(order.getOrderSummary());
            }
        }
    }
}
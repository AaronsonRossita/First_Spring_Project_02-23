package com.First_Spring_Project_023.controller.old;

import com.First_Spring_Project_023.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderControllerOld {

    static HashMap<Integer, Order> orders = new HashMap<>();

    @PostMapping(value = "/create")
    public static Order createOrder(@RequestBody Order order){
        orders.put(order.getId(),order);
        return order;
    }

    @PutMapping(value = "/update")
    public static Order updateOrderById (@RequestParam int id, @RequestBody Order order){
        if (orders.containsKey(id)){
            if (order.getItemName() != null){
                orders.get(id).setItemName(order.getItemName());
            }
            if (order.getCustomerId() != null){
                orders.get(id).setCustomerId(order.getCustomerId());
            }
            if (order.getPrice() > 0){
                orders.get(id).setPrice(order.getPrice());
            }
            return orders.get(id);
        }else{
            return null;
        }
    }

    @DeleteMapping(value = "/delete")
    public static String deleteOrderById(@RequestParam int id){
        if (orders.containsKey(id)){
            orders.remove(id);
            return "Object with id " + id + " was deleted";
        }else{
            return "No object with id " + id + " found";
        }
    }

    @GetMapping
    public static Order getOrderById(@RequestParam int id){
        return orders.getOrDefault(id, null);
    }

    @GetMapping(value = "/all")
    public static Order[] getAllOrder(){
        return orders.values().toArray(new Order[0]);
    }



}

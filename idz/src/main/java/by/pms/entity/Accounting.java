package by.pms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Accounting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name_dish;
    private int number_dish;
    private double price_dish, cost;

    public Accounting(){}
    public Accounting(String name_dish, int number_dish, double price_dish, double cost) {
        this.name_dish = name_dish;
        this.number_dish = number_dish;
        this.price_dish = price_dish;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_dish() {
        return name_dish;
    }

    public void setName_dish(String name_dish) {
        this.name_dish = name_dish;
    }

    public int getNumber_dish() {
        return number_dish;
    }

    public void setNumber_dish(int number_dish) {
        this.number_dish = number_dish;
    }

    public double getPrice_dish() {
        return price_dish;
    }

    public void setPrice_dish(double price_dish) {
        this.price_dish = price_dish;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

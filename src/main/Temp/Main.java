package Temp;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Methods methods = new Methods();

        Toy toy1 = new Toy(1, "Constructor", 1);
        Toy toy2 = new Toy(2, "Robot", 2);
        Toy toy3 = new Toy(3, "Doll", 4);
        Toy toy4 = new Toy(4, "Tractor", 3);

        PriorityQueue<Toy> toys = new PriorityQueue<>(methods.comparator);
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);

        methods.getChance(methods.putList(toys));

    }

}
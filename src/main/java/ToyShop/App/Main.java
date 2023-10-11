package ToyShop.App;

import ToyShop.Methods.Methods;
import ToyShop.Data.Toy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Methods methods = new Methods();

        Toy toy1 = new Toy(1, "Constructor", 2);
        Toy toy2 = new Toy(2, "Robot", 2);
        Toy toy3 = new Toy(3, "Doll", 6);
        Toy toy4 = new Toy(4, "Tractor", 3);

        PriorityQueue<Toy> toys = new PriorityQueue<>(methods.comparator);
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
//        toys.add(toy4);

        List<Object> list = methods.putList(toys);
        System.out.println(list);
        System.out.println();
        List<String> str = methods.getChance(list);
        System.out.println(str);
        System.out.println();
        Map<String, Integer> count = methods.sumElem(str);
        System.out.println(count);
        System.out.println();
        methods.writeToFile(str, count);
    }

}
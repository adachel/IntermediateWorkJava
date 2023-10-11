package ToyShop.Data;

import java.util.PriorityQueue;

public class Toy {
    private int ID;
    private String name;
    private int chance;

    public Toy() {
    }

    public Toy(int ID, String name, int chance) {
        this.ID = ID;
        this.name = name;
        this.chance = chance;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getChance() {
        return chance;
    }


    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", chance=" + chance +
                '}';
    }
}

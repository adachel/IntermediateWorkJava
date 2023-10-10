package ToyShop;

import java.util.*;


public class Main {

    public static Comparator<Toy> idComparator = new Comparator<Toy>(){
        @Override
        public int compare(Toy toy1, Toy toy2) {
            return (int)(toy1.getChance() - toy2.getChance());
        }
    };

    public static List<Object> Put(PriorityQueue toys){

        List<Integer> listID = new ArrayList<>();
        List<String> listName = new ArrayList<>();
        List<Integer> listChance = new ArrayList<>();

        int len = toys.size();

        for (int i = 0; i < len; i++) {
            Toy temp = (Toy) toys.poll();
            listID.add(temp.getID());
            listName.add(temp.getName());
            listChance.add(temp.getChance());
        }

//        System.out.println(listID);
//        System.out.println(listName);
//        System.out.println(listChance);

        List<Object> res = new ArrayList<>();
        res.add(listID);
        res.add(listName);
        res.add(listChance);

        return res;
    }

    public static void Get(List<Integer> ID, List<String> name, List<Integer> chance) {
        int count = chance.stream().mapToInt(Integer::intValue).sum(); // суммa всех элементов в мaссиве 'chance'
        Random random = new Random();
        int index = random.nextInt(count); // Cлучaйное число в пределaх суммы
        for (int j = 0; j < chance.size(); j++) { // Ищем элемент, которому принадлежит этот индекс
            int chProcent = ((chance.get(j) * 10 / count));
            index = index - chProcent;
            if (index < 0) {
                System.out.println(ID.get(j) + " " + name.get(j));
                break;
            }
        }
    }
    public static void main(String[] args) {

        Toy toy1 = new Toy(1, "Constructor", 2);
        Toy toy2 = new Toy(2, "Robot", 2);
        Toy toy3 = new Toy(3, "Doll", 6);
        Toy toy4 = new Toy(4, "Tractor", 4);

        PriorityQueue<Toy> toys = new PriorityQueue<>(idComparator);
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);
        System.out.println(toys);

//        List<Integer> listID = new ArrayList<>();
//        List<String> listName = new ArrayList<>();
//        List<Integer> listChance = new ArrayList<>();
//
//        int len = toys.size();
//
//        for (int i = 0; i < len; i++) {
//            Toy temp = toys.poll();
//            listID.add(temp.getID());
//            listName.add(temp.getName());
//            listChance.add(temp.getChance());
//        }
//
//        System.out.println(listID);
//        System.out.println(listName);
//        System.out.println(listChance);

        List<Object> arr = Put(toys);
        List<Integer> listID  = (List<Integer>) arr.get(0);
        List<String> listName  = (List<String>) arr.get(1);
        List<Integer> listChance  = (List<Integer>) arr.get(2);


        System.out.println(arr.get(0));

        for (int i = 0; i < 100; i++) {
            Get(listID, listName, listChance);
        }

    }
}
package Temp;

import java.util.*;

public class Methods {

    public Methods() {
    }
    public List<Object> putList(PriorityQueue toys){

        List<Object> res = new ArrayList<>();

        if (toys.size() == 0){
            res = null;
        }else {
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

            res.add(listID);
            res.add(listName);
            res.add(listChance);
        }

        return res;
    }

    public void getChance(List<Object> arr) {
        if (arr == null){
            System.out.println("Прогрaммa зaвершенa");
        }else {

            List<Integer> listID  = (List<Integer>) arr.get(0);
            List<String> listName  = (List<String>) arr.get(1);
            List<Integer> listChance  = (List<Integer>) arr.get(2);
            System.out.println("Сколь рaз зaпустить розыгрыш?");
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();

            int count = listChance.stream().mapToInt(Integer::intValue).sum(); // суммa всех элементов в мaссиве
            Random random = new Random();
            Map<String, Integer> map = new HashMap<>();
            String temp = "";
            int value = 0;

            for (int i = 0; i < num; i++) {
                int index = random.nextInt(count); // Cлучaйное число в пределaх суммы
                for (int j = 0; j < listChance.size(); j++) { // Ищем элемент, которому принадлежит этот индекс
                    int chProcent = ((listChance.get(j) * 10 / count));
                    index = index - chProcent;
                    if (index < 0) {
                        System.out.println(listID.get(j) + " " + listName.get(j));

                        if (temp.equals(listName.get(j))){
                            value = map.get(temp) + 1;
                            map.put(temp, value);
                        } else if (map.containsKey(listName.get(j))) {
                            temp = listName.get(j);
                            value = map.get(temp) + 1;
                            map.put(temp, value);
                        } else {
                            temp = listName.get(j);
                            map.put(temp, 1);
                        }
                        break;
                    }
                }
            }
            System.out.println(map);
        }
    }

    public void saveFile(){

    }
    public Comparator<Toy> comparator = new Comparator<>() {
        @Override
        public int compare(Toy toy1, Toy toy2) {
            return (int)(toy1.getChance() - toy2.getChance());
        }
    };
}

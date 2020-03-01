
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//https://www.jmdoudoux.fr/java/dej/chap-collections.htm#collections-4

public class testList {

    public static int max = 10000;

    public static void main(String[] args) {
        //Type de structure testé
        // 0 : ArrayList
        // 1 : LinkedList
        // 2 : CopyOnWriteList


        //Test
        //Get : 0
        //Insert : 1
        //Remove : 2

        if (args.length != 3) {
            System.out.println("Bad usage of arguments : java testList sizeOfList typeOfStructure testedOperation");
            System.exit(1);
        }



        ListeInterface list = null;

        //On crée la liste
        switch (Integer.parseInt(args[1])) {
            case 0: //ArrayList
                System.out.println("Test sur : ArrayList.");
                list = new ArrayListTest();
                break;
            case 1: //LinkedList
                System.out.println("Test sur : LinkedList.");
                list = new LinkedListTest();
                break;
            case 2: //CopyOnWriteList
                System.out.println("Test sur : CopyOnWriteList.");
                list = new CopyOnWriteArrayListTest();
                break;
            default:
                System.out.println("Bad usage of typeOfStructure : Select a number between 0 and 2");
                break;
        }

        //On remplit la liste
        for(int i = 0; i<Integer.parseInt(args[0]); i++){
            list.insert(0, getRandomIntegerInRange(0, max));
        }

        switch (Integer.parseInt(args[2])){
            case 0: //Get
                System.out.println("Test de : get");
                list.get(getRandomIntegerInRange(0, list.size()));
                break;
            case 1: //
                System.out.println("Test de : insert");
                list.insert(getRandomIntegerInRange(0, list.size()), getRandomIntegerInRange(0, max));
                break;
            case 2:
                System.out.println("Test de : remove");
                list.removeAll(getRandomIntegerInRange(0, max));
                break;
            default:
                System.out.println("Bad usage of testedOperation : Select a number between 0 and 2");
                break;

        }
    }

    private static int getRandomIntegerInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

}

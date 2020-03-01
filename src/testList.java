
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

        if(args.length != 3){
            System.out.println("Bad usage of arguments : java testList sizeOfList typeOfStructure testedOperation");
        }


        //On crée la liste
        switch (Integer.parseInt(args[1])){
            case 0:
                System.out.println("Test sur : ArrayList.");
                testArrayList(Long.parseLong(args[0]), Integer.parseInt(args[2]));
                break;
            case 1:
                System.out.println("Test sur : LinkedList.");
                testLinkedList(Long.parseLong(args[0]), Integer.parseInt(args[2]));
                break;
            case 2:
                System.out.println("Test sur : CopyOnWriteList.");
                testCopyList(Long.parseLong(args[0]), Integer.parseInt(args[2]));
                break;
            default:
                System.out.println("Bad usage of typeOfStructure : Select a number between 0 and 2");
                break;

        }
    }
    //region ArrayList
    private static void testArrayList(long tailleDeLaListe, int numeroDuTest){
        ArrayList<Integer> test = createArrayList(tailleDeLaListe);

        switch (numeroDuTest){
            case 0:
                System.out.println("Test de : get");
                getArrayList(test);
                break;
            case 1:
                System.out.println("Test de : insert");
                insertArrayList(test);
                break;
            case 2:
                System.out.println("Test de : remove");
                removeArrayList(test);
                break;
            default:
                System.out.println("Bad usage of testedOperation : Select a number between 0 and 2");
                break;

        }

    }

    private static ArrayList<Integer> createArrayList(long sizeOfList){
        ArrayList<Integer> retour = new ArrayList<>();
        for(int i = 0; i<sizeOfList; i++){
            retour.add(getRandomNumberInRange(0, max));
        }

        return retour;
    }

    private static void insertArrayList(ArrayList<Integer> list){
        list.add(getRandomNumberInRange(0, list.size()-1), getRandomNumberInRange(0,max));
    }
    private static void getArrayList(ArrayList<Integer> list){
        list.get(getRandomNumberInRange(0, list.size()-1));
    }
    private static void removeArrayList(ArrayList<Integer> list){
        list.removeAll(Collections.singleton(getRandomNumberInRange(0, list.size()-1)));
    }
    //endregion

    //region LinkedList
    private static void testLinkedList(long tailleDeLaListe, int numeroDuTest){
        LinkedList<Integer> test = createLinkedList(tailleDeLaListe);

        switch (numeroDuTest){
            case 0:
                System.out.println("Test de : get");
                getLinkedList(test);
                break;
            case 1:
                System.out.println("Test de : insert");
                insertLinkedList(test);
                break;
            case 2:
                System.out.println("Test de : remove");
                removeLinkedList(test);
                break;
            default:
                System.out.println("Bad usage of testedOperation : Select a number between 0 and 2");
                break;

        }
        System.out.println("Fin !");
    }

    private static LinkedList<Integer> createLinkedList(long sizeOfList){
        LinkedList<Integer> retour = new LinkedList<>();
        for(int i = 0; i<sizeOfList; i++){
            retour.add(getRandomNumberInRange(0, max));
        }

        return retour;
    }

    private static void insertLinkedList(LinkedList<Integer> list){
        list.add(getRandomNumberInRange(0, list.size()-1), getRandomNumberInRange(0,max));
    }
    private static void getLinkedList(LinkedList<Integer> list){
        list.get(getRandomNumberInRange(0, list.size()-1));
    }
    private static void removeLinkedList(LinkedList<Integer> list){
        list.removeAll(Collections.singleton(getRandomNumberInRange(0, list.size()-1)));
    }
    //endregion

    //region CopyOnWriteArrayListList
    private static void testCopyList(long tailleDeLaListe, int numeroDuTest){
        CopyOnWriteArrayList<Integer> test = createCopyOnWriteArrayList(tailleDeLaListe);

        switch (numeroDuTest){
            case 0:
                System.out.println("Test de : get");
                getCopyOnWriteArrayList(test);
                break;
            case 1:
                System.out.println("Test de : insert");
                insertCopyOnWriteArrayList(test);
                break;
            case 2:
                System.out.println("Test de : remove");
                removeCopyOnWriteArrayList(test);
                break;
            default:
                System.out.println("Bad usage of testedOperation : Select a number between 0 and 2");
                break;

        }

    }

    private static CopyOnWriteArrayList<Integer> createCopyOnWriteArrayList(long sizeOfList){
        CopyOnWriteArrayList<Integer> retour = new CopyOnWriteArrayList<>();
        for(int i = 0; i<sizeOfList; i++){
            retour.add(getRandomNumberInRange(0, max));
        }

        return retour;
    }

    private static void insertCopyOnWriteArrayList(CopyOnWriteArrayList<Integer> list){
        list.add(getRandomNumberInRange(0, list.size()-1), getRandomNumberInRange(0,max));
    }
    private static void getCopyOnWriteArrayList(CopyOnWriteArrayList<Integer> list){
        list.get(getRandomNumberInRange(0, list.size()-1));
    }
    private static void removeCopyOnWriteArrayList(CopyOnWriteArrayList<Integer> list){
        list.removeAll(Collections.singleton(getRandomNumberInRange(0, list.size()-1)));
    }
    //endregion



    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

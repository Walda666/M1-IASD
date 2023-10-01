import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        OrdererDictionary orderedDico = new OrdererDictionary();
        orderedDico.put("Lavoisier", "Rien ne se crée, rien ne se perd, tout se transforme");


        FastDictionary fastDico = new FastDictionary();
        fastDico.put("Lavoisier", "Rien ne se crée, rien ne se perd, tout se transforme");
        fastDico.put("Einstein", "Dieu ne joue pas aux dés");
        fastDico.put("Newton", "Je n'ai pas pu voir plus loin que les épaules de géants");
        fastDico.put("Laplace", "Je n'ai pas eu besoin de cette hypothèse");

        SortedDictionary sortedDico = new SortedDictionary();
        sortedDico.put("Lavoisier", "Rien ne se crée, rien ne se perd, tout se transforme");
        sortedDico.put("Einstein", "Dieu ne joue pas aux dés");
        sortedDico.put("Newton", "Je n'ai pas pu voir plus loin que les épaules de géants");
        sortedDico.put("Laplace", "Je n'ai pas eu besoin de cette hypothèse");
        sortedDico.put("Eric", "J'ai eu besoin de cette hypothèse");



        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        System.out.println(key);

        Object result = sortedDico.get((Object) key);
        System.out.println(result);



    }
}
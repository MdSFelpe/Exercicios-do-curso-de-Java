import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<alunos> courseA = new HashSet<>();
        Set<alunos> courseB = new HashSet<>();
        Set<alunos> courseC = new HashSet<>();

        System.out.print("How many students for course A? ");
        int quantity = sc.nextInt();
        for (int i = 0; i < quantity; i++) {
            courseA.add(new alunos(sc.nextInt()));
        }

        System.out.print("How many students for course B? ");
        quantity = sc.nextInt();
        for (int i = 0; i < quantity; i++) {
            courseB.add(new alunos(sc.nextInt()));
        }

        System.out.print("How many students for course C? ");
        quantity = sc.nextInt();
        for (int i = 0; i < quantity; i++) {
            courseC.add(new alunos(sc.nextInt()));
        }

        sc.close();


        // União dos três sets para calcular total de alunos únicos
        Set<alunos> total = new HashSet<>(courseA);
        total.addAll(courseB);
        total.addAll(courseC);

        System.out.println("Total students: " + total.size());


    }
}
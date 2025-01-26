import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        ArrayList<Integer> Cargo_coordinates = new ArrayList<Integer>();

        int first_cargo = rand.nextInt(7)+1;
        int second_cargo = rand.nextInt(7)+1;
        int third_cargo = rand.nextInt(7)+1;

        while (second_cargo == first_cargo){
            second_cargo = rand.nextInt(7)+1;
        }
        while (third_cargo == first_cargo || third_cargo == second_cargo){
            third_cargo = rand.nextInt(7)+1;
        }

        Cargo_coordinates.add(first_cargo);
        Cargo_coordinates.add(second_cargo);
        Cargo_coordinates.add(third_cargo);

        ArrayList <Integer> guesses = Get_guesses(sc);
        if (guesses.get(1).equals(guesses.get(0))||(guesses.get(2).equals(guesses.get(1))||(guesses.get(2).equals(guesses.get(0))))) {
            System.out.println("You entered two duplicate numbers, try again");
            guesses = Get_guesses(sc);
        }
        for (int i = 0; i < guesses.size(); i++) {
            if (guesses.get(i) < 1 || guesses.get(i) > 7) {
                System.out.println("Entered number should be between 1 and 7");
                guesses = Get_guesses(sc);
            }
        }

        for (int i = 1; i < 5; i++) {
            Check(Cargo_coordinates, guesses);
            guesses = Get_guesses(sc);
        }

    }

    public static ArrayList Get_guesses(Scanner sc){
        ArrayList <Integer> Guesses = new ArrayList<Integer>();
        for (int i=0; i<3; i++){
            Guesses.add(sc.nextInt());
        }
        return Guesses;
    }

    public static void Check (ArrayList<Integer> Cargo_coordinates, ArrayList<Integer> Guesses){
        int correct_guesses = 0;

        for (int i=0; i<3; i++){
            if (Cargo_coordinates.contains(Guesses.get(i))) {
                correct_guesses++;
            }

        }
        if (correct_guesses == 3){
            System.out.println("You guessed all marks!");
            System.exit(0);
        }

        else if (correct_guesses == 1){
            System.out.println("You guessed "+correct_guesses+" mark");
        }

        else {
            System.out.println("You guessed "+correct_guesses+" marks");
        }
    }

}
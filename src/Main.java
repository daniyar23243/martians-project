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

        ArrayList <Integer> guesses = new ArrayList<Integer>();

        while (true) {
            for (int i = 1; i < 6; i++) {
                guesses = Get_guesses(sc);
                guesses = Format_guesses(sc, guesses);
                Check(Cargo_coordinates, guesses);
            }
            System.out.println("You have used 5 attempts! Cargos are changing locations");
            Cargo_coordinates = Change_coordinates(Cargo_coordinates, rand);
        }
    }

    public static ArrayList Get_guesses(Scanner sc){
        ArrayList <Integer> Guesses = new ArrayList<Integer>();
        for (int i=0; i<3; i++){
            Guesses.add(sc.nextInt());
        }
        return Guesses;
    }
    public static ArrayList Format_guesses(Scanner sc, ArrayList <Integer> Guesses){
        if (Guesses.get(1).equals(Guesses.get(0))||(Guesses.get(2).equals(Guesses.get(1))||(Guesses.get(2).equals(Guesses.get(0))))) {
            System.out.println("You entered two duplicate numbers, try again");
            Guesses = Get_guesses(sc);
        }
        for (int i = 0; i < Guesses.size(); i++) {
            if (Guesses.get(i) < 1 || Guesses.get(i) > 7) {
                System.out.println("Entered number should be between 1 and 7");
                Guesses = Get_guesses(sc);
            }
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

    public static ArrayList Change_coordinates(ArrayList Cargo_coordinates, Random rand){
        int first_cargo = rand.nextInt(7)+1;
        int second_cargo = rand.nextInt(7)+1;
        int third_cargo = rand.nextInt(7)+1;
        while (Cargo_coordinates.get(0).equals(first_cargo)) {
            first_cargo = rand.nextInt(7)+1;
        }
        while (Cargo_coordinates.get(1).equals(second_cargo)||(second_cargo == first_cargo)) {
            second_cargo = rand.nextInt(7)+1;
        }
        while (Cargo_coordinates.get(2).equals(third_cargo)||(third_cargo == first_cargo)||(third_cargo == second_cargo)){
            third_cargo = rand.nextInt(7)+1;
        }
        Cargo_coordinates.set(0, first_cargo);
        Cargo_coordinates.set(1, second_cargo);
        Cargo_coordinates.set(2, third_cargo);
        return Cargo_coordinates;
    }

}
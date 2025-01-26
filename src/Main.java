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
    }
}
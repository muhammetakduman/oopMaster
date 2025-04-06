import java.util.Scanner;
import java.util.SortedMap;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome the Adventure Game");
        System.out.println("Please enter Name :");
        //String playerName = input.nextLine();


        Player player = new Player("mami");
        System.out.println("Senior " + player.getName() + " " + "Welcome back!  ");
        System.out.println("This you story in real LİFE.");
        System.out.println("Please Chooise character");
        player.selectChar();
    }

}

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


        ///  location logic

        Location location = null;
        while (true){

            System.out.println("Location");
            System.out.println("---------------");
            System.out.println("1- Safe House  \n *****FULL HEALTY***** \n ***** THERE ARE NO MONSTER HERE ******** ");
            System.out.println("2- Store \n ******BUY ARMOR AND WEAPON*****");
            System.out.println("---------------");
            System.out.println("Please select the region you want to visit :");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStoreLoc(player);
                    System.out.println("Spend according to your money:" + player.getMoney());
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (!location.onLocation()){
                System.out.println("ŞAHADET ŞERBETİNİ İÇTİN  !!! G A M E   O V E R !!!");
                break;
            }
        }
    }

}

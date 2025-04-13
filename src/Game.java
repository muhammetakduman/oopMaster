import java.util.Scanner;

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
            player.printInfo();
            player.printAwards();
            System.out.println("---------------");
            System.out.println("1- Safe House  \n *****FULL HEALTY***** \n ***** THERE ARE NO MONSTER HERE ******** ");
            System.out.println("2- Store \n ******BUY ARMOR AND WEAPON*****");
            System.out.println("3 - Cave -> Hold on! The zombie are waiting to eat you! \n Price <Food>");
            System.out.println("4 - Forest -> Hold on! The vampire are waiting to eat you \n Price <Firewood>  ");
            System.out.println("5 - River -> Hold on! The Bears are waiting to eat you \n Price <Water>  ");
            System.out.println("6 - Mine -> Hold on ! The Snake are waiting to eat you \n Price <?>");
            System.out.println("0- Exit *******Ending game********");
            System.out.println("---------------");
            System.out.println("Please select the region you want to visit :");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStoreLoc(player);
                    System.out.println("Spend according to your money:" + player.getMoney());
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Please , enter correct zone _-_-_-_");
            }
            if (location == null){
                System.out.println("Ending the game. Come back when you've got the courage");
                break;
            }
            if (!location.onLocation()){

                System.out.println("ŞAHADET ŞERBETİNİ İÇTİN  !!! G A M E   O V E R !!!");
                break;
            }
        }
    }

}

import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int money;
    private String name;
    private Scanner input  =  new Scanner(System.in);
    private Inventory inventory;
    private String charName; /// for ex : warrior , archer ,


    void selectChar() {
        GameChar[] charList = {new Samurai()  , new Archer(),new Knight()};
        System.out.println("-------------------------------------------");
        for ( GameChar gameChar : charList){
            System.out.println("ID: " + gameChar.getId() +
                    "\tCharacter:"+" " + gameChar.getName() +
                    "\t Damage: " + gameChar.getDamage() +
                    "\t Healty: " +gameChar.getHealth() +
                    "\t Money: " + gameChar.getMoney());
        };
        System.out.println("-----------------------------");
        System.out.println("Chooise an charachter !");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Bir seçim yapmadınız samurai olarak oyuna başlayacaksınız.");
                initPlayer(new Samurai());

        }
        /*System.out.println("Character :" +this.getCharName()+
                ", Hasar :" + this.getDamage()+
                ", Healty :" + this.getHealthy()+
                ", Money :" +this.getMoney());*/

    }


    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }


    public void printInfo(){
        System.out.println(
                "Weapon : " + this.getInventory().getWeapon().getName()+
                ", Hasar :" + this.getDamage()+
                ", Healty :" + this.getHealthy()+
                ", Money :" +this.getMoney());

    }

/// getter setter method
    public Player(String name){
        this.name = name;
        this.inventory =new Inventory();
    }

    public int getDamage() {
        return damage + getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int originalHealthy;
    private int money;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private String charName;
    private boolean hasFood;
    private boolean hasWater;
    private boolean hasFireWood;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public boolean hasAllAwards() {
        return hasFood && hasWater && hasFireWood;
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("-------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() +
                    "\tCharacter: " + gameChar.getName() +
                    "\tDamage: " + gameChar.getDamage() +
                    "\tHealty: " + gameChar.getHealth() +
                    "\tMoney: " + gameChar.getMoney());
        }
        System.out.println("-----------------------------");
        System.out.println("Choose a character:");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1 -> initPlayer(new Samurai());
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Knight());
            default -> {
                System.out.println("Geçersiz seçim. Samurai ile başlıyorsunuz.");
                initPlayer(new Samurai());
            }
        }
    }
    public void printAwards(){
        System.out.println("🧾 Sahip Olduğun Ödüller:");
        System.out.println((hasFood ? "✔️" : "❌") + " Yemek");
        System.out.println((hasWater ? "✔️" : "❌") + " Su");
        System.out.println((hasFireWood ? "✔️" : "❌") + " Odun");
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealth());
        this.setOriginalHealthy(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        String weaponName = (this.getInventory().getWeapon() != null)
                ? this.getInventory().getWeapon().getName()
                : "Yok";
        String armorName = (this.getInventory().getArmor() != null)
                ? this.getInventory().getArmor().getName()
                : "Yok";
        int block = (this.getInventory().getArmor() != null)
                ? this.getInventory().getArmor().getBlock()
                : 0;

        System.out.println("------ OYUNCU DURUMU ------");
        System.out.println("Weapon : " + weaponName);
        System.out.println("Armor : " + armorName);
        System.out.println("Block : " + block);
        System.out.println("Base Damage : " + this.getDamage());
        System.out.println("Total Damage : " + this.getTotalDamage()); // ✨ burası önemli
        System.out.println("Healthy : " + this.getHealthy());
        System.out.println("Money : " + this.getMoney());
    }


    // Getter - Setter Methods
    public boolean hasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean hasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    public boolean hasFireWood() {
        return hasFireWood;
    }

    public void setHasFireWood(boolean hasFireWood) {
        this.hasFireWood = hasFireWood;
    }

    public int getOriginalHealthy() {
        return originalHealthy;
    }

    public void setOriginalHealthy(int originalHealthy) {
        this.originalHealthy = originalHealthy;
    }

    public int getTotalDamage() {
        return damage + getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = Math.max(healthy, 0); // 0'ın altına düşmesin
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

import java.util.SortedMap;

public class ToolStoreLoc extends NormalLoc {
    public ToolStoreLoc(Player player) {
        super(player, "Tool Store");
    }


    /// LOCATİON LOGİC
    @Override
    boolean onLocation() {
        System.out.println("---------------------------------");
        System.out.println("Welcome Tool STORE");
        System.out.println("It's safe enough to shop here.");
        System.out.println("---------------------------------");
        System.out.println("1  --> Weapon");
        System.out.println("2 --> Armor");
        System.out.println("3 --> Exit");
        System.out.println("Your choice :");

        int selectCase = input.nextInt();
        while (selectCase<1 || selectCase>3){
            System.out.println("Invalid value, please heed the instructions.");
            selectCase = input.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Exit is being made, you are being directed to the secure area.");
                onLocation();
                return true;

        }

        return true;
    }

    /// PRİNT SCREEN ALL ARMOR
    private void printArmor() {
        System.out.println("******* ARMOR ********");

    }


    /// PRİNT SCREEN ALL WEAPON
    private void printWeapon() {
        System.out.println("******* WEAPON ********");
        System.out.println();
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + "- " + w.getName() + "<Money :" +  w.getPrice() + " < Damage :" + w.getDamage());
        }
    }


    /// BUY WEAPON LOGİC
    public void buyWeapon(){
        System.out.println("_-_-_-_-_ Choice Weapon  _-_-_-_-_");
        int selectWeaponID = input.nextInt();


        while (selectWeaponID<1 || selectWeaponID> Weapon.weapons().length){
            System.out.println("Invalid value : Correct take Weapon");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
        if (selectedWeapon != null){
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You do not have enough money.");
            }else{

                // buy zone:
                System.out.println(selectedWeapon.getName() + "you bought his weaponNnNnNnNn");
                int balance = this.getPlayer().getMoney()  - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Money Left :" + this.getPlayer().getMoney());
                System.out.println("Your previous weapon : " +this.getPlayer().getInventory().getWeapon().getName());

                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("New Weapon :" + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }
}

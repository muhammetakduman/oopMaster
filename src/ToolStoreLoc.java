import java.util.SortedMap;

public class ToolStoreLoc extends NormalLoc {
    public ToolStoreLoc(Player player) {
        super(player, "Tool Store");
    }


    /// LOCATİON LOGİC
    @Override
    boolean onLocation() {
        boolean showMenu = true;
        while (showMenu){
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
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Exit is being made, you are being directed to the secure area.");
                    showMenu = false;
                    break;

            }
        }
        return true;

    }

    private void buyArmor() {
        System.out.println("_-_-_-_-_ Choice Armor  _-_-_-_-_");
        int selectArmorID = input.nextInt();

        while (selectArmorID<0 || selectArmorID> Armor.armors().length){
            System.out.println("Invalid value : Correct take Armor");
            selectArmorID = input.nextInt();
        }


        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);

            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You do not have enough money.");
                }
                }else{
                    // buy zone:
                    System.out.println(selectedArmor.getName() + "you bought his armoRrRrRrRrRr");
                    int balance = this.getPlayer().getMoney()  - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Money Left :" + this.getPlayer().getMoney());
                    System.out.println("Your previous weapon : " +this.getPlayer().getInventory().getWeapon().getName());

                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("New Armor :" + this.getPlayer().getInventory().getArmor().getName());
            }
        }

    }

    /// PRİNT SCREEN ALL ARMOR
    private void printArmor() {
        System.out.println("******* ARMOR ********");
        System.out.println();
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " +  a.getName() +" " + "<Money :" + a.getPrice() + " " + "<Block :" + a.getBlock());
        }
        System.out.println("0 - Exit");

    }


    /// PRİNT SCREEN ALL WEAPON
    private void printWeapon() {
        System.out.println("******* WEAPON ********");
        System.out.println();
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + "- " + w.getName() + "<Money :" +  w.getPrice() + " < Damage :" + w.getDamage());
        }
        System.out.println("0 - Exit");
    }


    /// BUY WEAPON LOGİC
    public void buyWeapon(){
        System.out.println("_-_-_-_-_ Choice Weapon  _-_-_-_-_");
        int selectWeaponID = input.nextInt();


        while (selectWeaponID<0 || selectWeaponID> Weapon.weapons().length){
            System.out.println("Invalid value : Correct take Weapon");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0){
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

}

import java.util.Random;

public class Mine  extends BattleLoc{
    public Mine(Player player) {
        super(player , "Maden", new Snake(), "Suspised gain",5);
    }

    @Override
    public boolean onLocation() {
        boolean result = super.onLocation();
        if (result) {
            // Burada loot sistemini çağıracaksın
            lootDrop(); // yazman gerek
        }
        return result;
    }

    private void lootDrop() {
        Random rand = new Random();
        int chance = rand.nextInt(100) + 1;

        if (chance <= 15) { // Silah kazanma
            int weaponChance = rand.nextInt(100) + 1;
            if (weaponChance <= 50) {
                System.out.println("Tabanca kazandın!");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(1)); // Tabanca
            } else if (weaponChance <= 80) {
                System.out.println("Kılıç kazandın!");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(2)); // Kılıç
            } else {
                System.out.println("Tüfek kazandın!");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(3)); // Tüfek
            }

        } else if (chance <= 30) { // Zırh kazanma
            int armorChance = rand.nextInt(100) + 1;
            if (armorChance <= 50) {
                System.out.println("Hafif zırh kazandın!");
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(1));
            } else if (armorChance <= 80) {
                System.out.println("Orta zırh kazandın!");
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(2));
            } else {
                System.out.println("Ağır zırh kazandın!");
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(3));
            }

        } else if (chance <= 55) { // Para kazanma
            int moneyChance = rand.nextInt(100) + 1;
            if (moneyChance <= 50) {
                System.out.println("1 para kazandın!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
            } else if (moneyChance <= 80) {
                System.out.println("5 para kazandın!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
            } else {
                System.out.println("10 para kazandın!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
            }

        } else {
            System.out.println("Bu sefer hiçbir şey kazanamadın...");
        }
    }


}

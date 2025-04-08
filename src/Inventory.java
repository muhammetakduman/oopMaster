public class Inventory {
    public Weapon weapon;
    public Armor armor;



    /// const
    public Inventory() {

        this.weapon = new Weapon("punch",-1,0,0);
        this.armor = new Armor("Berdüş zırh",-1,0,0);
    }

    ///  getter setter
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

public class Inventory {
    public Weapon weapon;


    /// const
    public Inventory() {
        this.weapon = new Weapon("punch",0,0,0);
    }

    ///
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

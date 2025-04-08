public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;


    /// constructor
    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }


    public static Weapon[] weapons(){
        Weapon[] weaponsList = new Weapon[3];
        weaponsList[0] = new Weapon("Dolunay kilici",1,2,15);
        weaponsList[1] = new Weapon("Zehir kilici",2,3,35);
        weaponsList[2] = new Weapon("Sirius kilici",3,7,45);
        return weaponsList;


    }
    public static Weapon getWeaponObjById(int id){
        for (Weapon w : Weapon.weapons()){
            if (w.getId() == id){
                return w;
            }
        }
        return null;
    };

    /// getter-setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class Armor {

    private int id;
    private String name;
    private int block;
    private int price;

    /// const
    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Keşiş plaka",1,1,15);
        armorList[1] = new Armor("Siyah çelik Zırh",2,3,25);
        armorList[2] = new Armor("Kraliyet Zırhı",3,5,40);
        return armorList;
    }
    public static Armor getArmorObjById(int id){
        for (Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }


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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

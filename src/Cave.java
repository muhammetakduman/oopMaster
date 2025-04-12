public class Cave extends BattleLoc  {
    public Cave(Player player ){
        super(player,"mağara",new Zombie(),"food",3);
    }


    //methods
    public boolean onLocation() {
        if (this.isCompleted()) {
            System.out.println("⛔ Bu bölgeyi zaten tamamladınız. Giriş yapılamaz.");
            return true;
        }

        if (super.onLocation()) {
            if (!this.getPlayer().hasFood()) {
                this.getPlayer().setHasFood(true);
                System.out.println("🍗 Mağara ödülü: Yemek kazandınız!");
            }
            this.setCompleted(true);
            return true;
        }
        return false;
    }

}

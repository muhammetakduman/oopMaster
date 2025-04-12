public class River extends BattleLoc{
    public River(Player player) {
        super(player,"River",new Bear(),"water",2);
    }
    @Override
    boolean onLocation() {
        if (super.onLocation()){
            if(!this.getPlayer().hasWater()){
                this.getPlayer().setHasWater(true);
                System.out.println("Nehir ödülü : Su kazandınız!");
            }
            this.setCompleted(true);
            return true;
        }
        return false;
    }
}

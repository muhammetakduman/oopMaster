public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player,"Orman",new Vampire(),"Firewood",3);
    }


    //methods
    @Override
    boolean onLocation() {
        if (super.onLocation()){
            if(!this.getPlayer().hasFireWood()){
                this.getPlayer().setHasFireWood(true);
                System.out.println("Orman ödülü : Odun kazandınız!");
            }
            this.setCompleted(true);
            return true;
        }
        return false;
    }
}

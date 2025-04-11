import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    /// paramterleri const
    public BattleLoc(Player player, String name,  Obstacle obstacle ,String award , int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }

    /// const



    //methods
    @Override
    boolean onLocation() {
        int obsNumber = randomObstacleNumber();

        System.out.println("Şuan buradasınız:" + this.getName());
        System.out.println("Dikkatli ol ! Burada : " +obsNumber + " tane " + this.getObstacle().getName() + "Yaşıyor!");
        System.out.println("<S>avaş or <K>aç");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")){
            if (combat(obsNumber)){
                System.out.println(this.getName() + "Tüm düşmanları yendiniz !");
                return true;
            }

        }
        if (this.getPlayer().getHealthy() <0){
            System.out.println("Öldünüz ...");
            return false;
        }
        return true;
    }



    public boolean combat(int obsNumber){
        for (int i = 1; i <= obsNumber ; i++) {
            this.getObstacle().setHealthy(this.getObstacle().getOriginalHealthy());
            playerStatus();
            obstacleStatus(i);
            while (this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealthy() > 0) {
                System.out.println("<V>ur veya <K>aç :");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    System.out.println("Canavara vurdunuz !!");
                    this.getObstacle().setHealthy(this.getObstacle().getHealthy() - this.getPlayer().getDamage());
                    afterHit();

                    if (this.getObstacle().getHealthy() > 0) {
                        System.out.println();
                        System.out.println("Canavar size vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                        afterHit();
                    }
                }
            }
        }
        return false;
    }

    private void afterHit() {
        System.out.println("Yout healthy :" + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + "Canı :" + this.getObstacle().getHealthy());
        System.out.println();

    }

    private void obstacleStatus(int i) {
        System.out.println( i +" . " +this.getObstacle().getName() + "Statüs volume :");
        System.out.println("----------------");
        System.out.println("Healthy :" + this.getObstacle().getHealthy());
        System.out.println("Damage :" + this.getObstacle().getDamage());
        System.out.println("Award :" +this.getObstacle().getAward());
    }

    private void playerStatus() {
        System.out.println("Player Value :");
        System.out.println("----------------");
        System.out.println("Healthy :" + this.getPlayer().getHealthy());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Money :" + this.getPlayer().getMoney());
        System.out.println("Weapon :" +this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor :" + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block :" + this.getPlayer().getInventory().getArmor().getBlock());
    }


    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }



    /// getter-setter
    ///
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}

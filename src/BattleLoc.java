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
            System.out.println("Savaş işlemleri olacak");
            /// savaş işlemleri ....
        }
        return true;
    }


    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }


    /// getter-setter
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

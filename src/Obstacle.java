public abstract class Obstacle {
    private int id ;
    private String name;
    private int damage;
    private int healthy;
    private int originalHealthy;
    private int award;

    /// const
    public Obstacle(int id, String name, int damage, int healthy  ,int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.healthy = healthy;
        this.originalHealthy = originalHealthy;
        this.award = award;
    }

    /// getter-setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        if (healthy <= 0){
            healthy =0;
        }
        this.healthy = healthy;
    }

    public int getOriginalHealthy() {
        return originalHealthy;
    }
    public void setOriginalHealthy(int originalHealthy) {
        this.originalHealthy = originalHealthy;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }


}

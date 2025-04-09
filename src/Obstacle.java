public abstract class Obstacle {
    private int id ;
    private String name;
    private int damage;
    private int healthy;

    /// const
    public Obstacle(int id, String name, int damage, int healthy) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.healthy = healthy;
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
        this.healthy = healthy;
    }
}

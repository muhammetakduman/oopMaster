public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("🏠 Güvenli evdesiniz.");
        System.out.println();
        System.out.println("❤️ Canınız yenilendi!");
        this.getPlayer().setHealthy(this.getPlayer().getOriginalHealthy());
        this.getPlayer().printAwards();

        if (this.getPlayer().hasFood() && this.getPlayer().hasFireWood() && this.getPlayer().hasWater()) {
            System.out.println("✨ Tüm ödülleri topladınız!");
            System.out.println("🎉 Oyunu başarıyla tamamladınız! Tebrikler! 🎉");
            return false; // false dönerek oyunu sonlandır
        }
        return true;
    }

}

public class ToolStoreLoc extends NormalLoc {
    public ToolStoreLoc(Player player) {
        super(player, "Tool Store");
    }

    @Override
    boolean onLocation() {
        System.out.println("Bursası alışveriş yapmak için yeterince güvenli.");
        return true;
    }
}

import java.util.ArrayList;

public class AdvancedBuildingBuilder extends BuildingBuilder {
    private final ArrayList<String> availableBuildings = new ArrayList<>();
    private final ArrayList<String> requiredBuildings = new ArrayList<>();

    public AdvancedBuildingBuilder(final Player player) {
        this.buildingBuilder = new BasicBuildingBuilder(player);
        this.player = player;

        requiredBuildings.add("chatka siōngŏrza");
        requiredBuildings.add("kamieniołom");

        availableBuildings.add("mennica");
        availableBuildings.add("gruba złotŏ");
        availableBuildings.add("tartak");
    }

    @Override
    protected boolean checkBuildingName(final String buildingName) {
        if (availableBuildings.contains(buildingName)) {
            boolean first = player.getBuildingContainer().getBuilding(requiredBuildings.get(0)).getBuildingAmount() > 0;
            boolean second = player.getBuildingContainer().getBuilding(requiredBuildings.get(1)).getBuildingAmount() > 0;
            if(!(first && second)){
                System.out.println("Do zbudowaniŏ " + buildingName + "potrzebujesz jeszcze: ");
                if(!first){
                    System.out.println(requiredBuildings.get(0));
                }
                if(!second){
                    System.out.println(requiredBuildings.get(1));
                }
                return false;
            }
        }
        return true;
    }
}

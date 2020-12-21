import java.util.ArrayList;

public class BasicBuildingBuilder extends BuildingBuilder {
    private final ArrayList<String> availableBuildings = new ArrayList<>();

    public BasicBuildingBuilder(final Player player) {
        this.buildingBuilder = null;
        this.player = player;

        availableBuildings.add("kamieniołom");
        availableBuildings.add("chatka siōngŏrza");
    }

    @Override
    protected boolean checkBuildingName(final String buildingName) {
        return availableBuildings.contains(buildingName);
    }
}
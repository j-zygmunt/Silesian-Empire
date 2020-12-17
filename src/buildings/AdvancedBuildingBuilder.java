package buildings;

import java.util.ArrayList;

public class AdvancedBuildingBuilder extends BuildingBuilder {
    private ArrayList<String> availableBuildings = new ArrayList<>();
    private ArrayList<String> requiredBuildings = new ArrayList<String>();

    public AdvancedBuildingBuilder() {
        requiredBuildings.add("chatka siōngŏrza");
        requiredBuildings.add("kamieniołom");

        availableBuildings.add("mennica");
        availableBuildings.add("gruba złotŏ");
        availableBuildings.add("tartak");

    }

    @Override
    protected boolean checkBuildingName(String buildingName) {
        return availableBuildings.contains(buildingName);
    }



    @Override
    protected boolean checkRequiredMoney(int cash) {
        if
    }
}

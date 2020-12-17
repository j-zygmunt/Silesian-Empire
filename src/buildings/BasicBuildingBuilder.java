package buildings;

import java.util.ArrayList;

public class BasicBuildingBuilder extends BuildingBuilder {
    private ArrayList<String> availableBuildings = new ArrayList<>();

    public BasicBuildingBuilder() {
        availableBuildings.add("kamieniołom");
        availableBuildings.add("chatka siōngŏrza");
    }

    @Override
    protected boolean checkBuildingName(String buildingName) {
        return false;
    }

    @Override
    protected boolean checkRequiredMoney(int cash) {

    }
}
package buildings;

import java.util.ArrayList;

public class BuildingContainer {
    private ArrayList<Building> existingBuildings = new ArrayList<>();

    public BuildingContainer() {
        addBuilding(new Building("mennica", 10000, 3000, 1000));
        addBuilding(new Building("gruba złotŏ", 5000, 1000, 1000));
        addBuilding(new Building("tartak", 3000, 500, 1000));
        addBuilding(new Building("chatka siōngŏrza", 1500, 300, 1000));
        addBuilding(new Building("kamieniołom", 500, 200, 1000));
    }

    private void addBuilding(Building building) {
        this.existingBuildings.add(building);
    }

    public void incrementBuildingAmount(String buildingName){
        for(Building building : existingBuildings){
            if (building.getBuildingName().equals(buildingName)){
                building.incrementBuildingAmount();
                return;
            }
        }
    }

    public ArrayList<Building> getExistingBuildings() {
        return existingBuildings;
    }

}

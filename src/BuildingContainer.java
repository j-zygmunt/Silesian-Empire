import java.util.ArrayList;

public class BuildingContainer {
    private ArrayList<Building> existingBuildings = new ArrayList<>();

    public BuildingContainer() {
        addBuilding(new Building("mennica", 10000, 3000, 15000));
        addBuilding(new Building("gruba złotŏ", 5000, 1000, 8000));
        addBuilding(new Building("tartak", 3000, 500, 4000));
        addBuilding(new Building("chatka siōngŏrza", 1500, 300, 2000));
        addBuilding(new Building("kamieniołom", 500, 200, 1000));
    }

    private void addBuilding(final Building building) {
        this.existingBuildings.add(building);
    }

    public Building getBuilding(final String BuildingName) {
        for (Building building : existingBuildings) {
            if (building.getBuildingName().equals(BuildingName))
                return building;
        }
        return null;
    }

    public ArrayList<Building> getExistingBuildings() {
        return existingBuildings;
    }

    public void ListExistingBuildings() {
        int totalBuildingTypes = 0;
        for (Building building : existingBuildings) {
            if (building.getBuildingAmount() > 0) {
                totalBuildingTypes += 1;
                System.out.println(building.getBuildingName() + ": wielość (" + building.getBuildingAmount()
                        + ") imyntny przichōd (" + building.getTotalIncome() + ")");
            }
        }
        if (totalBuildingTypes == 0) System.out.println("niy mŏ");
    }

}

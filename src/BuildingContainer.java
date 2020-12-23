import java.io.Serializable;
import java.util.ArrayList;

public class BuildingContainer implements Serializable {
    private final ArrayList<Building> existingBuildings = new ArrayList<>();

    public BuildingContainer() {
        this.getInitialState();
    }

    private void getInitialState(){
        this.existingBuildings.add(
                new Building("mennica", 10000, 3000, 35000));
        this.existingBuildings.add(
                new Building("gruba złotŏ", 5000, 1000, 18000));
        this.existingBuildings.add(
                new Building("tartak", 3000, 500, 11000));
        this.existingBuildings.add(
                new Building("chatka siōngŏrza", 1500, 300, 7000));
        this.existingBuildings.add(
                new Building("kamieniołom", 500, 200, 5000));
    }

    public Building getBuilding(final String buildingName) {
        for (Building building : existingBuildings) {
            if (building.getName().equals(buildingName))
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
            if (building.getAmount() > 0) {
                totalBuildingTypes += 1;
                System.out.println(building.getName() + ": wielość (" + building.getAmount() + ")");
            }
        }
        if (totalBuildingTypes == 0) System.out.println("niy mŏ");
    }
}

package buildings;

import java.io.Serializable;

public class Building implements Serializable {
    private String buildingName;
    private int buildingPrice;
    private int buildingIncome;
    private int payoutInterval;
    private int buildingAmount;

    public Building(String buildingName, int buildingPrice, int buildingIncome, int payoutInterval) {
        this.buildingName = buildingName;
        this.buildingPrice = buildingPrice;
        this.buildingIncome = buildingIncome;
        this.payoutInterval = payoutInterval;
        this.buildingAmount = 0;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void incrementBuildingAmount() {
        this.buildingAmount += 1;
    }

    public boolean decrementBuildingAmount() {
        if (this.buildingAmount == 0) return false;
        this.buildingAmount -= 1;
        return true;
    }
}
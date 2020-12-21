import java.io.Serializable;

public class Building implements Serializable {
    private final String buildingName;
    private final int buildingPrice;
    private final int buildingIncome;
    private final int payoutInterval;
    private int buildingAmount;
    private int totalIncome;

    public Building(final String buildingName, final int buildingPrice, final int buildingIncome, final int payoutInterval) {
        this.buildingName = buildingName;
        this.buildingPrice = buildingPrice;
        this.buildingIncome = buildingIncome;
        this.payoutInterval = payoutInterval;
        this.buildingAmount = 0;
        this.totalIncome = 0;
    }

    public String getBuildingName() {
        return this.buildingName;
    }

    public int getBuildingAmount() {
        return this.buildingAmount;
    }

    public int getBuildingPrice() {
        return this.buildingPrice;
    }

    public int getBuildingIncome() {
        return this.buildingIncome;
    }

    public int getPayoutInterval() {
        return this.payoutInterval;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void incrementBuildingAmount() {
        this.buildingAmount += 1;
    }

    public void updateTotalIncome(int cash) {
        totalIncome += cash;
    }
}
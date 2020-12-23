import java.io.Serializable;

public class Building implements Serializable {
    private final String buildingName;
    private final int buildingPrice;
    private final int buildingIncome;
    private final int payoutInterval;
    private int buildingAmount;

    public Building(final String buildingName, final int buildingPrice, final int buildingIncome, final int payoutInterval, final int buildingAmount) {
        this.buildingName = buildingName;
        this.buildingPrice = buildingPrice;
        this.buildingIncome = buildingIncome;
        this.payoutInterval = payoutInterval;
        this.buildingAmount = buildingAmount;
    }

    public Building(final String buildingName, final int buildingPrice, final int buildingIncome, final int payoutInterval) {
        this(buildingName, buildingPrice, buildingIncome, payoutInterval, 0);
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getBuildingAmount() {
        return buildingAmount;
    }

    public int getBuildingPrice() {
        return buildingPrice;
    }

    public int getBuildingIncome() {
        return buildingIncome;
    }

    public int getPayoutInterval() {
        return payoutInterval;
    }

    public void incrementBuildingAmount() {
        buildingAmount += 1;
    }
}
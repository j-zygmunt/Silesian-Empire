import java.util.Timer;
import java.util.TimerTask;

public class Player implements IPlayer {
    private final BuildingContainer buildingContainer = new BuildingContainer();
    private int cash;
    private Timer timer = new Timer();

    Player() {
        this.cash = 2000;
    }

    public void pay(final int cash) {
        this.cash -= cash;
    }

    @Override
    public void getPayment() {
        for (Building building : buildingContainer.getExistingBuildings()) {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    cash += building.getBuildingAmount() * building.getBuildingIncome();
                    building.updateTotalIncome(building.getBuildingAmount() * building.getBuildingIncome());
                }
            }, building.getPayoutInterval(), building.getPayoutInterval());
        }
    }

    public int getCash() {
        return this.cash;
    }

    public BuildingContainer getBuildingContainer() {
        return buildingContainer;
    }

}
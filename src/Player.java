import java.util.Timer;
import java.util.TimerTask;

public class Player implements IPlayer {
    private static final int DEFAULT_CASH = 2000;

    private int cash;
    private BuildingContainer buildingContainer;
    private String name;
    private Timer timer;

    Player(int cash, BuildingContainer buildingContainer, String name) {
        this.cash = cash;
        this.buildingContainer = buildingContainer;
        this.name = name;
    }

    Player() {
        this(DEFAULT_CASH, new BuildingContainer(), "Grŏcz");
    }

    public void pay(final int cash) {
        this.cash -= cash;
    }

    @Override
    public void getPayment() {
        if (timer != null) timer.cancel();
        timer = new Timer();
        for (Building building : buildingContainer.getExistingBuildings()) {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    cash += building.getAmount() * building.getIncome();
                }
            }, building.getPayoutInterval(), building.getPayoutInterval());
        }
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public BuildingContainer getBuildingContainer() {
        return buildingContainer;
    }

    public GameMemento saveGame() {
        return new GameMemento(buildingContainer, cash, name);
    }

    public void loadGame(final GameMemento savedGame) {
        this.buildingContainer = savedGame.getBuildingContainer();
        this.cash = savedGame.getCash();
        this.name = savedGame.getPlayerName();
    }
}
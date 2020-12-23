import java.io.Serializable;
import java.util.Date;

public class GameMemento implements Serializable {
    private final BuildingContainer buildingContainer;
    private final int cash;
    private final String playerName;
    private final Date date = new Date();

    GameMemento(BuildingContainer buildingContainer, int cash, String playerName) {
        this.buildingContainer = buildingContainer;
        this.cash = cash;
        this.playerName = playerName;
    }

    public BuildingContainer getBuildingContainer() {
        return buildingContainer;
    }

    public int getCash() {
        return cash;
    }

    public Date getDate() {
        return date;
    }

    public String getPlayerName() {
        return playerName;
    }
}

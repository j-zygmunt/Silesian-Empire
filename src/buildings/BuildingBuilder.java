package buildings;

public abstract class BuildingBuilder {

    public boolean build(String buildingName, int cash) {

    }

    abstract protected boolean checkBuildingName(String buildingName);

    abstract protected boolean checkRequiredMoney(int cash);
}

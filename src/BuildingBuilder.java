public abstract class BuildingBuilder {
    protected Player player;
    protected BuildingBuilder buildingBuilder;

    public void build(final String buildingName) {
        if(checkRequiredMoney(buildingName)){
            if (!checkBuildingName(buildingName)) {
                if (buildingBuilder == null) {
                    return;
                }
                buildingBuilder.build(buildingName);
                return;
            }
            player.getBuildingContainer().getBuilding(buildingName).incrementBuildingAmount();
            player.pay(player.getBuildingContainer().getBuilding(buildingName).getBuildingPrice());
            System.out.println("kupiōno było: " + buildingName);
            return;
        }
        System.out.println("za mało pijyndzy");
    }

    abstract protected boolean checkBuildingName(final String buildingName);

    protected boolean checkRequiredMoney(final String buildingName) {
        return player.getBuildingContainer().getBuilding(buildingName).getBuildingPrice() <= player.getCash();
    }
}

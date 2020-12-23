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
            player.getBuildingContainer().getBuilding(buildingName).incrementAmount();
            player.pay(player.getBuildingContainer().getBuilding(buildingName).getPrice());
            System.out.println("kupiōno było: " + buildingName);
            return;
        }
        System.out.println("za mało pijyndzy");
    }

    abstract protected boolean checkBuildingName(final String buildingName);

    protected boolean checkRequiredMoney(final String buildingName) {
        return player.getBuildingContainer().getBuilding(buildingName).getPrice() <= player.getCash();
    }
}

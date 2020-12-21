import java.util.Scanner;

public class SilesianEmpire {

    private static void gameLoop(Player player) {
        Scanner scanner = new Scanner(System.in);
        player.getPayment();
        while (true) {
            System.out.println();
            System.out.println("Ôpcyje:\n" +
                    "1 - zbuduj budōnek\n" +
                    "2 - zbudowane budōnki\n" +
                    "3 - pijōndze\n" +
                    "0 - wyjdź\n");
            char option = scanner.next().charAt(0);
            switch (option) {
                case '1' -> {
                    System.out.println("Ôbier budōnek:");
                    int buildingOption = 0;
                    for (Building building : player.getBuildingContainer().getExistingBuildings()) {
                        buildingOption += 1;
                        System.out.println(buildingOption + " - " + building.getBuildingName() + " - cyna: "
                                + building.getBuildingPrice() + " przichōd: " + building.getBuildingIncome());
                    }
                    System.out.println("0 - wyjdź");
                    int subOption = Character.getNumericValue(scanner.next().charAt(0));
                    if (subOption > 0 && subOption <= player.getBuildingContainer().getExistingBuildings().size()) {
                        BuildingBuilder buildingBuilder = new AdvancedBuildingBuilder(player);
                        buildingBuilder.build(player.getBuildingContainer().getExistingBuildings().get(subOption - 1).getBuildingName());
                    } else if (subOption == 0) {
                    } else {
                        System.out.println("niyznōmŏ ôpcyjŏ");
                    }
                }
                case '2' -> {
                    System.out.println("twoje budōnki: ");
                    player.getBuildingContainer().ListExistingBuildings();
                }
                case '3' -> System.out.println("zgrōmadzōne pijōndze: " + player.getCash());
                case '0' -> {
                    System.out.println("adieu na hałdzie");
                    System.exit(0);
                }
                default -> System.out.println("niyznōmŏ ôpcyjŏ");
            }
        }
    }

    public static void main(String[] args) {
        Player player = new Player();
        gameLoop(player);
    }
}

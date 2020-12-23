import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class SilesianEmpire {

    private static void gameLoop() {
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        GameCaretaker gameCaretaker;
        boolean nameSet= false;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("save.bin"));
            gameCaretaker = (GameCaretaker) inputStream.readObject();
            while (true) {
                System.out.println("Chcesz wgrać szpil?(Y/N)");
                char option = scanner.next().charAt(0);
                if (Character.toUpperCase(option) == 'Y') {
                    if (loadGame(player, gameCaretaker)) {
                        nameSet = true;
                        break;
                    }
                    break;
                } else if (Character.toUpperCase(option) == 'N') {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Niy znŏdniynto było zapisanych szpilōw");
            gameCaretaker = new GameCaretaker();
        }
        if(!nameSet){
            System.out.println("Podej swoje mjano");
            player.setName(scanner.next());
        }
        player.getPayment();
        System.out.println("witej " + player.getName() + "!");
        while (true) {
            System.out.println();
            System.out.println("Ôpcyje:\n" +
                    "1 - zbuduj budōnek\n" +
                    "2 - zbudowane budōnki\n" +
                    "3 - pijōndze\n" +
                    "4 - zapisz szpil\n" +
                    "5 - wgrej szpil\n" +
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
                        break;
                    } else {
                        System.out.println("ty je żeś gōrŏl (niyznōmŏ ôpcyjŏ)");
                    }
                }
                case '2' -> {
                    System.out.println("twoje budōnki: ");
                    player.getBuildingContainer().ListExistingBuildings();
                }
                case '3' -> System.out.println("zgrōmadzōne pijōndze: " + player.getCash());
                case '4' -> {
                    gameCaretaker.addSave(player.saveGame());
                    System.out.println("zapisano było");
                }
                case '5' -> {
                    loadGame(player, gameCaretaker);
                    player.getPayment();
                }
                case '0' -> {
                    while (true) {
                        System.out.println("Chcesz zapisać szpil?(Y/N)");
                        char subOption = scanner.next().charAt(0);
                        if (Character.toUpperCase(subOption) == 'Y') {
                            gameCaretaker.addSave(player.saveGame());
                            break;
                        } else if (Character.toUpperCase(subOption) == 'N') {
                            break;
                        }
                    }
                    System.out.println("adieu na hałdzie");
                    try {
                        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("save.bin"));
                        outputStream.writeObject(gameCaretaker);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
                default -> System.out.println("ty je żeś gōrŏl (niyznōmŏ ôpcyjŏ)");
            }
        }
    }

    public static boolean loadGame(Player player, GameCaretaker gameCaretaker) {
        Scanner scanner = new Scanner(System.in);
        gameCaretaker.listSavedGames();
        int option = Character.getNumericValue(scanner.next().charAt(0));
        if (option > 0 && option <= gameCaretaker.getSize()) {
            player.loadGame(gameCaretaker.getSave(option - 1));
        } else {
            System.out.println("ty je żeś gōrŏl (niyznōmŏ ôpcyjŏ)");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        gameLoop();
    }
}

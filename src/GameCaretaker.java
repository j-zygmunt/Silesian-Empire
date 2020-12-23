import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class GameCaretaker implements Serializable{
    private static final int MAX_SIZE = 5;

    private final ArrayList<GameMemento> savedGames = new ArrayList<>();

    public void addSave(GameMemento save) {
        if (savedGames.size() == MAX_SIZE) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ôsiōngniynto było maksymalny numer szkryftōw. Kery szkryft chcesz nadpisać?");
            listSavedGames();
            int option = Character.getNumericValue(scanner.next().charAt(0));
            if (option > 0 && option <= MAX_SIZE) {
                savedGames.remove(option - 1);
            } else System.out.println("ty je żeś gōrŏl (niynŏleżny numer)");
            return;
        }
        savedGames.add(save);
    }

    public void listSavedGames() {
        int index = 0;
        for (GameMemento savedGame : savedGames) {
            index++;
            System.out.println(index + " - " + savedGame.getDate() + ", mjano:" + savedGame.getPlayerName() + " pijōndze: " + savedGame.getCash());
        }
    }

    public GameMemento getSave(int index) {
        return savedGames.get(index);
    }

    public int getSize() {
        return savedGames.size();
    }
}

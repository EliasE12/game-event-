package model;

import exception.EmptyDataException;

import java.io.*;
import java.util.List;

public class GameEvent {

    public final static String PATH_FILE = "data/data.dat";

    private List<Player> players;


    public GameEvent() {
    }

    public GameEvent(List<Player> players) {
        this.players = players;
    }


    public void sortByName() {
        // Insertion
        for (int i = 1; i < players.size(); i++) {
            Player current = players.get(i);
            int j = i;
            while (j > 0 && players.get(j - 1).getName().compareTo(current.getName()) > 0) {
                players.set(j, players.get(j - 1));
                j--;
            }
            players.set(j, current);
        }
    }

    public void sortByScore() {
        // Selection
        for (int i = 0; i < players.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(j).getScore() < players.get(min).getScore()) {
                    min = j;
                }
            }
            Player aux = players.get(i);
            players.set(i, players.get(min));
            players.set(min, aux);
        }
    }

    public void addPlayer(String name, String nickName, int category, double score) throws EmptyDataException {
        if (name == null || nickName == null) {
            throw new EmptyDataException();
        } else {
            players.add(new Player(name, nickName, category, score));
        }
    }

    public void saveFile(String pathFile) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(PATH_FILE)));
            oos.writeObject(players);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String printPlayers() {
        String print = " Lista De jugadores presenciales".toUpperCase()+"\n\n";
        for (Player current : players) {
            print += current.getName() + "" + "\n";
        }
        return print;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}

package testModel;

import exception.EmptyDataException;
import model.GameEvent;
import model.Player;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


class GameEventTest {

    private GameEvent gameEvent;

    private void setupScenary1(){
        List<Player> players = new ArrayList<>();
        gameEvent = new GameEvent(players);
    }
    private void setupScenary2(){
        List<Player> players = null;
        gameEvent = new GameEvent(players);
    }
    private void setupScenary3(){

        List<Player> players = new ArrayList<>();
        players.add(new Player("Ana Nathan","An", 3, 79.0));
        players.add(new Player("Roy Rolls","Rr", 2, 62.0));
        players.add(new Player("Sebas Conor","Sc", 5, 99.0));

        gameEvent = new GameEvent(players);
    }

    @Test
    public void testAddPlayer1(){
        setupScenary1();
        String n = "Jean Poole";
        String nn = "Jp";
        int c = 2;
        double s = 93.0;

        try{
            gameEvent.addPlayer(n,nn,c,s);
        }catch (EmptyDataException e){
            fail("Los valores ingresados no son correctos. No se agregó el nuevo jugador");
        }
    }

    @Test
    public void testAddPlayer2(){
        setupScenary2();
        String n = null;
        String nn = null;
        int c = 2;
        double s = 93.0;

        try{
            gameEvent.addPlayer(n,nn,c,s);
            fail("Los valores ingresados no son correctos. No se agregó el nuevo jugador");
        }catch (EmptyDataException e){}
    }

    @Test
    public void testSortByScore1(){
        setupScenary3();
        gameEvent.sortByScore();
        for (int i = 0; i < gameEvent.getPlayers().size(); i++) {
            for (int j = i+1; j < gameEvent.getPlayers().size(); j++) {
                assertTrue(gameEvent.getPlayers().get(i).getScore() < gameEvent.getPlayers().get(j).getScore(),
                        "Los jugadores no estan ordenados correctamente");
            }

        }
    }

}
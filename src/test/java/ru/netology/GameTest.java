package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Player1", 40);
    Player player2 = new Player(2, "Player2", 70);
    Player player3 = new Player(3, "Player3", 100);
    Player player4 = new Player(4, "Player4", 50);
    Player player5 = new Player(5, "Player5", 100);
    Game game = new Game();

    @Test
    public void shouldFirstPlayerWon() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Player2", "Player1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondPlayerWon() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayersWereEqual() {
        game.register(player3);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Player3", "Player5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player3");
        });
    }

    @Test
    public void shouldSecondPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player2", "Player4");
        });
    }


}


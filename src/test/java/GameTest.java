import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void testWhenSecondPlayerWin() {
        Player numbr1 = new Player(1, "номер 1", 10);
        Player numbr2 = new Player(2, "номер 2", 20);
        Game game = new Game();

        game.register(numbr1);
        game.register(numbr2);

        int actual = game.round("номер 1", "номер 2");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWins() {
        Player numbr1 = new Player(1, "номер 1", 30);
        Player numbr2 = new Player(2, "номер 2", 20);
        Game game = new Game();

        game.register(numbr1);
        game.register(numbr2);

        int actual = game.round("номер 1", "номер 2");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenBothPlayersWin() {
        Player numbr1 = new Player(1, "номер 1", 10);
        Player numbr2 = new Player(2, "номер 2", 10);
        Game game = new Game();

        game.register(numbr1);
        game.register(numbr2);

        int actual = game.round("номер 1", "номер 2");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenTheFirstPlayerNotRegistered() {
        Player numbr1 = new Player(1, "номер 1", 10);
        Player numbr2 = new Player(2, "номер 2", 10);
        Game game = new Game();

        game.register(numbr1);
        game.register(numbr2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("номер3", "номер 2")
        );
    }

    @Test
    public void testWhenTheSecondPlayerHasNotRegistered() {
        Player numbr1 = new Player(1, "номер 1", 10);
        Player numbr2 = new Player(2, "номер 2", 10);
        Game game = new Game();

        game.register(numbr1);
        game.register(numbr2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("номер1", "номер 4")
        );
    }


}
public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String player) {
        super("Игрока с именем " + player + " не найден");
    }
}

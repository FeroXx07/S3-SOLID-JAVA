package cat.itacademy.solid.o;

public class Main {
    public static void main(String[] args) {
        InstrumentPlayer player = new InstrumentPlayer();

        player.play(new Guitar());
        player.play(new Drums());
        player.play(new Piano());
    }
}

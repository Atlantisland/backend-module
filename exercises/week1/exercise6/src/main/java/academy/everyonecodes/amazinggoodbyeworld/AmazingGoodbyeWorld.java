package academy.everyonecodes.amazinggoodbyeworld;

public class AmazingGoodbyeWorld {
    private final Goodbye goodbye;
    private final World world;

    public AmazingGoodbyeWorld(Goodbye goodbye, World world) {
        this.goodbye = goodbye;
        this.world = world;
    }

    public String get() {
        return goodbye.get() + " " + world.get();
    }

}

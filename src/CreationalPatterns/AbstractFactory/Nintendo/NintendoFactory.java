package AbstractFactory.Nintendo;
import AbstractFactory.AbstractProductVideoGameConsole;
import AbstractFactory.AbstractFactory;
public class NintendoFactory extends AbstractFactory {


    @Override
    public AbstractProductVideoGameConsole createVideoGameConsole() {
        return null;
    }

    @Override
    public AbstractProductVideoGameConsole createVideoGameController() {
        return null;
    }
}


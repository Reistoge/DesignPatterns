package AbstractFactory.Sony;
import AbstractFactory.AbstractProductVideoGameConsole;
import AbstractFactory.AbstractFactory;
public class SonyFactory extends AbstractFactory {


    @Override
    public AbstractProductVideoGameConsole createVideoGameConsole() {
        return null;
    }

    @Override
    public AbstractProductVideoGameConsole createVideoGameController() {
        return null;
    }
}

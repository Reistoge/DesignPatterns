package CreationalPatterns.AbstractFactory.Microsoft;
import AbstractFactory.AbstractProductVideoGameConsole;
import AbstractFactory.AbstractFactory;
public class MicrosoftFactory extends AbstractFactory {


    @Override
    public AbstractProductVideoGameConsole createVideoGameConsole() {
        return null;
    }

    @Override
    public AbstractProductVideoGameConsole createVideoGameController() {
        return null;
    }
}

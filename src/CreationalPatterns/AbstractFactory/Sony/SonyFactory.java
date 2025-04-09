package CreationalPatterns.AbstractFactory.Sony;

import CreationalPatterns.AbstractFactory.AbstractFactory;
import CreationalPatterns.AbstractFactory.AbstractProductVideoGameConsole;

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

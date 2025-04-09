package CreationalPatterns.AbstractFactory.Microsoft;

import CreationalPatterns.AbstractFactory.AbstractFactory;
import CreationalPatterns.AbstractFactory.AbstractProductVideoGameConsole;

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

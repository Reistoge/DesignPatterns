package CreationalPatterns.AbstractFactory.Nintendo;

import CreationalPatterns.AbstractFactory.AbstractFactory;
import CreationalPatterns.AbstractFactory.AbstractProductVideoGameConsole;

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


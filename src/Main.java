import BehavioralPatterns.Strategy.BubbleSort;
import BehavioralPatterns.Strategy.HeapSort;
import BehavioralPatterns.Strategy.IStrategy;
import StructuralPatterns.Adapter.InitialCode.OpenWeatherA;
import StructuralPatterns.Adapter.InitialCode.WeatherServiceA;
import StructuralPatterns.Adapter.Solution.WeatherServiceBAdapter;
import StructuralPatterns.Decorator.Solution.*;
import StructuralPatterns.Facade.Solution.FacadeMediaPlayer;
import StructuralPatterns.Proxy.AssetLoader;
import StructuralPatterns.Proxy.IAssetLoader;
import StructuralPatterns.Proxy.AssetLoaderProxy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


    };
    public static void FacadeTest()
    {
        // use by the client, Simple and easy to use
        FacadeMediaPlayer mediaPlayer = new FacadeMediaPlayer("song.mp3");
        mediaPlayer.turnOnMediaPlayer();

    }
    public static void AdapterTest(){
        WeatherServiceA a = new OpenWeatherA();
        a.getTemperatureInCelsius("La serena");

        // now we can use B service thanks to the new adapter Class.
        WeatherServiceA b  = new WeatherServiceBAdapter();
        b.getTemperatureInCelsius("Ovalle");
    }
    public static void strategyTest() {
        Scanner scan = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("\n=== Sorting Algorithm Selection ===");
            System.out.println("1. HeapSort");
            System.out.println("2. BubbleSort");
            System.out.println("Type 'exit' to quit");
            System.out.print("\nSelect algorithm (1/2): ");

            input = scan.nextLine();
            if (input.equals("exit")) {
                break;
            }

            IStrategy sorter = input.equals("1") ? new HeapSort() : new BubbleSort();
            System.out.print("\nEnter array size: ");
            String size = scan.nextLine();

            int n = 0;
            try {
                n = Integer.parseInt(size);
            } catch (NumberFormatException e) {
                System.out.println("\n[ERROR] Please enter a valid number");
                continue;
            }

            ArrayList<Integer> numbers = (ArrayList) (IntStream.range(0, n).boxed().collect(Collectors.toList()));
            Collections.shuffle(numbers);
            ArrayList<String> words = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "date"));

            System.out.println("\n=== Initial Arrays ===");
            System.out.println("Numbers: " + numbers);
            System.out.println("Words:   " + words);

            System.out.println("\n=== Sorted Arrays ===");
            numbers = sorter.integerSorting(numbers);
            words = sorter.stringSorting(words);
            System.out.println("Numbers: " + numbers.toString());
            System.out.println("Words:   " + words.toString());

            System.out.println("\nSorting completed! Press Enter to continue...");
            scan.nextLine();
            System.out.println("\n".repeat(50));
        }


    }

    public void decoratorTest() {
        AbstractComponent completoOrder = new ChileanCompletoComponent();
        completoOrder = new MayoDecorator(completoOrder);
        completoOrder = new PaltaDecorator(completoOrder);
        completoOrder = new PremiumSausageDecorator(completoOrder, "premium");
        completoOrder = new KetchupDecorator(completoOrder, true);
        completoOrder = new MayoDecorator(completoOrder);
        completoOrder = new PaltaDecorator(completoOrder);
        completoOrder.display();


        float totalPrice = completoOrder.getCost();
        System.out.println("total: " + totalPrice);
    }

    public void proxyTest() {
        Scanner sc = new Scanner(System.in);
        IAssetLoader assetLoader = new AssetLoader(20);
        IAssetLoader proxy = new AssetLoaderProxy(assetLoader);
        proxy.showAssetsNames();
        String input = "";
        while (!input.equals("exit")) {
            System.out.print("Please enter the name of the asset you would like to load: ");
            input = sc.nextLine();
            if (input.equals("showAssets")) {
                proxy.showAssetsNames();
                continue;
            }
            proxy.showAsset(proxy.loadAsset(input));

        }
        System.out.println("finished");
    }
}
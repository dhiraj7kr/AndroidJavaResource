import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeatherApp {
    // Mock weather data
    private static final Map<String, String> weatherData = new HashMap<>();

    static {
        weatherData.put("New York", "Sunny, 25°C");
        weatherData.put("London", "Cloudy, 18°C");
        weatherData.put("Tokyo", "Rainy, 22°C");
        weatherData.put("Mumbai", "Humid, 30°C");
        weatherData.put("Sydney", "Clear, 20°C");
    }

    // Fetch weather for a city
    private static String getWeather(String city) {
        return weatherData.getOrDefault(city, "Weather data not available for " + city);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Weather App!");
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Check Weather");
            System.out.println("2. View Supported Cities");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the city name: ");
                    String city = scanner.nextLine();
                    String weather = getWeather(city);
                    System.out.println("Weather in " + city + ": " + weather);
                    break;

                case 2:
                    System.out.println("\nSupported Cities:");
                    for (String supportedCity : weatherData.keySet()) {
                        System.out.println("- " + supportedCity);
                    }
                    break;

                case 3:
                    System.out.println("Exiting Weather App. Stay safe!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

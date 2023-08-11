import java.util.ArrayList;
import java.util.Scanner;

public class BikeManager {
	ArrayList<BikeModel> bikes = new ArrayList<>();
	private int bikeIdCounter = 1;
	private Scanner scanner = new Scanner(System.in);

	public void addNewBike() {
		System.out.print("Enter bike brand> ");
		String brand = scanner.nextLine();

		System.out.print("Enter bike model> ");
		String model = scanner.nextLine();

		System.out.print("Enter bike description > ");
		String description = scanner.nextLine();

		BikeModel newBike = new BikeModel(brand, model, description, bikeIdCounter);
		bikes.add(newBike);
		bikeIdCounter++;
		System.out.println("New bike added successfully!");
	}

	public void viewAllBikes() {
		if (bikes.isEmpty()) {
			System.out.println("No bikes registered!");
		} else {
			System.out.println("List of all bikes:");
			for (BikeModel bike : bikes) {
				System.out.println(bike);
			}
		}
	}

	public void deleteBike() {
		System.out.print("Enter the ID of the bike to delete > ");
		int idToDelete = scanner.nextInt();
		scanner.nextLine();

		boolean found = false;
		for (BikeModel bike : bikes) {
			if (bike.getId() == idToDelete) {
				bikes.remove(bike);
				found = true;
				System.out.println("Bike with ID " + idToDelete + " deleted successfully!");
				break;
			}
		}

		if (!found) {
			System.out.println("Bike with ID " + idToDelete + " not found.");
		}
	}

	public static void main(String[] args) {
		BikeManager bikeManager = new BikeManager();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Add a new bike");
			System.out.println("2. View all bikes");
			System.out.println("3. Delete a bike");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				bikeManager.addNewBike();
			} else if (choice == 2) {
				bikeManager.viewAllBikes();
			} else if (choice == 3) {
				bikeManager.deleteBike();
			} else if (choice == 4) {
				System.out.println("Exiting");
				scanner.close();
				break;
			} else {
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}

class BikeModel {
	private String brand;
	private String model;
	private String description;
	private int id;

	public BikeModel(String brand, String model, String description, int id) {
		this.brand = brand;
		this.model = model;
		this.description = description;
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Bike ID: " + id + "\nBrand: " + brand + "\nModel: " + model + "\nDescription: " + description + "\n";
	}
}
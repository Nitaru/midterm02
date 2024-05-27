public class Main {
    public static void main(String[] args) {
        // Create a new ClothingStore object
        ClothingStore store = new ClothingStore();

        // Add some brands
        store.addBrand(new Brand("Brand A"));
        store.addBrand(new Brand("Brand B"));
        store.addBrand(new Brand("Brand C"));

        // Save the state
        store.saveState();

        // Create a new ClothingStore object
        ClothingStore restoredStore = new ClothingStore();

        // Restore the state
        restoredStore.restoreState();

        // Print the restored brands
        System.out.println("Restored Brands:");
        for (Brand brand : restoredStore.getBrands()) {
            System.out.println(brand.getName());
        }
    }
}

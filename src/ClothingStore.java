// ClothingStore.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClothingStore {
    private List<Brand> brands;

    public ClothingStore() {
        this.brands = new ArrayList<>();
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void addBrand(Brand brand) {
        this.brands.add(brand);
    }

    public void removeBrand(Brand brand) {
        this.brands.remove(brand);
    }

    public void saveState() {
        try (FileWriter writer = new FileWriter("state.csv")) {
            for (Brand brand : brands) {
                writer.write(brand.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreState() {
        brands.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                brands.add(new Brand(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
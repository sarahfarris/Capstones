import java.io.*;

class Product {
  String name;
  double price;
  int quantity;

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
    this.quantity = 0;
  }

  public Product(String name) {
    this.name = name;
    String defaultProduct;
    defaultProduct = name;
    this.price = 0;
    this.quantity = 0;
  }

  public void saveToFile(String fileName) throws IOException {
    FileWriter fr;
    try {
      fr = new FileWriter(fileName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Product productA = new Product("Product A", 19.99, 10);
    // what if I made this user input?
    fr.close();
  }

  public static Product readFromFile(String fileName) throws FileNotFoundException {
    try {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line = br.readLine(); // this is the key that reads data from the file
      if (line != null) {
        String [] parts = line.split(",");
        String name = parts[0];
        double price = Double.parseDouble(parts[1]);
        int quantity = Integer.parseInt(parts[2]);
        return new Product(name, price, quantity);  //creates the product object
      } else {
        System.out.println("Invalid format: " + line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
}

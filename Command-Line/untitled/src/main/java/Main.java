public class Main {
  public static void main(String[] args) {
    Moped moped = new Moped();
    moped.setColor("red");
    moped.setFuelCapacity(5);

    HoverCraft hov = new HoverCraft();
    hov.setTerrainType("air");
    hov.setHasGPS(true);

    SemiTruck semi = new SemiTruck();
    semi.setEngineType("V12");
    semi.setCargoCapacity(100);

    Car fordFusion = new Car();
    fordFusion.setCapacity(5);
    fordFusion.setNrOfDoors(4);

    System.out.println(moped.getColor());
    System.out.println(hov.getTerrainType());
    System.out.println(semi);
  }
}

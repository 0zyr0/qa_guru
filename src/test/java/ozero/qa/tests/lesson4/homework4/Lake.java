package ozero.qa.tests.lesson4.homework4;

public class Lake {
    String name;
    String country;

    int width;
    double depth;

    public void howToDeep() {
        System.out.println("Lake " + name + " have a depht " + depth + " km");
    }

    public void climateChange() {
        width = width + 10;
        depth = depth + 1.4;
    }

    public void whereThisLake() {
        System.out.println("Lake " + name + " in " + country +" km");
    }
}

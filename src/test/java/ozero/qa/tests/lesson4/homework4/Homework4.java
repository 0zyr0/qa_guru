package ozero.qa.tests.lesson4.homework4;

public class Homework4 {


    public static void main(String[] args) {
        Lake baikal = new Lake();
        Lake komo = new Lake();

        baikal.name = "Baikal";
        baikal.country = "Russia";
        baikal.depth = 1.642;
        baikal.width = 80;
        baikal.getLocationLake();
        baikal.getDeep();
        baikal.climateChange();
        baikal.getDeep();

        System.out.println();

        komo.name = "Komo";
        komo.country = "Italy";
        komo.depth = 0.420;
        komo.width = 46;
        komo.getLocationLake();
        komo.getDeep();
        komo.climateChange();
        komo.getDeep();

        System.out.println();

        Music oxxxy = new Music();
        oxxxy.nameArtist = "Oxxxymiron";
        oxxxy.isPopular = false;
        oxxxy.albums = 2;
        oxxxy.countryArtist = "London";
        oxxxy.printAlbumsCount();
        oxxxy.showPopular();
        oxxxy.writingAlbum();
        oxxxy.changePopularity();
        oxxxy.showPopular();

        System.out.println();

        Music michaelCircle = new Music();
        michaelCircle.nameArtist = "Michail Krug";
        michaelCircle.isPopular = false;
        michaelCircle.albums = 12;
        michaelCircle.countryArtist = "USSR";
        michaelCircle.printAlbumsCount();
        michaelCircle.showPopular();
        michaelCircle.writingAlbum();
        michaelCircle.changePopularity();
        michaelCircle.showPopular();
        michaelCircle.dropPopularity();
        michaelCircle.showPopular();

    }


}

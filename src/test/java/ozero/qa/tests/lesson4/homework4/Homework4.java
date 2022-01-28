package ozero.qa.tests.lesson4.homework4;

public class Homework4 {


    public static void main(String[] args) {
        Lake Baikal = new Lake();
        Lake Komo = new Lake();

        Baikal.name = "Baikal";
        Baikal.country = "Russia";
        Baikal.depth = 1.642;
        Baikal.width = 80;
        Baikal.whereThisLake();
        Baikal.howToDeep();
        Baikal.climateChange();
        Baikal.howToDeep();

        System.out.println();

        Komo.name = "Komo";
        Komo.country = "Italy";
        Komo.depth = 0.420;
        Komo.width = 46;
        Komo.whereThisLake();
        Komo.howToDeep();
        Komo.climateChange();
        Komo.howToDeep();

        System.out.println();

        Music Oxxxy = new Music();
        Oxxxy.nameArtist = "Oxxxymiron";
        Oxxxy.isPopular = false;
        Oxxxy.albums = 2;
        Oxxxy.countryArtist = "London";
        Oxxxy.howManyAlbums();
        Oxxxy.howPopular();
        Oxxxy.writingAlbum();
        Oxxxy.changePopularity();
        Oxxxy.howPopular();

        System.out.println();

        Music MichaelCircle = new Music();
        MichaelCircle.nameArtist = "Michail Krug";
        MichaelCircle.isPopular = false;
        MichaelCircle.albums = 12;
        MichaelCircle.countryArtist = "USSR";
        MichaelCircle.howManyAlbums();
        MichaelCircle.howPopular();
        MichaelCircle.writingAlbum();
        MichaelCircle.changePopularity();
        MichaelCircle.howPopular();

    }


}

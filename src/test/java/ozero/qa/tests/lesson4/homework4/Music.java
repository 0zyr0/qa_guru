package ozero.qa.tests.lesson4.homework4;

public class Music {
    String nameArtist;
    String countryArtist;

    int albums;
    boolean isPopular;

    public void showPopular() {
        if (isPopular == true) {
            System.out.println(nameArtist + " is a popular" + " in " + countryArtist);
        }
        else {
            System.out.println(nameArtist + " is not a popular");
        }
    }

    public void changePopularity() {
        isPopular = true;
    }

    public void dropPopularity() {
        isPopular = false;
    }

    public void writingAlbum() {
        albums = albums + 1;
    }


    public void printAlbumsCount() {
        System.out.println(nameArtist + " have a " + albums);
    }


}

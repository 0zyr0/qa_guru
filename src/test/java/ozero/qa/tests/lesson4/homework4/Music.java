package ozero.qa.tests.lesson4.homework4;

public class Music {
    String nameArtist;
    String countryArtist;

    int albums;
    boolean isPopular;

    public void howPopular() {
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

    public void lostPopularity() {
        isPopular = false;
    }

    public void writingAlbum() {
        albums = albums + 1;
    }


    public void howManyAlbums() {
        System.out.println(nameArtist + " have a " + albums);
    }


}

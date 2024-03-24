package data;

import java.util.ArrayList;
public class MediaCollection {
    private final ArrayList<Media> mediaList;
    public MediaCollection() {
        mediaList = new ArrayList<>();
    }
    public void append(Media media){
        mediaList.add(media);
    }
    public static MediaCollection fromFile(String path){
        MediaCollection collection = new MediaCollection();
        //TODO
        return collection;
    }
    public void saveToFile(String path){
        // TODO
    }
}
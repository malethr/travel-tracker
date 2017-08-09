package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Guest on 8/9/17.
 */
public class Travel {

    private String location;
    private static ArrayList<Travel> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;

    public Travel (String location){
        this.location = location;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }

    public String getLocation() {
        return location;
    }

    public static ArrayList<Travel> getAll(){
        return instances;
    }

    public static void clearAllPosts(){
        instances.clear();
    }

    public boolean getPublished(){
        return this.published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId(){
        return id;
    }

    public static Travel findById(int id){
        return instances.get(id-1); //why minus 1? See if you can figure it out.
    }

}

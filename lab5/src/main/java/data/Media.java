package data;

import java.io.Serializable;

public abstract class Media implements Serializable {
    private String title;
    private boolean available;
    public Media(String title, boolean available){
        this.title = title;
        this.available = available;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean borrow() {
        if(this.isAvailable()){
            this.setAvailable(false);
            return true;
        }
        return false;
    }

    public void returnBack() {
        this.setAvailable(true);
    }
}

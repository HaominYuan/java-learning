package xml;

import java.io.Serializable;

public class Url implements Serializable {
    private String url;
    private int ID;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", ID=" + ID +
                '}';
    }


}

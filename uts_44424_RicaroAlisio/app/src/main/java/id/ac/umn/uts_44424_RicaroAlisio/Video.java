package id.ac.umn.uts_44424_RicaroAlisio;

import java.io.Serializable;

public class Video implements Serializable {
    private String judul;
    private String desc;
    private String link;
    private int image;
    private int uri;

    public Video(String judul, String desc, String link,  int uri){
        this.link = link;
        this.judul = judul;
        this.desc = desc;
        this.uri = uri;
    }
    public String getLink(){

        return link;
    }
    public int getUri(){
        return uri;
    }
    public String getDesc(){
        return desc;
    }
    public String getJudul(){
        return judul;
    }
    public String toString() {
        return "Video{" +
                "title='" + judul + '\'' +
                ", description='" + desc + '\'' +
                ", resourceLink='" + link + '\'' +
                ", uri=" + uri +
                '}';
    }
}

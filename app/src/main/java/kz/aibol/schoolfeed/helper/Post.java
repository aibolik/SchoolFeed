package kz.aibol.schoolfeed.helper;

/**
 * SchoolFeed
 * Created by Aibol Kussain on 5/27/2015.
 * For support information write kussain@aibol.kz
 */
public class Post {
    String name;
    String date;
    String content;

    public Post(String name, String date, String content) {
        this.name = name;
        this.date = date;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

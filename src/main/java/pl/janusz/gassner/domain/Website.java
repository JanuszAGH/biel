package pl.janusz.gassner.domain;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class Website {

    private String url;
    private String name;
    private String category;
    private String status;

    public Website() {

    }

    @Override
    public String toString() {

        return "Website{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }
}

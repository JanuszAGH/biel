package pl.janusz.ahmad.jackson.xml.first;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class PhoneDetails {

    private String name;
    private String displaySize;
    private String memory;

    public PhoneDetails(String name, String displaySize, String memory) {

        this.name = name;
        this.displaySize = displaySize;
        this.memory = memory;
    }

    public PhoneDetails() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDisplaySize() {

        return displaySize;
    }

    public void setDisplaySize(String displaySize) {

        this.displaySize = displaySize;
    }

    public String getMemory() {

        return memory;
    }

    public void setMemory(String memory) {

        this.memory = memory;
    }

    @Override
    public String toString() {

        return "PhoneDetails{" +
                "name='" + name + '\'' +
                ", displaySize='" + displaySize + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}

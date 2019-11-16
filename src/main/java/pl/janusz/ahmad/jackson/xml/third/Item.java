package pl.janusz.ahmad.jackson.xml.third;

/**
 * Created by Janusz Kacki on 16/11/2019. Project; bielmarcus
 */
public class Item {

    private String date;
    private String mode;
    private String unit;
    private String current;
    private String interactive;

    public Item() {

    }

    @Override
    public String toString() {

        return "Item{" +
                "date='" + date + '\'' +
                ", mode='" + mode + '\'' +
                ", unit='" + unit + '\'' +
                ", current='" + current + '\'' +
                ", interactive='" + interactive + '\'' +
                '}';
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getMode() {

        return mode;
    }

    public void setMode(String mode) {

        this.mode = mode;
    }

    public String getUnit() {

        return unit;
    }

    public void setUnit(String unit) {

        this.unit = unit;
    }

    public String getCurrent() {

        return current;
    }

    public void setCurrent(String current) {

        this.current = current;
    }

    public String getInteractive() {

        return interactive;
    }

    public void setInteractive(String interactive) {

        this.interactive = interactive;
    }
}

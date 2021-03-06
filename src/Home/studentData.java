package Home;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class studentData{
    private final StringProperty USN;
    private final StringProperty Name;

    public studentData(String usn,String name){
        this.USN=new SimpleStringProperty(usn);
        this.Name=new SimpleStringProperty(name);
    }

    public String getUSN() {
        return USN.get();
    }

    public StringProperty USNProperty() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN.set(USN);
    }

    public String getName() {
        return Name.get();
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }
}
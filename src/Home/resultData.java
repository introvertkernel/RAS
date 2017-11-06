package Home;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class resultData {
    private final StringProperty rColUsn;
    private final StringProperty rColName;
    private final IntegerProperty rColSub1;
    private final IntegerProperty rColSub2;
    private final IntegerProperty rColSub3;
    private final IntegerProperty rColSub4;
    private final IntegerProperty rColSub5;
    private final IntegerProperty rColSub6;
    private final IntegerProperty rColSub7;
    private final IntegerProperty rColSub8;
    private final IntegerProperty rColTotal;

    public resultData(String usn,String name,Integer sub1,Integer sub2,Integer sub3,Integer sub4,Integer sub5,Integer sub6,Integer sub7,Integer sub8,Integer total){
        this.rColUsn = new SimpleStringProperty(usn);
        this.rColName = new SimpleStringProperty(name);
        this.rColSub1 = new SimpleIntegerProperty(sub1);
        this.rColSub2 = new SimpleIntegerProperty(sub2);
        this.rColSub3 = new SimpleIntegerProperty(sub3);
        this.rColSub4 = new SimpleIntegerProperty(sub4);
        this.rColSub5 = new SimpleIntegerProperty(sub5);
        this.rColSub6 = new SimpleIntegerProperty(sub6);
        this.rColSub7 = new SimpleIntegerProperty(sub7);
        this.rColSub8 = new SimpleIntegerProperty(sub8);
        this.rColTotal = new SimpleIntegerProperty(total);
    }

    public String getrColUsn() {
        return rColUsn.get();
    }

    public StringProperty rColUsnProperty() {
        return rColUsn;
    }

    public void setrColUsn(String rColUsn) {
        this.rColUsn.set(rColUsn);
    }

    public String getrColName() {
        return rColName.get();
    }

    public StringProperty rColNameProperty() {
        return rColName;
    }

    public void setrColName(String rColName) {
        this.rColName.set(rColName);
    }

    public int getrColSub1() {
        return rColSub1.get();
    }

    public IntegerProperty rColSub1Property() {
        return rColSub1;
    }

    public void setrColSub1(int rColSub1) {
        this.rColSub1.set(rColSub1);
    }

    public int getrColSub2() {
        return rColSub2.get();
    }

    public IntegerProperty rColSub2Property() {
        return rColSub2;
    }

    public void setrColSub2(int rColSub2) {
        this.rColSub2.set(rColSub2);
    }

    public int getrColSub3() {
        return rColSub3.get();
    }

    public IntegerProperty rColSub3Property() {
        return rColSub3;
    }

    public void setrColSub3(int rColSub3) {
        this.rColSub3.set(rColSub3);
    }

    public int getrColSub4() {
        return rColSub4.get();
    }

    public IntegerProperty rColSub4Property() {
        return rColSub4;
    }

    public void setrColSub4(int rColSub4) {
        this.rColSub4.set(rColSub4);
    }

    public int getrColSub5() {
        return rColSub5.get();
    }

    public IntegerProperty rColSub5Property() {
        return rColSub5;
    }

    public void setrColSub5(int rColSub5) {
        this.rColSub5.set(rColSub5);
    }

    public int getrColSub6() {
        return rColSub6.get();
    }

    public IntegerProperty rColSub6Property() {
        return rColSub6;
    }

    public void setrColSub6(int rColSub6) {
        this.rColSub6.set(rColSub6);
    }

    public int getrColSub7() {
        return rColSub7.get();
    }

    public IntegerProperty rColSub7Property() {
        return rColSub7;
    }

    public void setrColSub7(int rColSub7) {
        this.rColSub7.set(rColSub7);
    }

    public int getrColSub8() {
        return rColSub8.get();
    }

    public IntegerProperty rColSub8Property() {
        return rColSub8;
    }

    public void setrColSub8(int rColSub8) {
        this.rColSub8.set(rColSub8);
    }

    public int getrColTotal() {
        return rColTotal.get();
    }

    public IntegerProperty rColTotalProperty() {
        return rColTotal;
    }

    public void setrColTotal(int rColTotal) {
        this.rColTotal.set(rColTotal);
    }
}

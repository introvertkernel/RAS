package Home;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class analysisData {
    private final StringProperty aColUsn;
    //private final StringProperty aColName;
    private final IntegerProperty aColSub1;
    private final IntegerProperty aColSub2;
    private final IntegerProperty aColSub3;
    private final IntegerProperty aColSub4;
    private final IntegerProperty aColSub5;
    private final IntegerProperty aColSub6;
    private final IntegerProperty aColSub7;
    private final IntegerProperty aColSub8;
    private final IntegerProperty aColTotal;

    public analysisData(String usn,Integer sub1,Integer sub2,Integer sub3,Integer sub4,Integer sub5,Integer sub6,Integer sub7,Integer sub8,Integer total){
        this.aColUsn = new SimpleStringProperty(usn);
        //this.aColName = new SimpleStringProperty(name);
        this.aColSub1 = new SimpleIntegerProperty(sub1);
        this.aColSub2 = new SimpleIntegerProperty(sub2);
        this.aColSub3 = new SimpleIntegerProperty(sub3);
        this.aColSub4 = new SimpleIntegerProperty(sub4);
        this.aColSub5 = new SimpleIntegerProperty(sub5);
        this.aColSub6 = new SimpleIntegerProperty(sub6);
        this.aColSub7 = new SimpleIntegerProperty(sub7);
        this.aColSub8 = new SimpleIntegerProperty(sub8);
        this.aColTotal = new SimpleIntegerProperty(total);
    }

    public String getaColUsn() {
        return aColUsn.get();
    }

    public StringProperty aColUsnProperty() {
        return aColUsn;
    }

    public void setaColUsn(String aColUsn) {
        this.aColUsn.set(aColUsn);
    }

    public int getaColSub1() {
        return aColSub1.get();
    }

    public IntegerProperty aColSub1Property() {
        return aColSub1;
    }

    public void setaColSub1(int aColSub1) {
        this.aColSub1.set(aColSub1);
    }

    public int getaColSub2() {
        return aColSub2.get();
    }

    public IntegerProperty aColSub2Property() {
        return aColSub2;
    }

    public void setaColSub2(int aColSub2) {
        this.aColSub2.set(aColSub2);
    }

    public int getaColSub3() {
        return aColSub3.get();
    }

    public IntegerProperty aColSub3Property() {
        return aColSub3;
    }

    public void setaColSub3(int aColSub3) {
        this.aColSub3.set(aColSub3);
    }

    public int getaColSub4() {
        return aColSub4.get();
    }

    public IntegerProperty aColSub4Property() {
        return aColSub4;
    }

    public void setaColSub4(int aColSub4) {
        this.aColSub4.set(aColSub4);
    }

    public int getaColSub5() {
        return aColSub5.get();
    }

    public IntegerProperty aColSub5Property() {
        return aColSub5;
    }

    public void setaColSub5(int aColSub5) {
        this.aColSub5.set(aColSub5);
    }

    public int getaColSub6() {
        return aColSub6.get();
    }

    public IntegerProperty aColSub6Property() {
        return aColSub6;
    }

    public void setaColSub6(int aColSub6) {
        this.aColSub6.set(aColSub6);
    }

    public int getaColSub7() {
        return aColSub7.get();
    }

    public IntegerProperty aColSub7Property() {
        return aColSub7;
    }

    public void setaColSub7(int aColSub7) {
        this.aColSub7.set(aColSub7);
    }

    public int getaColSub8() {
        return aColSub8.get();
    }

    public IntegerProperty aColSub8Property() {
        return aColSub8;
    }

    public void setaColSub8(int aColSub8) {
        this.aColSub8.set(aColSub8);
    }

    public int getaColTotal() {
        return aColTotal.get();
    }

    public IntegerProperty aColTotalProperty() {
        return aColTotal;
    }

    public void setaColTotal(int aColTotal) {
        this.aColTotal.set(aColTotal);
    }
}

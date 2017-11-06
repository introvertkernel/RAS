package Home;

public enum option {
    SEM1,SEM2,SEM3,SEM4,SEM5,SEM6,SEM7,SEM8;
    private option(){}
    public String value()
    {
        return name();
    }
    public static option fromvalue(String v)
    {
        return valueOf(v);
    }
}
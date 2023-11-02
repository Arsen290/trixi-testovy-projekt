package cz.project.trixitest.models;

public class CastObce {
    private int code; // Code of the part locality
    private String name;
    private int obecCode; // Code of the locality

    public CastObce(int code, String name, int obecCode) {
        this.code = code;
        this.name = name;
        this.obecCode = obecCode;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getObecCode() {
        return obecCode;
    }
}
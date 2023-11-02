package cz.project.trixitest.models;


public class Obec {
    private int code;
    private String name;

    public Obec(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

package Entities;

public abstract class TaxPayer {

    protected String name;
    protected Double anualIcome;

    public TaxPayer(String name, Double anualIcome) {
        this.name = name;
        this.anualIcome = anualIcome;
    }

    public abstract Double tax();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnualIcome() {
        return anualIcome;
    }

    public void setAnualIcome(Double anualIcome) {
        this.anualIcome = anualIcome;
    }
}

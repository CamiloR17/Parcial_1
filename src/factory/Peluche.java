package src.factory;

import src.singleton.Menu;

public class Peluche implements Juguete{

    private Integer id;
    private final String color;
    private final String materiaExterior;
    private final String relleno;

    public Peluche(Integer id, String color, String materiaExterior, String relleno) {
        this.id = id;
        this.color = color;
        this.materiaExterior = materiaExterior;
        this.relleno = relleno;
    }

    public Peluche(Peluche peluche) {
        this.id = Menu.getJugetes().size() + 1;
        this.color = peluche.color;
        this.materiaExterior = peluche.materiaExterior;
        this.relleno = peluche.relleno;
    }

    public Peluche clone() {
        return new Peluche(this);
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer index) {
        this.id = index;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getType() {
        return 2;
    }

    public static Peluche.PelucheBuilder builder() {return new Peluche.PelucheBuilder();}
    public static class PelucheBuilder {

        private Integer id;
        private String color;
        private String materiaExterior;
        private String relleno;

        public Peluche.PelucheBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public Peluche.PelucheBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Peluche.PelucheBuilder materiaExterior(String materiaExterior) {
            this.materiaExterior = materiaExterior;
            return this;
        }

        public Peluche.PelucheBuilder relleno(String relleno) {
            this.relleno = relleno;
            return this;
        }

        public Peluche build() {
            return new Peluche(id, color, materiaExterior, relleno);
        }
    }

    @Override
    public String toString() {
        return "Peluche |" +
                " id: " + id +
                " | color: " + color +
                " | materiaExterior: " + materiaExterior +
                " | relleno: " + relleno +
                " |";
    }
}

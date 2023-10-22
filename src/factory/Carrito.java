package src.factory;

import src.singleton.Menu;

public class Carrito implements Juguete{

    private Integer id;
    private final String color;
    private final String marca;
    private final String numPuertas;

    public Carrito(Integer id, String color, String marca, String numPuertas) {
        this.id = id;
        this.color = color;
        this.marca = marca;
        this.numPuertas = numPuertas;
    }

    public Carrito(Carrito carrito) {
        this.id = Menu.getJugetes().size() + 1;
        this.color = carrito.color;
        this.marca = carrito.marca;
        this.numPuertas = carrito.numPuertas;
    }

    @Override
    public Carrito clone() {
        return new Carrito(this);
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
        return 1;
    }

    public String getNumberDoors() {
        return this.numPuertas;
    }

    public static CarritoBuilder builder() {return new CarritoBuilder();}
    public static class CarritoBuilder {

        private Integer id;
        private String color;
        private String marca;
        private String numPuertas;

        public CarritoBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public CarritoBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarritoBuilder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public CarritoBuilder numPuertas(String numPuertas) {
            this.numPuertas = numPuertas;
            return this;
        }

        public Carrito build() {
            return new Carrito(id, color, marca, numPuertas);
        }
    }

    @Override
    public String toString() {
        return "Carrito |" +
                " id: " + id +
                " | color: " + color +
                " | marca: " + marca +
                " | numPuertas: " + numPuertas +
                " |";
    }
}

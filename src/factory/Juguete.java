package src.factory;

public interface Juguete {
    Integer getId();
    String getColor();
    Juguete clone();
    void setId(Integer index);


}

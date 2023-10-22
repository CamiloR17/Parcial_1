package src.factory;

public interface Juguete {
    Integer getId();
    void setId(Integer index);
    String getColor();
    Integer getType();
    Juguete clone();


}

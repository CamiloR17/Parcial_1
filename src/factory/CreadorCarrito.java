package src.factory;

import src.singleton.Menu;
import src.utils.KeyBoard;

public class CreadorCarrito implements CreadorJuguete{
    @Override
    public Juguete crear() {
        System.out.println("\t\t= CARRITO =");
        return Carrito.builder().
                id(Menu.getJugetes().size() + 1).
                color(KeyBoard.str("\t> Color ")).
                marca(KeyBoard.str("\t> Marca ")).
                numPuertas(KeyBoard.str("\t> Numero de puertas ")).
                build();
    }
}

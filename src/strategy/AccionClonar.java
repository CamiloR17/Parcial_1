package src.strategy;

import src.factory.Carrito;
import src.factory.Juguete;
import src.factory.Peluche;
import src.singleton.Menu;
import src.utils.KeyBoard;

import java.util.ArrayList;
import java.util.List;

public class AccionClonar implements Accion{

    @Override
    public void aplicar() {
        System.out.println("\n\t   -----------------------");
        System.out.println("\t\tCLONACIÓN DE JUGUETES\n");
        int iter = KeyBoard.Int("ingrese el numero de clones deseados");
        int nc = KeyBoard.Int("ingrese el id del juguete a clonar");
        for (int i = 0; i < iter; i++) {
            Juguete juguete = Menu.getJugetes().get(nc - 1).clone();
            Menu.getJugetes().add(juguete);
        }


    }

    @Override
    public int getOpcion() {
        return 2;
    }
}

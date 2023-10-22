package src.strategy;

import src.factory.Juguete;
import src.singleton.Menu;

public class AccionRegistro implements Accion{
    @Override
    public void aplicar() {
        System.out.println("\n\t   ----------------------");
        System.out.println("\t\tREGISTRO DE JUGUETES\n");

        for (Juguete juguete : Menu.getJugetes()) {
            System.out.println(juguete);
        }
        System.out.println();
    }

    @Override
    public int getOpcion() {
        return 4;
    }
}

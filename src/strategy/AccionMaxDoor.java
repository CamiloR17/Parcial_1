package src.strategy;

import src.factory.Carrito;
import src.factory.Juguete;
import src.singleton.Menu;

import java.util.Comparator;
import java.util.Optional;

public class AccionMaxDoor implements Accion{
    @Override
    public void aplicar() {
        System.out.println("\n\t   -------------------------");
        System.out.println("\t\tMÁXIMO NUMERO DE PUERTAS DE LOS CARRITOS\n");

        Optional<Juguete> jugueteFilter = Menu.getJugetes().stream()
                .filter(juguete -> juguete instanceof Carrito)
                .max(Comparator.comparing(juguete -> ((Carrito) juguete).getNumberDoors()));

        System.out.println("\t" + jugueteFilter);
    }

    @Override
    public int getOpcion() {
        return 6;
    }
}

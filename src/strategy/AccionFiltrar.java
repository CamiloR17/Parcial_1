package src.strategy;

import src.factory.Juguete;
import src.singleton.Menu;
import src.utils.KeyBoard;

import java.util.Set;
import java.util.stream.Collectors;

public class AccionFiltrar implements Accion{
    @Override
    public void aplicar() {
        System.out.println("\n\t   -------------------------");
        System.out.println("\t\tFILTRAR POR JUGUETES\n");

        int type = KeyBoard.Int("Ingrese el tipo del juguete: [1]-Carrito o [2]-Peluche \n");

        Set<Juguete> jugueteFilter = Menu.getJugetes().stream()
                .filter(juguete -> juguete.getType().equals(type))
                .collect(Collectors.toSet());

        jugueteFilter.forEach(System.out::println);
    }

    @Override
    public int getOpcion() {
        return 5;
    }
}

package src.strategy;

import src.factory.Juguete;
import src.singleton.Menu;
import src.utils.KeyBoard;
import java.util.Set;
import java.util.stream.Collectors;

public class AccionEliminarColor implements Accion{
    @Override
    public void aplicar() {
        System.out.println("\n\t   -------------------------");
        System.out.println("\t\tELIMINAR POR COLOR\n");

        System.out.println("\t= Colores =");
        Menu.getJugetes().stream()
                .map(Juguete::getColor)
                .distinct()
                .forEach(System.out::println);

        String color = KeyBoard.str("\n> Ingrese el color de los juguetes a eliminar ");

        Set<Juguete> jugueteSet = Menu.getJugetes().stream()
                .filter(juguete -> juguete.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toSet());

        Menu.getJugetes().removeAll(jugueteSet);
        Menu.OrganizarIds(); // Método que organiza id con IntStream :D
    }

    @Override
    public int getOpcion() {
        return 8;
    }
}

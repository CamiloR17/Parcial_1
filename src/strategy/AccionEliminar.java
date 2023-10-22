package src.strategy;

import src.factory.Juguete;
import src.singleton.Menu;
import src.utils.KeyBoard;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccionEliminar implements Accion{
    @Override
    public void aplicar() {
        System.out.println("\n\t   -------------------------");
        System.out.println("\t\tELIMINACIÓN DE JUGUETES\n");
        int index = 0;
        do {
            try {
                index = KeyBoard.Int("\t> ID a eliminar");

                if (index < 0 || index > Menu.getJugetes().size()) System.out.println("\n\t\t * ID no encontrado *");
            }catch (InputMismatchException e) {
                System.out.println("\n\t\t * ERROR - Digite números *\n");
            }
        }while (index < 0 || index > Menu.getJugetes().size());

        List<Juguete> juguetes = new ArrayList<>(Menu.getJugetes());
        Juguete juguete1 = juguetes.get(index-1);

        Set<Juguete> juguetesFilter = juguetes.stream()
                .filter(juguete -> juguete.equals(juguete1) )
                .collect(Collectors.toSet());

        juguetesFilter.forEach(juguete -> Menu.getJugetes().remove(juguete));

        Menu.OrganizarIds(); // Método que organiza id con IntStream :D


    }
    @Override
    public int getOpcion() {
        return 3;
    }
}

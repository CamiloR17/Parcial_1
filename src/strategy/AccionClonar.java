package src.strategy;

import src.factory.Juguete;
import src.singleton.Menu;
import src.utils.KeyBoard;

import java.util.*;
import java.util.stream.Collectors;

public class AccionClonar implements Accion{

    @Override
    public void aplicar() {
        System.out.println("\n\t   -----------------------");
        System.out.println("\t\tCLONACIÓN DE JUGUETES\n");
        int iter = 0, nc = 0;
        do {
            try {
                iter = KeyBoard.Int("\t> Numero de clones deseados");
                nc = KeyBoard.Int("\t> Ingrese el id del juguete a clonar");
                System.out.println();

                if (nc < 1 || nc > Menu.getJugetes().size()) System.out.println("\t\t * ID no encontrado *\n");
            }catch (InputMismatchException e) {
                System.out.println("\n\t\t * ERROR - Digite números validos *\n");
            }

        }while ((nc < 1 || nc > Menu.getJugetes().size()) || iter < 0);

        List<Juguete> juguetes = new ArrayList<>(Menu.getJugetes());
        Juguete juguete1 = juguetes.get(nc-1);

        for (int i = 0; i < iter; i++) {
            Set<Juguete> juguetesFilter = juguetes.stream()
                    .filter(juguete -> juguete.equals(juguete1))
                    .collect(Collectors.toSet());

            juguetesFilter.forEach(juguete -> Menu.getJugetes().add(juguete.clone()));
        }

        System.out.println("\t\t= CLONACIÓN EXITOSA =");
    }

    @Override
    public int getOpcion() {
        return 2;
    }
}

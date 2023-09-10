package src.strategy;

import src.factory.Juguete;
import src.singleton.Menu;
import src.utils.KeyBoard;
import java.util.InputMismatchException;

public class AccionClonar implements Accion{

    @Override
    public void aplicar() {
        System.out.println("\n\t   -----------------------");
        System.out.println("\t\tCLONACIÓN DE JUGUETES\n");
        int iter, nc;
        do {
            try {
                iter = KeyBoard.Int("\t> Numero de clones deseados");
                nc = KeyBoard.Int("\t> Ingrese el id del juguete a clonar");
            }catch (InputMismatchException e) {
                System.out.println("\n\t\t * ERROR - Digite números *\n");
                continue;
            }
            break;
        }while (true);


        for (int i = 0; i < iter; i++) {
            Juguete juguete = Menu.getJugetes().get(nc - 1).clone();
            Menu.getJugetes().add(juguete);
        }

        System.out.println("\n\t\t= CLONACIÓN EXITOSA =");
    }

    @Override
    public int getOpcion() {
        return 2;
    }
}

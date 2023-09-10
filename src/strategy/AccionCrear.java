package src.strategy;

import src.factory.CreadorCarrito;
import src.factory.CreadorJuguete;
import src.factory.CreadorPeluche;
import src.factory.Juguete;
import src.singleton.Menu;
import src.utils.KeyBoard;

import java.util.InputMismatchException;

public class AccionCrear implements Accion{
    CreadorJuguete creadorJugueteC = new CreadorCarrito();
    CreadorJuguete creadorJugueteP = new CreadorPeluche();

    @Override
    public void aplicar() {

        System.out.println("\n\t   ---------------------");
        System.out.println("\t\tCREACIÓN DE JUGUETES\n");

        int tipoJuguete;
        do {
            try {
                tipoJuguete = KeyBoard.Int("[1] -> Carrito   |   [2] -> Peluche\n  ");
            }catch (InputMismatchException e) {
                System.out.println("\n\t\t * ERROR - Digite un numero *\n");
                continue;
            }
            break;
        }while (true);

        System.out.println();
        if (tipoJuguete == 1) {
            Juguete juguete = crearJuguete(creadorJugueteC);

            Menu.getJugetes().add(juguete);
        } else if (tipoJuguete == 2) {
            Juguete juguete = crearJuguete(creadorJugueteP);

            Menu.getJugetes().add(juguete);
        }else {
            System.out.println("\n\t\t * Opción desconocida *  ");
        }


    }
    @Override
    public int getOpcion() {
        return 1;
    }

    public static Juguete crearJuguete(CreadorJuguete creadorJuguete) {
        return creadorJuguete.crear();
    }
}

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

        int tipoJuguete = 0;
        do {
            try {
                tipoJuguete = KeyBoard.Int("[1] -> Carrito   |   [2] -> Peluche\n  ");

                if (tipoJuguete < 1 || tipoJuguete > 2) System.out.println("\n\t\t * Tipo desconocido *");
            }catch (InputMismatchException e) {
                System.out.println("\n\t\t * ERROR - Digite un numero *\n");
            }
        }while (tipoJuguete < 1 || tipoJuguete > 2);

        System.out.println();

        Juguete juguete;
        if (tipoJuguete == 1) {
            juguete = crearJuguete(creadorJugueteC);
        } else {
            juguete = crearJuguete(creadorJugueteP);
        }
        Menu.getJugetes().add(juguete);


    }
    @Override
    public int getOpcion() {
        return 1;
    }

    public static Juguete crearJuguete(CreadorJuguete creadorJuguete) {
        return creadorJuguete.crear();
    }
}

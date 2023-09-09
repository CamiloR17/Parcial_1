package src.factory;

import src.singleton.Menu;
import src.utils.KeyBoard;

public class CreadorPeluche implements CreadorJuguete{

    public Juguete crear() {
        System.out.println("\t\t= PELUCHE =");
        return Peluche.builder().
                id(Menu.getJugetes().size() + 1).
                color(KeyBoard.str("\t> Color ")).
                materiaExterior(KeyBoard.str("\t> Material exterior ")).
                relleno(KeyBoard.str("\t> Relleno ")).
                build();
    }
}

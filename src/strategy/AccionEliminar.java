package src.strategy;

import src.singleton.Menu;
import src.utils.KeyBoard;
import java.util.InputMismatchException;

public class AccionEliminar implements Accion{
    @Override
    public void aplicar() {
        System.out.println("\n\t   -------------------------");
        System.out.println("\t\tELIMINACIÓN DE JUGUETES\n");
        int index;
        do {
            try {
                index = KeyBoard.Int("\t> ID a eliminar");
            }catch (InputMismatchException e) {
                System.out.println("\n\t\t * ERROR - Digite números *\n");
                continue;
            }
            break;
        }while (true);

        boolean bool = true;
        for (int i = (index - 1); i < Menu.getJugetes().size(); i++) {
            if (bool) {
                Menu.getJugetes().remove(Menu.getJugetes().get(i));
                bool = false;
            }
            Menu.getJugetes().get(i).setId(i+1);
        }


    }
    @Override
    public int getOpcion() {
        return 3;
    }
}

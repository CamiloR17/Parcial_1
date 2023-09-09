package src.strategy;

public class AccionEliminar implements Accion{
    @Override
    public void aplicar() {
        System.out.println("\n\t   -------------------------");
        System.out.println("\t\tELIMINACIÓN DE JUGUETES\n");


    }

    @Override
    public int getOpcion() {
        return 3;
    }
}

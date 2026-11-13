public class EjemploHilos {

    public static void main(String[] args) {
        Thread hilo1 = new Thread(new TareaTrabajador
        ("Juan Martinez", 1000));
        Thread hilo2 = new Thread(new TareaTrabajador
        ("Pedro Ramirez", 1500));
        Thread hilo3 = new Thread(new TareaTrabajador
        ("Alejandro Quintero", 2000));

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
    
    private static class TareaTrabajador implements Runnable {
    private String nombreTrabajador;
    private int tiempoEspera;

    public TareaTrabajador(String nombreTrabajador, int tiempoEspera) {
        this.nombreTrabajador = nombreTrabajador;
        this.tiempoEspera = tiempoEspera;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombreTrabajador + " realiza la tarea " + i);
            
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                System.out.println("El hilo de " + nombreTrabajador + " fue interrumpido.");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("----- " + nombreTrabajador + 
                " ha finalizado todas sus tareas." + " -----");
    }
}
}
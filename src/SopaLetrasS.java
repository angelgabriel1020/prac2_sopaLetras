import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SopaLetrasS {
    private final String[] categ = {"Flores","Colores","Instrumentos musicales","Películas"};
    private final String[] animales = {};

    public SopaLetrasS() {
        try {
            ServerSocket s = new ServerSocket(3500);
            s.setReuseAddress(true);
            System.out.println("Servidor iniciado, esperando clientes...");

            for (;;){
                Socket cl = s.accept();
                System.out.println("Cliente conectado desde  "+cl.getInetAddress()+" : "+cl.getPort());

                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
                oos.writeObject(categ);
                oos.flush();

                while (true){
                    String elec = (String) ois.readObject();
                    System.out.println("elec = " + elec);

                    //agarrar aleatoriamente unas 10 palabras de una lista total de 20

                    //guardar en una lista las palabras elegidas
                    //colocar las palabras en una matriz de 16*16
                    //registrar por cada palabra, su coordenada de inicio, su coordenada de fin

                    //rellenar aleatoriamente el resto de la matriz

                    //enviar al cliente la lista de palabras
                    //enviar al cliente las coordenadas de inicio y fin
                    //enviar al cliente la matriz

                    if(elec.equals("salir")) break;
                }

                oos.close();
                ois.close();
                cl.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SopaLetrasS();
    }
}

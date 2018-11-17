import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client1 {
    public static void main(String[] args) {
        try {
            System.out.println("RMI client started ...");
            IStock iStock = (IStock) Naming.lookup("rmi://127.0.0.1:1099/stock");
            System.out.println("RMI client connected ...");
            String idArticle = "ordinateur";
            iStock.creer_article(idArticle, 6);
            System.out.println("article créé avec succés");
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

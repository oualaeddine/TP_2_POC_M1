import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            IStock iStock = (IStock) Naming.lookup("rmi://127.0.0.1/stock");
            String idArticle = "ordinateur";
            boolean result = iStock.vendre(idArticle, 3);
            if (result) {
                System.out.println("articles restants : " + iStock.etat_article(idArticle).getQuantity());
            } else {
                System.out.println("Quantité insuffisante");
            }
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

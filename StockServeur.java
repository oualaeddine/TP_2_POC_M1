

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.RMISecurityManager;
public class StockServeur {

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            // if (System.getSecurityManager() == null)
            // System.setSecurityManager(new RMISecurityManager());

            LocateRegistry.createRegistry(1099);
            StockImpl obj = new StockImpl();
            Naming.rebind("rmi://127.0.0.1/stock", obj);
            System.out.println("server is running ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

}

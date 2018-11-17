import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStock extends Remote {
    void creer_article(String id, int Q_initiale) throws RemoteException;

    boolean vendre(String id, int Q)throws RemoteException;

    void approvisionner(String id, int Q)throws RemoteException;

    Etat etat_article(String id)throws RemoteException;
}

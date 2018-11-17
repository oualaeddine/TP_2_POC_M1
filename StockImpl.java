
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StockImpl extends UnicastRemoteObject implements IStock {
    private ArrayList<Article> articles;

    public StockImpl() throws RemoteException {
        articles = new ArrayList<>();
    }

    @Override
    public void creer_article(String id, int Q_initiale) {
        Article article = new Article();
        article.setId(id);

        Etat etat = new Etat();
        etat.setQuantity(Q_initiale);
        article.setEtat(etat);
        articles.add(article);
    }

    @Override
    public boolean vendre(String id, int Q) {
        int key = findArticleKey(id);
        if (key != Integer.MAX_VALUE) {
            Article article = articles.get(key);

            Etat etat = article.getEtat();
            int currentQuantity = etat.getQuantity();

            if (currentQuantity < Q) {
                return false;
            } else {
                int newQuantity = currentQuantity - Q;
                etat.setQuantity(newQuantity);
                article.setEtat(etat);
                articles.set(key, article);
                return true;
            }
        } else return false;
    }

    @Override
    public void approvisionner(String id, int Q) {
        int key = findArticleKey(id);
        if (key != Integer.MAX_VALUE) {
            Article article = articles.get(key);
            Etat etat = article.getEtat();
            int currentQuantity = etat.getQuantity();
            int newQuantity = currentQuantity + Q;
            etat.setQuantity(newQuantity);
            article.setEtat(etat);
            articles.set(key, article);
        }
    }

    @Override
    public Etat etat_article(String id) {
        return articles.get(findArticleKey(id)).getEtat();
    }

    private int findArticleKey(String id) {
        for (Article a : articles) {
            if (a.getId().equals(id))
                return articles.indexOf(a);
        }

        return Integer.MAX_VALUE;
    }

}

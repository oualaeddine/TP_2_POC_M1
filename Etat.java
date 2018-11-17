import java.io.Serializable;
import java.time.LocalDateTime;

public class Etat implements Serializable {
    private LocalDateTime updated_at;
    private int quantity;

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        LocalDateTime timestamp = LocalDateTime.now();
    }
}

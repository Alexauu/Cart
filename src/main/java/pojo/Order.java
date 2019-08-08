package pojo;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-08-08 11:00
 */

public class Order {
    int id;
    User user;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

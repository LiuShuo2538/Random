package Practice.com.entity;

/**
 * Created by ${LiuShuo} on 8/15/2016.
 */
public class Persion {
    private String name;

    public Persion() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                '}';
    }
}

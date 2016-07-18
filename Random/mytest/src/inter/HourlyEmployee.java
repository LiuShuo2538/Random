package inter;

/**
 * Created by ${LiuShuo} on 2016/7/4.
 */
public class HourlyEmployee extends Employee{
    private int wage;
    private  int hour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(int wage, int hour) {
        this.wage = wage;
        this.hour = hour;
    }

    public HourlyEmployee(String name, int age, MyDate birthday, int wage, int hour) {
        super(name, age, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public int earnings() {
        return wage*hour;
    }

    @Override
    public String toString() {
        return super.toString() + earnings();
    }
}

package inter;

/**
 * Created by ${LiuShuo} on 2016/7/4.
 */
public class EmployeeAbstract extends Employee {

    private int monthlySalary;


    public EmployeeAbstract() {
        super();
    }

    public EmployeeAbstract(String name, int age, MyDate birthday, int monthlySalary) {
        super(name, age, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public MyDate getBirthday() {
        return super.getBirthday();
    }

    @Override
    public void setBirthday(MyDate birthday) {
        super.setBirthday(birthday);
    }

    @Override
    public int earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + earnings();
    }
}

package inter;

import java.util.Scanner;

/**
 * Created by ${LiuShuo} on 2016/7/4.
 */
public class Test {
    public static void main(String[] args) {
        Employee[] arrE = new Employee[5];
        arrE[0] = new EmployeeAbstract("张1",12,new MyDate("1999","9","9"),8000);
        arrE[1] = new EmployeeAbstract("张2",12,new MyDate("1999","9","9"),8000);
        arrE[2] = new EmployeeAbstract("张3",12,new MyDate("1999","9","9"),8000);
        arrE[3] = new EmployeeAbstract("张4",12,new MyDate("1999","9","9"),8000);
        arrE[4] = new EmployeeAbstract("张5",12,new MyDate("1999","9","9"),8000);
        System.out.print("输入1");
        Scanner scan = new Scanner(System.in);
        System.out.print("输入");
        String month = scan.nextLine();




        for (Employee employee : arrE) {
            String month1 = employee.getBirthday().getMonth();


            if (month.equals(month1)){

                employee.setAge(employee.getAge()+10);
            }

            System.out.println(employee);
        }




    }
}

package dynamiccompiler.myimplememt;

import static java.lang.Thread.*;

public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int giveMoney(int money) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费" + money + "元");
        return money;
    }
}

class OuterClass {
    int x = 10;

    static class InnerClass {
        int y = 5;
    }
}

public class Main {
    public static void main(String[] args) {
        Person myObj = new Person();
        myObj.setName("John");
        String John = myObj.getName();
        System.out.println(John);

        Car myFastCar = new Car();
        myFastCar.honk();
        System.out.println(myFastCar.brand + " " + myFastCar.modelName);

        OuterClass.InnerClass x = new OuterClass.InnerClass();
        System.out.println(x.y);

    }
}



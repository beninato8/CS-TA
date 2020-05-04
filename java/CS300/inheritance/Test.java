class Parent {
    int a = 0;
    public Parent(int a)
    {
        this.a = a;
    }
    // public Parent()
    // {
    //     this.a = 0;
    // }
}

class Child extends Parent {
    public Child()
    {

    }
    public int getA() 
    {
        return this.a;
    }
}

public class Test {
    public static void main (String [] args)
    {
        Child c = new Child();
        System.out.println(c.getA());
    }
}
public interface InterfaceTest {
    void add();

    void sub();

    void div();

    static void mul(){
        System.out.println("This is static method in interface");
    }

    default void test2(){
        System.out.println("This is default function inside interface");
    }


}

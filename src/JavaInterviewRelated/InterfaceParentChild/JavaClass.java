package JavaInterviewRelated.InterfaceParentChild;

public interface JavaClass {
    void show();

    public static void interfaceStaticMethod(){
        System.out.println("Interface StaticMethod!!!!");
    }

    public default void interfaceDefaultMethod(){
        System.out.println("Interface Default method");
    }
}

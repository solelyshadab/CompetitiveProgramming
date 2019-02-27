package JavaInterviewRelated.InterfaceParentChild;

public class Parent implements JavaClass {

    public Parent(){
        System.out.println("At Parent constructor!");
    }

    int parentValue;
     public void show(){

         System.out.println("Parent is showing...");

         class MyInnerClass{
             void innerMethod(){
                 parentValue = 1;
                 System.out.println("ParentValue at Inner class is: " + parentValue);
             }
         }

         new MyInnerClass().innerMethod();
    }

}

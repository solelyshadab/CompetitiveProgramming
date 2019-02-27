package JavaInterviewRelated.PassByValueOrRef;

public class ObjPassByValueOrRef {
    public static void main(String[] args){
        ObjPassByValueOrRef a = new ObjPassByValueOrRef();
        ObjRef objRef = a.new ObjRef();
        System.out.println(objRef.value);
        a.passByValue(objRef);
        System.out.println(objRef.value);
    }

    private void passByValue(ObjRef objRef){
        objRef.value = 3;
    }

    class ObjRef{
        int value;
        public ObjRef(){
            value = 1;
        }
    }
}

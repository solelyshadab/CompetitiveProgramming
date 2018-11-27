package InterviewBit.Strings;

public class IntegerToRoman {
    public static void main(String[] args){
        IntegerToRoman a = new IntegerToRoman();
        System.out.println(a.intToRoman(1904));
    }

    public String intToRoman(int A){
        StringBuilder ans = new StringBuilder();
        if(A >= 1000){
            int Q = A /1000;
            A = A % 1000;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(1000));
            }
        }
        if(A >= 900){
            int Q = A /900;
            A = A % 900;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(900));
            }
        }
        if(A>=500){
            int Q = A /500;
            A = A % 500;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(500));
            }
        }
        if(A>=400){
            int Q = A /400;
            A = A % 400;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(400));
            }
        }
        if(A>=100){
            int Q = A /100;
            A = A % 100;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(100));
            }
        }
        if(A>=90){
            int Q = A /90;
            A = A % 90;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(90));
            }
        }
        if(A>=50){
            int Q = A /50;
            A = A % 50;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(50));
            }
        }
        if(A>=40){
            int Q = A /40;
            A = A % 40;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(40));
            }
        }
        if(A>=10){
            int Q = A /10;
            A = A % 10;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(10));
            }
        }
        if(A>=9){
            int Q = A /9;
            A = A % 9;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(9));
            }
        }

        if(A>=5){
            int Q = A /5;
            A = A % 5;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(5));
            }
        }
        if(A>=4){
            int Q = A /4;
            A = A % 4;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(4));
            }
        }

        if(A>=1){
            int Q = A;
            A = A % 1;
            for(int i = 0; i < Q; i++){
                ans.append(romanValue(1));
            }
        }

        return ans.toString();
    }

    public String roman(int A){
        StringBuilder ansBuilder = new StringBuilder();
        int power = 1;

        while (A>0){
            int rem = A % ((int)Math.pow(10,power));
            if(!romanValue(rem).equals("")){
                ansBuilder.insert(0,romanValue(rem));
                A -= rem;
            }else {
                int powerIncrease = 1;
                while (romanValue(rem).equals("") && A>0){
                    rem = A%((int)Math.pow(10,power+powerIncrease));
                    if(!romanValue(rem).equals("")){
                        ansBuilder.insert(0,romanValue(rem));
                        A -= rem;
                    }else {
                        powerIncrease++;
                    }
                }
            }
        }

        return ansBuilder.toString();
    }

    private static String romanValue(int value){
        if(value==1)
            return "I";
        if(value==4)
            return "IV";
        if(value==5)
            return "V";
        if(value==9)
            return "IX";
        if(value==10)
            return "X";
        if(value==40)
            return "XL";
        if(value==50)
            return "L";
        if(value==90)
            return "XC";
        if(value==100)
            return "C";
        if(value==400)
            return "CD";
        if(value==500)
            return "D";
        if(value==900)
            return "CM";
        if(value==1000)
            return "M";
        return "";
    }
}

package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Equal {
    public static void main(String[] args){
        Equal a = new Equal();
        System.out.println(a.equal(new ArrayList<>(Arrays.asList(0,0,1,0,2,1))));
    }

    public ArrayList<Integer> equal(ArrayList<Integer> A){
        int sum=0;
        ArrayList<Integer>ans=null;
        Hashtable<Integer,ArrayList<Integer>> map=new Hashtable<Integer,ArrayList<Integer>>();
        for(int i=0;i<A.size();i++)
        {
            for(int j=i+1;j<A.size();j++)
            {
                sum=A.get(i)+A.get(j);
                if(map.containsKey(sum))
                {
                    ArrayList<Integer>a=map.get(sum);
                    if(a.get(0)!=i && a.get(1)!=j && a.get(0)!=j && a.get(1)!=i)
                    {
                        ArrayList<Integer>temp=new ArrayList<Integer>();
                        temp.add(a.get(0));
                        temp.add(a.get(1));
                        temp.add(i);
                        temp.add(j);
                        if(ans==null)
                            ans=temp;
                        else
                        {
                            for(int k=0;k<4;k++)
                            {
                                if(ans.get(k)<temp.get(k))
                                    break;
                                else if(ans.get(k)>temp.get(k))
                                {
                                    ans=temp;
                                    break;
                                }
                            }
                        }
                    }
                }
                else
                {
                    ArrayList<Integer>l=new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    map.put(sum,l);
                }
            }
        }
        return ans;
    }
}

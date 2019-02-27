package JavaInterviewRelated.UseMultiThreadToBatchProcess;

import java.util.ArrayList;
import java.util.Set;

public class CustomerIDList extends ArrayList<Long> {

    public CustomerIDList(Set<Long> set){
        super(set);
    }

    public void removeRange(int startIndex, int endIndex){
        super.removeRange(startIndex, endIndex);
    }
}

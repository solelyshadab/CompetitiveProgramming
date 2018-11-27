package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.*;

public class LargestDistanceBetweenNodesOfTree {
    int root;
    public static void main(String[] args){
        LargestDistanceBetweenNodesOfTree a = new LargestDistanceBetweenNodesOfTree();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 0, 1, 2, 1, 5));

        System.out.println(a.solve(A));
    }

    public int solve(ArrayList<Integer> A) {
        HashSet<Integer>[] undirectedTree = new HashSet[A.size()];
        for (int i = 0; i < undirectedTree.length; i++) {
            undirectedTree[i] = new HashSet<>();
        }

        for(int i = 0 ; i < A.size(); i++){
            if(A.get(i).equals(-1)) {
                root = i;
                continue;
            }
            undirectedTree[i].add(A.get(i));
            undirectedTree[A.get(i)].add(i);
        }

        int[] arr = dfsStack(undirectedTree,root,new boolean[A.size()]);

        int[] ansArr = dfsStack(undirectedTree,arr[0],new boolean[A.size()]);
return ansArr[1];

        //return dfs(undirectedTree,root, new boolean[A.size()]);
    }
    int q = 0;

    static int[] dfsStack(HashSet<Integer>[] undirectedTree,int root,boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        int[] depth = new int[undirectedTree.length];
        stack.add(root);
        depth[root] = 0;

        while(!stack.empty())
        {
            root = stack.peek();
            stack.pop();

            if(!visited[root])
            {
                //System.out.print(root + " ");
                visited[root] = true;


            }
            for(Integer next : undirectedTree[root]){

                if(!visited[next])
                    stack.push(next);
                depth[next] = depth[root] +1;
            }

        }

        int maxDis = 0;
        int nodeIdx = 0;

        //  get farthest node distance and its index
        for (int i = 0; i < undirectedTree.length; i++)
        {
            if (depth[i] > maxDis)
            {
                maxDis = depth[i];
                nodeIdx = i;
            }
        }
        int[] arr = {nodeIdx,maxDis};
        return arr;
    }



    static int maxSoFar = 0;
    // Solution2: Partially accepted, Gives time out exception for few test cases
    static int dfs(HashSet<Integer>[] undirectedTree,int idx,boolean[] visited){

        int maxFirst = 0;
        int maxSecond = 0;
        visited[idx] = true;
        for(Integer next : undirectedTree[idx]){
            if(visited[next]){
                continue;
            }
            int val = dfs(undirectedTree, next,visited);
            if(val > maxFirst){
                maxSecond = maxFirst;
                maxFirst = val;
            }else if(val > maxSecond){
                maxSecond = val;
            }
        }
        maxSoFar = Math.max(maxSoFar, (maxSecond+maxFirst));
        if(idx==0)
            return maxFirst;
        return ++maxFirst;
    }
}

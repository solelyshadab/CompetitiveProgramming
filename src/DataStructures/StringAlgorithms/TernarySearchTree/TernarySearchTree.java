package DataStructures.StringAlgorithms.TernarySearchTree;

public class TernarySearchTree {

    public TSTNode InsertInTST(TSTNode root, String word, int position){
        if(root == null){
            if(word.length()<=position)
                return root;

            root = new TSTNode();
            root.data = word.charAt(position);
            root.left = null;
            root.right = null;
            root.eq = null;

            if(position == word.length()-1){
                root.isEndOfString = true;
                return root;
            }else {
                return InsertInTST(root, word, position +1);
            }
        }

        if(word.charAt(position) < root.data){
            root.left = InsertInTST(root.left, word, position);
        }
        else if(word.charAt(position) == root.data){
            root.eq = InsertInTST(root.eq, word, position +1);
        }
        else {
            root.right = InsertInTST(root.right, word, position);
        }

      return root;
    }

    public boolean SearchInTSTRecursive(TSTNode root, String word, int position){
        if(root == null)
            return false;

        if(word.charAt(position) < root.data){
            return SearchInTSTRecursive(root.left, word, position);
        }

        else if(word.charAt(position) > root.data ){
            return SearchInTSTRecursive(root.right, word, position);
        }

        else {
            if(root.isEndOfString && word.length() == position -1) {
                return true;
            }
            return SearchInTSTRecursive(root.eq, word, position+1);
        }

    }

    public boolean SearchInTSTNonRecursive(TSTNode root, String word, int position){
        while (root != null){
            if(word.charAt(position) < root.data){
                root = root.left;
            }
            else if(word.charAt(position) == root.data){
                if(root.isEndOfString && word.length() == position -1){
                    return true;
                }

                position++;
                root = root.eq;
            }

            else root = root.right;
        }

        return false;
    }


    private StringBuilder word;
    int i =0;
    public void DisplayAllWords(TSTNode root){
        if(root == null)
            return;

        DisplayAllWords(root.left);
        word.setCharAt(i, root.data);

        if(root.isEndOfString){
            System.out.println(word);
        }
        i++;
        DisplayAllWords(root.eq);
        i--;
        DisplayAllWords(root.right);
    }

    public int MaxLengthOfLargestWordInTST(TSTNode root){
        if(root == null)
            return 0;
        int max1 =  Math.max(MaxLengthOfLargestWordInTST(root.left), MaxLengthOfLargestWordInTST(root.eq) + 1);
        return Math.max(max1, MaxLengthOfLargestWordInTST(root.right));
    }

}

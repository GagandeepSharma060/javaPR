//convert binary tree to binary search tree

void fillTree(Node root, ArrayList<Integer> ans)
    {
        
        if(root==null) return;
        
        fillTree(root.left,ans);
        ans.add(root.data);
        fillTree(root.right,ans);
        
        
    }
    static int idx;
    
    void putArrayToTree(Node root , ArrayList<Integer> ans)
    {
        if(idx>=ans.size() || root==null)
        {
            return;
        }
        
        putArrayToTree(root.left,ans);
        root.data=ans.get(idx);
        idx++;
        putArrayToTree(root.right,ans);
        
        return;
        
    }
    Node binaryTreeToBST(Node root)
    {
       // Your code here
       ArrayList<Integer> ans= new ArrayList<>();
       fillTree(root,ans);
       idx=0;
       Collections.sort(ans);
       putArrayToTree(root,ans);
       return root;
       
    }
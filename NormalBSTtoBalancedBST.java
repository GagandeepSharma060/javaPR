 public TreeNode balanceBST(TreeNode root) {
          ArrayList<Integer> al= new ArrayList<>();
       inorderTraversal(root,al);
       
       TreeNode ans= inorderToBst(al,0,al.size()-1);
       return ans;
       
    }
     void inorderTraversal(TreeNode root,ArrayList<Integer> al)
    {
        
        if(root==null) return;
        
        inorderTraversal(root.left,al);
        al.add(root.val);
        inorderTraversal(root.right,al);
        
    }
    
    TreeNode inorderToBst(ArrayList<Integer> al , int si,int ei)
    {
        if(si>ei) return null;
        
        
        int mid= (si+ei)/2;
        
        TreeNode currNode= new TreeNode(al.get(mid));
        
        currNode.left= inorderToBst(al,si,mid-1);
        currNode.right= inorderToBst(al,mid+1,ei);
        
        return currNode;
        
        
        
        
        
    }
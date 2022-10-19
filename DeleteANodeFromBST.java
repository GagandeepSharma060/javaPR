// Deleting a Node from BST

 public TreeNode findMax(TreeNode root)
    {
        if(root==null) return null;
        
        if(root.right!=null) return findMax(root.right);
        else return root;
        
        
        
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null) return null;
        
        if(root.val>key)
        {
            root.left= deleteNode(root.left,key);
        }else if(root.val<key)
        {
            root.right=deleteNode(root.right,key);
        }else{
            
            if(root.left!=null && root.right!=null)
            {
                
                TreeNode max= findMax(root.left);
                root.val=max.val;
                root.left=deleteNode(root.left,max.val);
                return root;
                
            }else if(root.left!=null){
                return root.left;
                
            }else if(root.right!=null){
                return root.right;
            }else{
                return null;
            }
            
            
        }
        
        return root;
        
    }
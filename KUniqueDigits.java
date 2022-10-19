class Solution {
    
    public void remove(HashMap<Integer,Integer> hp , int val)
    {
        
        if(hp.get(val)==1)
        {
            hp.remove(val);
        }else{
            hp.put(val,hp.get(val)-1);
        }
        
        
    }
    
    public int fans(int arr[])
    {
        int ans=0;
        
        int lb=-1;
        int ub=0;
        
        while(ub<arr.length)
        {
            
            
            while( ub<arr.length-1 && arr[ub+1]==arr[ub])
            {
                ub++;
            }
            int n= (ub-lb);
            if(n>2)
            ans+=((n*(n-1))/2)+n;
            else{
                if(n==2)
                {
                    ans+=(3);
                }else
                ans+=(n);
            }
            
            lb=ub;
            ub++;
           
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        
        if(k==1)
        {
            return fans(nums);
        }
        HashMap<Integer,Integer> hk=new HashMap<>();
        
        HashMap<Integer,Integer> hl=new HashMap<>();
        
        int lp=-1;
        int up=-1;
        int ans=0;
        int i=-1;
        
        while(true)
        {
            boolean b1=false;
            boolean b2= false;
            
            while(up<nums.length-1)
            {
                up++;
                b1=true;
                
                int val= nums[up];
                
                hk.put(nums[up],hk.getOrDefault(nums[up],0)+1);
                
                if(hk.size()>k)
                {
                    remove(hk,nums[up]);
                    up--;
                    break;
                }
                
            }
            
            while(lp<nums.length-1)
            {
                lp++;
                b2=true;
                
                int val= nums[lp];
                
                hl.put(nums[lp],hl.getOrDefault(nums[lp],0)+1);
                
                if(hl.size()>=k)
                {
                    remove(hl,nums[lp]);
                    lp--;
                    break;
                }
                
            }
            
            
            while(i<lp)
            {
                i++;
                ans+=(up-lp);
                
                int val= nums[i];
                remove(hk,val);
                  remove(hl,val);
              // i++;
                if(hk.size()<k || hl.size()<k-1){
                    break;
                }
            }
            
            if(b1==false && b2==false)
            {
                break;
            }
            
        }
        return ans;
    }
}
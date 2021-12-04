import java.util.*;
public class kLevelDistance {
      
    public void fill(Node root, List<Integer> ans, int k){
        if(root==null) return false;

        if(k==0){
            ans.add(root.val);
            return;
        }

        fill(root.left,ans,k-1,blocker);
        fill(root.right,ans,k-1,blocker);
    }

    public List<Node> kdown(Node root, int k){
        List<Node> ans=new ArrayList<>();

        fill(root,p,ans,k);

        return ans;
    }

    public void kdown_fill(Node root, int k, List<Integer> ans,Node blocker){
        if(root==null || k<0 || root==blocker) return;

        if(k==0){
            ans.add(root.val);
            return;
        }

        kdown_fill(root.left,k-1,ans,blocker);
        kdown_fill(root.right,k-1,ans,blocker);
    }

    public List<Integer> distanceK(Node root, Node target, int k) {
        ArrayList<Node> ntr=new ArrayList<>();
        nodeToRootPath(root,target,ntr);

        Node blocker=null;

        List<Integer> ans=new ArrayList<>();

        for(int i=0; i<ntr.size(); i++){
            kdown_fill(ntr.get(i),k-i,ans,blocker);
            blocker=ntr.get(i);
        }

        return ans;
    }
    public int k_far_find(Node root, Node target, int k,List<Integer> ans){
        if(root==null) return false;

        if(root==target){
            kdown_fill(root,k,ans,null);
            return 1;
        }

        int left_dis=k_far_find(root.left,target,k,ans);
        int right_dis=k_far_find(root.right,target,k,ans);

        if(left_dis>=0){
            kdown_fill(root,k-left_dis,ans,root.left);
            return left_dis+1;
        }

        if(right_dis>=0){
            kdown_fill(root,k-right_dis,ans,root.right);
            return right_dis+1;
        }

        return -1;
    }
    public List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> ans=new ArrayList<>();

        k_far_find(root,target,k,ans);

        return ans;
    }

}

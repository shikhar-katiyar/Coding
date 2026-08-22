import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ip = new ArrayList<>();
        for (int num : nums) {
            ip.add(num);
        }
        fun(ip, new ArrayList<>());
        return ans;
    }

    public void fun(List<Integer> ip, List<Integer> op) {
        ans.add(new ArrayList<>(op));
        
        for (int i = 0; i < ip.size(); i++) {
            List<Integer> newIp = new ArrayList<>(ip);
            List<Integer> newOp = new ArrayList<>(op);
            newOp.add(ip.get(i));
            newIp.subList(0, i + 1).clear();
            fun(newIp, newOp);
        }
    }
}

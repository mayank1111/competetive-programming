import java.util.HashSet;
import java.util.Set;


public class BitwiseOR
{

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3};
		System.out.println(subarrayBitwiseORs(arr));
	}

public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<Integer>();
        Set<Integer> cur = new HashSet<Integer>();
        Set<Integer> cur2;
        for (Integer i: A) {
            cur2 = new HashSet<Integer>();
            cur2.add(i);
            for (Integer j: cur) cur2.add(i|j);
            res.addAll(cur = cur2);
        }
        return res.size();
    }
}
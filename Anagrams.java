import java.util.*;

public class Anagrams {
	

    public static void main(String []args){
		//String[] array = {"banana", "aaannb", "race", "yellow", "nabana", "acre", "dog", "reca", "god", "odg"};
        //find(array);
		find(args);
    }
	
	public static void find(String[] x) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for(int i=0; i<x.length; i++) {
            char[] aux = x[i].toCharArray();
            Arrays.sort(aux);
            List<String> list = map.get(Arrays.hashCode(aux));
            if(list==null) {
                list = new ArrayList<String>();
                map.put(Arrays.hashCode(aux), list);
            }
        list.add(x[i]);
        }
		
        for(Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
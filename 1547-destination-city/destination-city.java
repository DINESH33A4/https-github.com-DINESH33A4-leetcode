import java.util.*;
class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> m = new HashMap<>();
        for(List<String> i : paths){
            m.put(i.get(0), i.get(1));
        }
        System.out.println(m);
        for(String i : m.keySet()){
            if(!m.containsKey(m.get(i))){
                return m.get(i);
            }
        }
        return " ";
    }
}
package inter;

import java.util.*;
import java.util.Map.Entry;

//import org.apache.commons.collections4.map.LinkedMap;

public class Test030 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

       /* Map<String, String> m = new LinkedMap<String, String>();
        m.put("1", "abc");
        m.put("2", "abc");
        m.put("3", "kjs");
        m.put("4", "abc");
        m.put("5", "kjs");
        System.out.println("before: " + m);
        removeDuplicate(m);
        System.out.println("after: " + m);*/
    }

    private static void removeDuplicate(Map<String, String> m) {
        Set<String> values = new HashSet<String>();
        for (Iterator<Entry<String, String>> it = m.entrySet().iterator(); it.hasNext();) {
            Entry<String, String> e = it.next();
            if(values.contains(e.getValue())){
                it.remove();
            }else{
                values.add(e.getValue());
            }
        }
        Map map = new HashMap();
        Iterator iterator = map.entrySet().iterator();




    }

}
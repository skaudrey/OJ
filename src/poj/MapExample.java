package poj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapExample {
	
	//键值对遍历，效率更高
	public void iterEntry(){
		Map<?, ?> map = new HashMap<Object, Object>();
		Iterator<?> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			}
		
	}
	
	//效率低于entry遍历
		public void iterKV(){
			Map<?, ?> map = new HashMap<Object, Object>();
			Iterator<?> iter = map.keySet().iterator();
			while (iter.hasNext()) {
				Object key = iter.next();
				Object val = map.get(key);
				}
		}
		
		
}

package poj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapExample {
	
	//��ֵ�Ա�����Ч�ʸ���
	public void iterEntry(){
		Map<?, ?> map = new HashMap<Object, Object>();
		Iterator<?> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			}
		
	}
	
	//Ч�ʵ���entry����
		public void iterKV(){
			Map<?, ?> map = new HashMap<Object, Object>();
			Iterator<?> iter = map.keySet().iterator();
			while (iter.hasNext()) {
				Object key = iter.next();
				Object val = map.get(key);
				}
		}
		
		
}

package turning;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortHashMapValue {
	public static void main(String[] args)   
	{  
	//implementing HashMap
		HashMap<Integer, String> hm = new HashMap<Integer, String>();  
		hm.put(6, "Tushar");  
		hm.put(12, "Ashu");  
		hm.put(5, "Zoya");  
		hm.put(78, "Yash");  
		hm.put(10, "Praveen");  
		hm.put(67, "Boby");  
		hm.put(1, "Ritesh");
		hm.put(2, "Ritesh");  
		
		System.out.println("Before Sorting:");  
		Set set = hm.entrySet();  
		Iterator iterator = set.iterator();  
		while(iterator.hasNext())   
		{  
		Map.Entry map = (Map.Entry)iterator.next();  
		System.out.println("Roll no:  "+map.getKey()+"     Name:   "+map.getValue());  
		}  
		
		System.out.println("After Sorting:"); 
		HashMap<Integer, String> sortedmap = sortValues(hm);
		Set sortset = sortedmap.entrySet();  
		Iterator sortiterator = sortset.iterator();  
		while(sortiterator.hasNext())   
		{  
		Map.Entry map = (Map.Entry)sortiterator.next();  
		System.out.println("Roll no:  "+map.getKey()+"     Name:   "+map.getValue());  
		}  
	}
	
	
	//method to sort values  
	private static HashMap sortValues(HashMap map)   
	{   
		
		List list = new LinkedList(map.entrySet());  
		//Custom Comparator  
		Collections.sort(list, new Comparator()   
		{  
			public int compare(Object o1, Object o2)   
			{  
			return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());  
			}  
			});
		
		//copying the sorted list in HashMap to preserve the iteration order  
		HashMap sortedHashMap = new LinkedHashMap();  
		for (Iterator it = list.iterator(); it.hasNext();)   
		{  
		 Map.Entry entry = (Map.Entry) it.next();  
		sortedHashMap.put(entry.getKey(), entry.getValue());  
		}   
		return sortedHashMap;  
	}
}

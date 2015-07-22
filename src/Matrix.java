
import java.util.ArrayList;
import java.util.LinkedHashSet;


public class Matrix {
	
	private ArrayList<LinkedHashSet<Integer>> _workingSet;
 	
	
	public Matrix(){
		_workingSet = new ArrayList<LinkedHashSet<Integer>>();
	}
	
	public int searchForword(int i){
		int count = 0;
		for (int j = 0; j < _workingSet.size(); j++){
			if (_workingSet.get(j).contains(i))
				count++;
		}
		return count;
	}
	
	public ArrayList<LinkedHashSet<Integer>> getMatrix(){
		return _workingSet;
	}
	public void insert(int i,int index){
		_workingSet.get(i).add(index);
	}
	public LinkedHashSet<Integer> getSet(int index){
		return _workingSet.get(index);
	}
}

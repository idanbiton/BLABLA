
import java.util.ArrayList;
import java.util.LinkedHashSet;


public class Matrix {
	
	private ArrayList<LinkedHashSet<Integer>> _workingSet;
 	
	
	public Matrix(){
		_workingSet = new ArrayList<LinkedHashSet<Integer>>(4);
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

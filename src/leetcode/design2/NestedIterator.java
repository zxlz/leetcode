package leetcode.design2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import leetcode.design2.NestedIterator.NestedInteger;

public class NestedIterator  implements Iterator<Integer> {

	 // This is the interface that allows for creating nested lists.
	 // You should not implement it, or speculate about its implementation
	 public interface NestedInteger {

	     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	     public boolean isInteger();

	     // @return the single integer that this NestedInteger holds, if it holds a single integer
	     // Return null if this NestedInteger holds a nested list
	     public Integer getInteger();

	     // @return the nested list that this NestedInteger holds, if it holds a nested list
	     // Return null if this NestedInteger holds a single integer
	     public List<NestedInteger> getList();
	 }

	 private Iterator<Integer> iterator;
	 private List<Integer> list;
	 public NestedIterator(List<NestedInteger> nestedList) {
		 list=new ArrayList<Integer>();
        dfs(nestedList);
        iterator=list.iterator();
    }
	

    private void dfs(List<NestedInteger> nestedList) {
		// TODO Auto-generated method stub
//		List<Integer> temp = new ArrayList<Integer>(nestedList.size());
//		Iterator<NestedInteger> iterator=nestedList.iterator();
		for(NestedInteger n:nestedList) {
			Integer t=n.getInteger();
			if(t==null) {
				dfs(n.getList());
			}else {
				list.add(t);
			}
		}
	}


	@Override
    public Integer next() {
		
		return iterator.next();
        
    }

    @Override
    public boolean hasNext() {
		return iterator.hasNext();
        
    }
}

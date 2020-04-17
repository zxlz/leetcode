package leetcode.design2;

import org.junit.Test;

import java.util.*;

public class RandomizedCollection {
    @Test
    public void main() {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(0);
        randomizedCollection.insert(1);
        randomizedCollection.remove(0);
        randomizedCollection.insert(2);
        randomizedCollection.remove(1);
//        randomizedCollection.insert(1);
//        randomizedCollection.insert(1);
//        randomizedCollection.insert(2);
//        randomizedCollection.insert(1);
//        randomizedCollection.insert(2);
//        randomizedCollection.insert(2);
//        randomizedCollection.remove(1);
//        randomizedCollection.remove(2);
//        randomizedCollection.remove(2);
//        randomizedCollection.remove(2);
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());

    }
    List<Integer> list = new ArrayList<>();
    Map<Integer,List<Integer>> map = new HashMap<>();
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            List<Integer> l = new ArrayList<>();
            l.add(list.size());
            map.put(val,l);
            list.add(val);
            return true;
        }else {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;
        else {
            List<Integer> l = map.get(val);
            int last = list.get(list.size()-1);
            if(last==val){
                //直接删除尾部
                list.remove(list.size()-1);
                l.remove(l.size()-1);
                if(l.size()==0)map.remove(val);
            }else {
                int lastposition = list.size()-1;
                int position = l.get(l.size()-1);
                l.remove(l.size()-1);
                if(l.size()==0)map.remove(val);
                list.set(position,last);
                list.remove(list.size()-1);
                List<Integer> last_list = map.get(last);
                for(int i=0;i<last_list.size();i++){
                    if(last_list.get(i)==lastposition)last_list.set(i,position);
                }
            }
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }


//    class IndexNode{//反正自带的hashmap要用integer对象类型，所以数量存在map而不是int数组
//        int index;//索引位置
//        IndexNode next;//下一个该数值的位置
//        IndexNode(int index,IndexNode next){
//            this.index=index;
//            this.next=next;
//        }
//    }
//    int[] elementData;
//    int tailIndex;//最后一个元素，不包括
//    final int DEFAULT_CAPACITY = 10;
//    Random random= new Random();
//    HashMap<Integer,IndexNode> map = new HashMap<>();//key是val，val是数量和数组中的索引
//    /** Initialize your data structure here. */
//    public RandomizedCollection() {
//        elementData=new int[DEFAULT_CAPACITY];
//        tailIndex=0;
//    }
//
//    //data添加，不够resize（），
//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//    public boolean insert(int val) {
//        IndexNode node=map.get(val);
//        if(tailIndex==elementData.length){
//            resize();//没有判断max长度
//        }
//        elementData[tailIndex]=val;
//
//        if(node==null){
//            map.put(val,new IndexNode(tailIndex,null));
//            tailIndex++;
//            return true;
//        }else{
//            while(node.next!=null)node=node.next;
//            node.next=new IndexNode(tailIndex,null);
//            tailIndex++;
//            return false;
//        }
//
//    }
//
//    private void resize() {//扩容1.5倍
//        int oldCapacity = elementData.length;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
////        if (newCapacity - MAX_ARRAY_SIZE > 0)
////            newCapacity = hugeCapacity(minCapacity);
//        // minCapacity is usually close to size, so this is a win:
//        elementData = Arrays.copyOf(elementData, newCapacity);
//    }
//
//    //查val的index，把最后一个覆盖上来，datasize前移
//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//    public boolean remove(int val) {
//        IndexNode node=map.get(val);
//        if(node==null){
//            return false;
//        }else{
//            IndexNode p=node;
//            while(p.next!=null){
//                node=p.next;
//                if(node.next!=null){
//                    p=node;node=node.next;
//                }else{
//                    break;
//                }
//            }
//
//            elementData[node.index]=elementData[--tailIndex];
//            IndexNode e =map.get(elementData[node.index]);
//            while(e!=null && e.index!=tailIndex){
//                e=e.next;
//            };
//            if(e!=null)e.index=node.index;//替换新index
////            node=node.next;
//            if(p.next==node){
//                p.next=null;
//            }else{//没了，删除
//                map.remove(val);
//            }
////            if(node.next!=null){//还剩的有
////                node=node.next;
////            }else{//没了，删除
////                map.remove(val);
////            }
//            return true;
//        }
//    }
//
//    //从0-datasize之间随机一个索引取出来
//    /** Get a random element from the collection. */
//    public int getRandom() {
//        if(tailIndex>0){
//            return elementData[random.nextInt(tailIndex)];
//        }
//        return -1;
//    }
}

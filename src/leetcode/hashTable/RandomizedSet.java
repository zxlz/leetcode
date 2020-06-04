package leetcode.hashTable;

import java.util.Random;

/**
 * 常数时间插入、删除和获取随机元素
设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。

insert(val)：当元素 val 不存在时，向集合中插入该项。
remove(val)：元素 val 存在时，从集合中移除该项。
getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * @author zxl
 *
 */
public class RandomizedSet {
	/** Status indicator for free table entries. */
    protected static final byte FREE    = 0;

    /** Status indicator for full table entries. */
    protected static final byte FULL    = 1;

    /** Status indicator for removed table entries. */
    protected static final byte REMOVED = 2;

	/** Load factor for the map. */
    private static final float LOAD_FACTOR = 0.5f;
    /** Multiplier for size growth when map fills up.
     * <p>This must be a power of two for bit mask to work properly. </p>
     */
    private static final int RESIZE_MULTIPLIER = 2;
    /** Number of bits to perturb the index when probing for collision resolution. */
    private static final int PERTURB_SHIFT = 5;
    
    /** Keys table. */
    private int[] keys;

//    /** Values table. */
//    private T[] values;
    /** Current size of the map. */
    private int size;
    /** States table. */
    private byte[] states;
    /** Bit mask for hash values. */
    private int mask;
    
	/**
	 * 
     * Compute the capacity needed for a given size.
     * @param expectedSize expected size of the map
     * @return capacity to use for the specified size
     */
    private static int computeCapacity(final int expectedSize) {
        if (expectedSize == 0) {
            return 1;
        }
        final int capacity   = (int) Math.ceil(expectedSize / LOAD_FACTOR);
        final int powerOfTwo = Integer.highestOneBit(capacity);
        if (powerOfTwo == capacity) {
            return capacity;
        }
        return nextPowerOfTwo(capacity);
    }

    /**
     * Find the smallest power of two greater than the input value
     * @param i input value
     * @return smallest power of two greater than the input value
     */
    private static int nextPowerOfTwo(final int i) {
        return Integer.highestOneBit(i) << 1;
    }
    
    /**
    * Compute the hash value of a key
    * @param key key to hash
    * @return hash value of the key
    */
   private static int hashOf(final int key) {
       final int h = key ^ ((key >>> 20) ^ (key >>> 12));
       return h ^ (h >>> 7) ^ (h >>> 4);
   }
   /**
    * Check if the tables contain an element associated with specified key
    * at specified index.
    * @param key key to check
    * @param index index to check
    * @return true if an element is associated with key at index
    */
   private boolean containsKey(final int key, final int index) {
       return (key != 0 || states[index] == FULL) && keys[index] == key;
   }
   
	/** Initialize your data structure here. */
    public RandomizedSet() {
        final int capacity = computeCapacity(16);
        keys   = new int[capacity];
//        values = buildArray(capacity);
        states = new byte[capacity];
        mask   = capacity - 1;
    }
    /**
     * Find the index at which a key should be inserted
     * @param key key to lookup
     * @return index at which key should be inserted
     */
    private int findInsertionIndex(final int key) {
        return findInsertionIndex(keys, states, key, mask);
    }
    /**
     * Find the index at which a key should be inserted
     * @param keys keys table
     * @param states states table
     * @param key key to lookup
     * @param mask bit mask for hash values
     * @return index at which key should be inserted
     */
    private static int findInsertionIndex(final int[] keys, final byte[] states,
                                          final int key, final int mask) {
        final int hash = hashOf(key);
        int index = hash & mask;
        if (states[index] == FREE) {
            return index;
        } else if (states[index] == FULL && keys[index] == key) {
            return changeIndexSign(index);//改为负值，代表要替换：return -index - 1;
        }

        int perturb = perturb(hash);//& 0x7fffffff;得到取正
        int j = index;
        if (states[index] == FULL) {//full key[index]!=key
        	//新index不是full（是remove或free），或者keys一样才出循环
        	while (true) {
        		//产生next的新hash： (j << 2) + j + perturb + 1;
                j = probe(perturb, j);
                index = j & mask;
                perturb >>= PERTURB_SHIFT;

                if (states[index] != FULL || keys[index] == key) {
                    break;
                }
            }
        }

        if (states[index] == FREE) {
            return index;
        } else if (states[index] == FULL) {
            // due to the loop exit condition,
            // if (states[index] == FULL) then keys[index] == key
            return changeIndexSign(index);
        }

        final int firstRemoved = index;
        while (true) {
            j = probe(perturb, j);
            index = j & mask;

            if (states[index] == FREE) {
                return firstRemoved;
            } else if (states[index] == FULL && keys[index] == key) {
                return changeIndexSign(index);
            }

            perturb >>= PERTURB_SHIFT;

        }

    }
    
    /**
     * Perturb the hash for starting probing.
     * @param hash initial hash
     * @return perturbed hash
     */
    private static int perturb(final int hash) {
        return hash & 0x7fffffff;
    }
    /**
     * Compute next probe for collision resolution
     * @param perturb perturbed hash
     * @param j previous probe
     * @return next probe
     */
    private static int probe(final int perturb, final int j) {
        return (j << 2) + j + perturb + 1;
    }

    /**
     * Change the index sign
     * @param index initial index
     * @return changed index
     */
    private static int changeIndexSign(final int index) {
        return -index - 1;
    }
    /**
     * Check if tables should grow due to increased size.
     * @return true if  tables should grow
     */
    private boolean shouldGrowTable() {
        return size > (mask + 1) * LOAD_FACTOR;
    }
    /**
     * Grow the tables.
     */
    private void growTable() {

        final int oldLength      = states.length;
        final int[] oldKeys      = keys;
//        final T[] oldValues = values;
        final byte[] oldStates   = states;

        final int newLength = RESIZE_MULTIPLIER * oldLength;
        final int[] newKeys = new int[newLength];
//        final T[] newValues = buildArray(newLength);
        final byte[] newStates = new byte[newLength];
        final int newMask = newLength - 1;
        for (int i = 0; i < oldLength; ++i) {
            if (oldStates[i] == FULL) {
                final int key = oldKeys[i];
                final int index = findInsertionIndex(newKeys, newStates, key, newMask);
                newKeys[index]   = key;
//                newValues[index] = oldValues[i];
                newStates[index] = FULL;
            }
        }

        mask   = newMask;
        keys   = newKeys;
//        values = newValues;
        states = newStates;

    }
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	int index = findInsertionIndex(val);
        boolean newMapping = true;
        if (index < 0) {
            index = changeIndexSign(index);
           // previous = values[index];
            newMapping = false;
        }
        keys[index]   = val;
        states[index] = FULL;
//        values[index] = value;
        if (newMapping) {
            ++size;
            if (shouldGrowTable()) {
                growTable();
            }
        }
        return newMapping;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	int key=val;
    	final int hash  = hashOf(key);
        int index = hash & mask;
        if (containsKey(key, index)) {
            return doRemove(index);
        }

        if (states[index] == FREE) {
//            return missingEntries;
        	return false;
        }

        int j = index;
        for (int perturb = perturb(hash); states[index] != FREE; perturb >>= PERTURB_SHIFT) {
            j = probe(perturb, j);
            index = j & mask;
            if (containsKey(key, index)) {
                return doRemove(index);
            }
        }

        return false;
    }
    /**
     * Remove an element at specified index.
     * @param index index of the element to remove
     * @return removed value
     */
    private boolean doRemove(int index) {
        keys[index]   = 0;
        states[index] = REMOVED;
//        final T previous = values[index];
//        values[index] = missingEntries;
        --size;
//        ++count;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	
    	Random r = new Random();
    	int index=r.nextInt(mask+1);

        while (states[index] != FULL) {
        	index=r.nextInt(mask+1);
        }
        return keys[index];

    }
}

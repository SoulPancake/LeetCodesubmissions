// https://leetcode.com/problems/design-hashset

class MyHashSet {

/** Initialize your data structure here. */
int capacity=1500;
LinkedList<Integer>[] a;
public MyHashSet() {
    a=new LinkedList[capacity];
}
public int calc_hash(int key)
{
 return key%capacity;   
}

public void add(int key) {
    int i=calc_hash(key);
    if(a[i]==null)
        a[i]=new LinkedList<>();
    if(a[i].indexOf(key)== -1)
        a[i].add(key);
}

public void remove(int key) {
    int i=calc_hash(key);
    if(a[i]==null || a[i].indexOf(key)== -1)
        return;
    a[i].remove(a[i].indexOf(key));
}

/** Returns true if this set contains the specified element */
public boolean contains(int key) {
    int i=calc_hash(key);
    if(a[i]==null || a[i].indexOf(key)== -1)
        return false;
    return true;
}
}
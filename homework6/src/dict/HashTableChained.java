/* HashTableChained.java */
package dict;
import list.*;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
  Entry[] buckets; *  Place any data fields here.
   **/
	SList[] buckets;
	int prime;
	int bucketsnumber,size;


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/
private boolean isprime(int x)
{
	if(x<=2)
		return false;
	for(int i=2;i<x/2;i++) {
	
		if(x%i==0)
			return false;
	}
	return true;
}
public HashTableChained(int sizeEstimate) {
    int x=(int) (sizeEstimate*1.5);
    while(!isprime(x))
    {x++;}
  buckets=new SList[x];
  this.bucketsnumber=x;
  for(int i=0;i<x;i++) {
	  buckets[i]=new SList();
  }
  x=(int) Math.sqrt((double)2147483647/x);
  while(!isprime(x)) {
	  {x++;}
	  size=0;
  }
  prime=x;
	// Your solution here.
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
	this(100);;// Your solution here.
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    return Math.abs((code*5+30)%prime%bucketsnumber);// Replace the following line with your solution.
   //return code%bucketsnumber;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    if(size==0)// Replace the following line with your solution.
    return true;
    else
    	return false;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    Entry newentry=new Entry();
    newentry.key=key;
    newentry.value=value;
    //System.out.println(this.compFunction(key.hashCode()));
    buckets[this.compFunction(key.hashCode())].insertBack(newentry);
    size++;// Replace the following line with your solution.
    return newentry;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
 * @throws InvalidNodeException 
   **/

  public Entry find(Object key) throws InvalidNodeException {
    // Replace the following line with your solution.
   SList mylist;
   if(buckets[this.compFunction(key.hashCode())].isEmpty())
	   return null;
	  mylist=buckets[this.compFunction(key.hashCode())];
	  ListNode mynode= mylist.front();
	  while(mynode.isValidNode()) {
		  
			if(((Entry)mynode.item()).key.equals(key))
				  return ((Entry)mynode.item());
		
		  mynode=mynode.next();		  
	  }
	  return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
 * @throws InvalidNodeException 
   */

  public Entry remove(Object key) throws InvalidNodeException {
	  SList mylist;Entry myentry = null;
	   if(buckets[this.compFunction(key.hashCode())].isEmpty())
		   return null;
		  mylist=buckets[this.compFunction(key.hashCode())];
		  ListNode mynode= mylist.front();
		  while(mynode.isValidNode()) {
				
				if(((Entry)mynode.item()).key.equals(key))
				{ myentry=((Entry)mynode.item());
					mynode.remove();  
					return myentry;}
			}
		  return myentry;
    // Replace the following line with your solution.
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    for(int i=0;i<this.size();i++) {
    	while(!buckets[i].isEmpty()) {
    		buckets[i]=new SList();
    	}
    	// Your solution here.
    }
  }
public int bucketnumber() {
	return this.bucketsnumber;
}
public String toString() {
	String table = "";
	int j=0;
	for(int i=0;i<this.bucketsnumber;i++) {
		table+=" ["+this.buckets[i].getsize()+"]";
		if(j>=10) {
			j=0;
			table+="\n";
		}
		j++;
	}
	return table;
}
public int calcollision() {
	int collisions=0;
	for(int i=0;i<this.bucketsnumber;i++) {
		if(this.buckets[i].getsize()>1)
		collisions+=buckets[i].getsize()-1;	
	}
return collisions;	
}
}

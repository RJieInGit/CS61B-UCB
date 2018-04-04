package list;

public class LockDList extends DList {
public void LockNode(DListNode node)
{

((LockDListNode)node).lock=true;

System.out.println("lock completed locknode.lock is "+((LockDListNode)node).lock);

}
public LockDList()
{
super();
}

@Override
public void remove(DListNode node)
{
if(((LockDListNode)node).lock==true)
	return;
super.remove(node);
return;

}


@Override
protected DListNode newNode(Object i, DListNode prev,DListNode next)
{
	return new LockDListNode(i,prev,next);
}
public static void main(String[] arg)
{
	  System.out.println("testing DListNode CLass");
	  LockDList mylist=new LockDList();
	  for(int i=0;i<10;i++)
	  {
	  mylist.insertBack(i);
	  }
	  System.out.println("my list is "+mylist);
	  System.out.println("Insert front/back funtion works GOOD!!");
	  DListNode node=mylist.head;
	  for(int i=0;i<10;i++)
	  {
		 
		  
		 node=mylist.next(node);
		  System.out.println(node.item+" ");
	  }
	  System.out.println("NEXT,prev function works GOOD!!");
	  for(int i=0;i<5;i++)
	  {
		node=mylist.prev(node) ;
	  }
	  mylist.insertAfter(888, node);
	  
	  System.out.println("mylist is "+ mylist);
	  System.out.println("insertafter function works GOOD!!");
	  mylist.remove(node);
	  System.out.println(mylist);
	  node=mylist.next(node);
	  mylist.LockNode(node);
	  System.out.println("node. lock is "+((LockDListNode)node).lock);
	  mylist.remove(node);
	  
	  System.out.println(mylist);
	  
	
	  
	  
}
}
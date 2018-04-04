package list;

public class LockDListNode extends DListNode {
	
	protected boolean lock;
	public LockDListNode(Object item, DListNode prev, DListNode next)
	{
		super(item,prev,next);
		lock=false;
		
	}

}

public class Main
{
	public static void main(String[] args)
    {
        int [] arr= {2,2,5,8,23,46,59};
		Node<Integer> l1 = buildList(arr);
		int [] arr1= {1,3,6,8,12,23,45};
		Node<Integer> l2 = buildList(arr1);
		System.out.println(q_1(l1,l2));
		
		System.out.println();
		
		int [] arr2= {1,2,3,8,2,3,8,5,6,8,2};
		Node<Integer> l3 = buildList(arr2);
		System.out.println(q_3(l3, 8));
		
		System.out.println();
		
		int [] arr3= {1,2,4,6,3423,23,232,12};
		Node<Integer> l4 = buildList(arr3);
		System.out.println(q_4(l4));
		
		System.out.println();
		
		int [] arr4= {2,2,2,2,2,2,2,2};
		Node<Integer> l5 = buildList(arr4);
		System.out.println(l5);
		System.out.println(q_5(l5));
		System.out.println(l5);
		
	}
	public static Node<Integer> buildList(int [] arr)
	{
	    if (arr.length==0)
	    {
	        return null;
	    }
		Node<Integer> p = new Node<Integer>(arr[0]);
		Node<Integer> head = p;
		for(int i=1; i<arr.length; i++)
		{
			Node<Integer> x= new Node<Integer>(arr[i]);
			p.setNext(x);
			p=p.getNext();
		}
		return head;
	}

	public static Node<Integer> q_1(Node<Integer> l1, Node<Integer> l2)//סיבוכיות: O(n+m)
	{
		Node<Integer> p =  new Node<Integer>(-1);
		Node<Integer> head = p;
		while(l1!=null && l2!=null)
		{

			if (l1.getValue()>=l2.getValue())
			{
				Node<Integer> x= new Node<Integer>(l2.getValue());
				p.setNext(x);
				p=p.getNext();
				l2=l2.getNext();
			}
			else
			{
				Node<Integer> x= new Node<Integer>(l1.getValue());
				p.setNext(x);
				p=p.getNext();
				l1=l1.getNext();

			}
		}
		
		while(l2!=null)
		{
			Node<Integer> x= new Node<Integer>(l2.getValue());
			p.setNext(x);
			p=p.getNext();
			l2=l2.getNext();
		}
	
	
	
		while(l1!=null)
		{
			Node<Integer> x= new Node<Integer>(l1.getValue());
			p.setNext(x);
			p=p.getNext();
			l1=l1.getNext();
		}
	
		return head.getNext();
	}
	
	public static Node<Integer> q_2(Node<Integer> source)
  {
    Node<Integer> resultHead = null;
    Node<Integer> resultTail = null;

    while (source != null) 
    {
        Node<Integer> smallest = source;
        Node<Integer> beforeSmallest = null;

        Node<Integer> scannerPrev = source;
        Node<Integer> scanner = source.getNext();
        
        while (scanner != null) {
            if (scanner.getValue() < smallest.getValue()) 
            {
                smallest = scanner;
                beforeSmallest = scannerPrev;
            }
            scannerPrev = scanner;
            scanner = scanner.getNext();
        }

        if (beforeSmallest == null) 
        {
            source = source.getNext();
        } else {
            beforeSmallest.setNext(smallest.getNext());
        }

        if (resultHead == null)
        {
            resultHead = smallest;
            resultTail = smallest;
        } else 
        {
            resultTail.setNext(smallest);
            resultTail = resultTail.getNext();
        }
        resultTail.setNext(null);
    }

    return resultHead;
  }
	
	public static int q_3(Node<Integer> list, int x)
    {
        int index1=0;
        int index2=0;
        while(list.getValue()!=x && list!=null)
        {
            index1++;
            list= list.getNext();
        }
        while(list!=null)
        {
            index2++;
            if(list.getValue()==x)
            {
                index2=0;
            }
            list= list.getNext();
        }
        return index1+index2;
	}
	
	public static boolean q_4(Node<Integer> list)
    {
        while (list!=null)
        {
            Node<Integer> list2=list;
            while (list2.getNext()!=null)
            {
                list2=list2.getNext();
                if(list2.getValue()==list.getValue())
                {
                    return false;
                }
                
            }
            list=list.getNext();
        }
        return true;
	}
	
	public static Node<Integer> q_5(Node<Integer> list)
    {
        
        if (q_4(list))
        {
            return list;
        }
        
        Node<Integer> p = new Node<Integer>(-1);
		Node<Integer> head = p;
		while(list!=null)
		{
		    
			Node<Integer> x= new Node<Integer>(list.getValue());
			p.setNext(x);
			p=p.getNext();
		    
		    list = list.getNext();
		}
		head=head.getNext();
		Node<Integer> list1=head;
		
		
        while (list1!=null)
        {
            Node<Integer> list2=list1;
            while (list2.getNext()!=null)
            {
                
                if(list2.getNext().getValue()==list1.getValue())
                {
                    list2.setNext(list2.getNext().getNext());
                }
                if(list2.getNext()!=null)
                    if(list2.getNext().getValue()!=list1.getValue())
                    {
                        list2=list2.getNext();
                    }
                
            }
            list1=list1.getNext();
        }
        return head;
	}
}

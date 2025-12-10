class Main 
{
  public static void main(String[] args) 
  {
    int[] numsA = {1, 3, 5};
    int[] numsB = {2, 3, 4};
    Node<Integer> listA = createListFromArray(numsA);
    Node<Integer> listB = createListFromArray(numsB);

    System.out.println("merge:");
    Node<Integer> unitedList = uniteLists(listA, listB);
    printListLoop(unitedList);

    int[] numsC = {5, 1, 4, 2};
    Node<Integer> mixedList = createListFromArray(numsC);

    System.out.println("selection sort:");
    Node<Integer> orderedList = performSelectionSort(mixedList);
    printListLoop(orderedList);
  }

  public static Node<Integer> uniteLists(Node<Integer> chain1, Node<Integer> chain2) 
  {
    Node<Integer> anchor = new Node<Integer>(0);
    Node<Integer> current = anchor;

    while (chain1 != null && chain2 != null) 
    {
        if (chain1.getValue() <= chain2.getValue())
        {
            current.setNext(chain1);
            chain1 = chain1.getNext();
        } 
        else 
        {
            current.setNext(chain2);
            chain2 = chain2.getNext();
        }
        current = current.getNext();
    }

    if (chain1 != null) 
    {
        current.setNext(chain1);
    }
    if (chain2 != null) 
    {
        current.setNext(chain2);
    }

    return anchor.getNext();
  }


  public static Node<Integer> performSelectionSort(Node<Integer> source)
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
}

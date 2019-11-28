class Elem {
	int value;
	Elem next;
	public Elem(int val) {
        value = val;
        next = null;
    }
}

class MyLinkedList {
	private Elem headElem = null;

    private int getNumberElem () {
        Elem currentElem = headElem;
        int numberElem = 0;

        if (headElem == null) {
            return numberElem;
        }

        while (currentElem.next != null) {
            currentElem = currentElem.next;
            numberElem++;
        }

        return numberElem + 1;
    }

	public void appendFirst (int val) {
		Elem firstElem = headElem;

		headElem = new Elem(val);

		if (headElem != null) {
			headElem.next = firstElem;
		}
	}

	public void appendAtPosition (int val, int pos) {
        Elem currentElem = headElem;
        Elem previousElem = null;
		int posElem = 1;

		if (pos == 1) {
			appendFirst(val);
		} else {
	        while (posElem < pos && currentElem != null) {
	        	previousElem = currentElem;
	            currentElem = currentElem.next;
	            ++posElem;
	        }

	        Elem addedElem = new Elem(val);

	        previousElem.next = addedElem;
	        addedElem.next = currentElem;
	    }
    }

	public void appendLast (int val) {
        Elem lastElem = getLastElem();

        if (lastElem == null) {
            headElem = new Elem(val);
        } else {
            lastElem.next = new Elem(val);
        }
    }

    private Elem getLastElem () {
        Elem currentElem = headElem;

        if (headElem == null) {
            return null;
        }

        while (currentElem.next != null) {
            currentElem = currentElem.next;
        }

        return currentElem;
    }

    public void deleteElem (int val) {
    	Elem previousElem = null;
    	Elem currentElem = headElem;

    	if (headElem == null) {
    		return;
    	}

    	while (currentElem != null && currentElem.value != val) {
    		previousElem = currentElem;
    		currentElem = currentElem.next;
    	}

    	if (previousElem == null) {
    		headElem = headElem.next;
    		return;
    	} else if (currentElem == null) {
    		return;
    	}

    	previousElem.next = currentElem.next;
    }

    public void deleteElemAtPosition (int pos) {
    	Elem previousElem = null;
    	Elem currentElem = headElem;
    	int posElem = 1;

    	if (headElem == null) {
    		return;
    	}

    	while (posElem < pos && currentElem != null) {
    		previousElem = currentElem;
    		currentElem = currentElem.next;
    		++posElem;
    	}

    	if (previousElem == null) {
    		headElem = headElem.next;
    		return;
    	} else if (currentElem == null) {
    		return;
    	}

    	previousElem.next = currentElem.next;
    }

    public void print () {
        System.out.println("");
        if (headElem == null){
            System.out.print("Empty list");
            return;
        }
        Elem tmpElem = headElem;
        while (tmpElem != null) {
            System.out.print(tmpElem.value + ", ");
            tmpElem = tmpElem.next;
        }
    }

    public static void main (String[] args) {
    	MyLinkedList myList = new MyLinkedList();

    	myList.appendLast(33);
    	myList.appendLast(34);
    	myList.appendLast(35);
    	myList.appendLast(36);
    	myList.deleteElem(34);
    	myList.appendFirst(32);
    	myList.appendAtPosition(34, 3);
    	myList.deleteELemAtPosition(1);
    	System.out.print("number Elem: " + myList.getNumberElem());

    	myList.print();
      }
}
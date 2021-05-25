public class LinkedListDeque<T> {

    public class TNode {
        private T item;
        private TNode prev;
        private TNode next;

        public TNode(T t, TNode prev, TNode next) {
            this.item = t;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private TNode sentF = new TNode(null, null, null);
    private TNode sentB = new TNode(null, null, null);

    public LinkedListDeque() {
        this.size = 0;
        this.sentF.next = this.sentB;
        this.sentB.prev = this.sentF;
    }
    /*Adds an item of type T to the front of the deque8*/
    public void addFirst(T item) {
        TNode tnode = new TNode(item, this.sentF, this.sentF.next);
        this.sentF.next.prev = tnode;
        this.sentF.next = tnode;
        this.size += 1;
    }

    /*Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        TNode tnode = new TNode(item, this.sentB.prev, this.sentB);
        this.sentB.prev.next = tnode;
        this.sentB.prev = tnode;
        this.size += 1;
    }

    /*Returns true if deque is empty, false otherwise*/
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        } else {
            return false;
        }   
    }

    /*Returns the number of items in the deque*/
    public int size() {
        return this.size;
    }

    /*Prints the items in the deque from first to last, separated by a space*/
    public void printDeque() {
        TNode p = this.sentF;
        while (p.next != this.sentB) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
    }

    /*Removes and returns the item at the front of the deque. 
    If no such item exists, returns null*/
    public T removeFirst() {
        T t = null;
        if (this.isEmpty()) {
            return t;
        }
        TNode tnode = this.sentF.next;
        this.sentF.next = tnode.next;
        tnode.next.prev = this.sentF;
        this.size -= 1;
        return tnode.item;
    }

    /* Removes and returns the item at the back of the deque. 
    If no such item exists, returns null*/
    public T removeLast() {
        T t = null;
        if (this.isEmpty()) {
            return t;
        }
        TNode tnode = this.sentB.prev;
        this.sentB.prev = tnode.prev;
        tnode.prev.next = this.sentB;
        this.size -= 1;
        return tnode.item;
    }

    /*Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. 
    If no such item exists, returns null. Must not alter the deque */
    public T get(int index) {
        TNode p = this.sentF;
        if (index >= this.size()) {
            return null;
        }
        int count = 0;
        while (count != index) {
            p = p.next;
            count += 1;
        }
        return p.next.item;
    }


    private T getTNode(TNode t, int index) {
        if (index == 0) {
            return t.next.item;
        }
        return getTNode(t.next, index - 1);
    }

    public T getRecursive(int index) {
        return getTNode(this.sentF, index);
    }


    public static void main(String[] args) {
        LinkedListDeque<Integer> L =  new LinkedListDeque<>();
        L.addFirst(10);
        L.addFirst(20);
        L.printDeque();

        
    }
}

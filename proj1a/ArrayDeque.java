public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static final double HIGHFACTOR = 0.75;
    private static final double LOWFACTOR = 0.25;
    private static final int INIT_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INIT_CAPACITY];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /**
     * Replaces the elements of the original array in the new array, 
     * with the first element of the original array placed at the subscript 0
     * nextFirst subscript is items.length - 1
     * nextLast  subscript is the length of items
     * @param cpapcity
     */
    private void resizeHelper(int cpapcity) {
        T[] temp = (T[]) new Object[cpapcity];
        int pos = this.nextFirst;
        int i;
        for (i = 0; i < this.size(); i++) {
            pos = (pos + 1) % this.items.length;
            temp[i] = this.items[pos];
        }
        items = temp;
        this.nextFirst = this.items.length - 1;
        this.nextLast = i;
    }

    /**
     * when the number of element exceed items.length * HIGHFACTOR
     * double the size of items
     */
    private void resizeAdd() {
        if (this.size() > this.items.length * HIGHFACTOR) {
            resizeHelper(this.items.length * 2);
        }
    }
    
    /**
     * when the number of element less tha items.length * HIGHFACTOR
     * cut the size of items in half
     */
    private void resizeRemove() {
        if (this.items.length > 8 && this.size() <= this.items.length * LOWFACTOR) {
            resizeHelper(this.items.length / 2);
        }
    }

    public void addFirst(T item) {
        this.items[nextFirst] = item;
        // caculate the next postion of nextFirst
        nextFirst = (nextFirst - 1 + this.items.length) % this.items.length;
        size++;
        resizeAdd();
    }

    public void addLast(T item) {
        this.items[nextLast] = item;
        // caculate the next postion of nextLast
        nextLast = (nextLast + 1) % this.items.length;
        size++;
        resizeAdd();
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int pos = this.nextFirst;
        for (int i = 0; i < this.size(); i++) {
            pos = (pos + 1) % this.items.length;
            System.out.print(this.items[pos] + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        // caculate the next postion of nextFirst when remove first element
        nextFirst = (nextFirst + 1) % this.items.length;
        T t = this.items[nextFirst];
        size--;
        resizeRemove();
        return t;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        // caculate the next postion of nextFirst when remove last element
        nextLast = (nextLast - 1 + this.items.length) % this.items.length;
        T t = this.items[nextLast];
        size--;
        resizeRemove();
        return t;
    }

    public T get(int index) {
        if (index > this.size() || index < 0) {
            return null;
        }
        int pos = this.nextFirst;
        int i;
        for (i = 0; i <= index; i++) {
            pos = (pos + 1) % this.items.length;
        }
        return items[pos];
    }

    // public static void main(String[] args) {
    //     ArrayDeque<Integer> ad = new ArrayDeque<>();
    //     System.out.println(ad.size());
    //     ad.addFirst(1);
    //     ad.addLast(20);
    //     ad.addFirst(2);
        
    //     ad.addFirst(3);
    // }
}

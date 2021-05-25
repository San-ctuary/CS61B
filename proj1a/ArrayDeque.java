
public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private Object[] items;
    private static final double HIGHFACTOR = 0.75;
    private static final double lOWFACTOR = 0.25;


    public ArrayDeque() {
        items = new Object[8];
        nextFirst = 4;
        nextLast = 5;
    }

    private void resizeAdd() {
        if (this.size() > this.items.length * HIGHFACTOR) {
            Object[] temp = new Object[this.items.length * 2];
            int pos = this.nextFirst;
            int i;
            for (i = 0; i < this.size(); i++){
                pos = (pos + 1) % this.items.length;
                temp[i] = this.items[pos];
            }
            items = temp;
            this.nextFirst = this.items.length - 1;
            this.nextLast = i;
        }
    }
    
    private void resizeRemove() {
        if (this.items.length > 8 && this.size() <= this.items.length * lOWFACTOR) {
            Object[] temp = new Object[this.items.length / 2];
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
    }

    public void addFirst(T item) {
        this.items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + this.items.length) % this.items.length;
        resizeAdd();
    }

    public void addLast(T item) {
        this.items[nextLast] = item;
        nextLast = (nextLast + 1) % this.items.length;
        resizeAdd();
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }    
        return false;
    }

    public int size() {
        if (nextFirst < nextLast) {
            return nextLast - nextFirst - 1;
        } else {
            return nextLast + this.items.length - 1 - nextFirst;
        }
    }

    public void printDeque() {
        int pos = this.nextFirst;
        for (int i = 0; i < this.size(); i++) {
            pos = (pos + 1) % this.items.length;
            System.out.print(this.items[pos] + " ");
        }
    }

    public T removeFirst() {
        if(isEmpty)
            return null;
        nextFirst = (nextFirst + 1) % this.items.length;
        T t = (T) this.items[nextFirst];
        resizeRemove();
        return t;
    }

    public T removeLast() {
        if(isEmpty)
            return null;
        nextLast = (nextLast - 1 + this.items.length) % this.items.length;
        T t = (T) this.items[nextLast];
        resizeRemove();
        return t;
    }

    public T get(int index) {
        if (index > this.size() || index < 0) {
            return null;
        }
        int pos = this.nextFirst;
        int i;
        for (i = 0; i <= index; i++){
            pos = (pos + 1) % this.items.length;
        }
        return (T) items[pos];
    }

    // public static void main(String[] args) {
    //     ArrayDeque<Integer> ad = new ArrayDeque<>();
    //     System.out.println(ad.size());
    //     ad.addFirst(1);
    //     ad.addLast(20);
    //     ad.addFirst(2);
        
    //     ad.addFirst(3);
        
    //     ad.addFirst(4);
        
    //     ad.addFirst(5);
        
    //     ad.addFirst(6);
    //     ad.addFirst(7);
        
        
    //     ad.addFirst(8);
    //     ad.addFirst(9);
    //     // ad.addFirst(10);
    //     // ad.addLast(333);
    //     System.out.println("output");
    //     ad.printDeque();
    //     System.out.println(ad.size());
    //     // System.out.println(ad.removeLast());
    //     System.out.println(ad.get(4));
    //     System.out.println(ad.items.length);
    //     ad.removeFirst();
    //     ad.removeFirst();
    //     ad.removeFirst();
    //     ad.removeFirst();
    //     ad.removeFirst();
    //     ad.removeFirst();
    //     ad.removeFirst();
    //     ad.removeFirst();
    //     // ad.removeLast();
    //     // System.out.println();
    //     System.out.println(ad.size());
    //     System.out.println(ad.items.length);
    // }
}

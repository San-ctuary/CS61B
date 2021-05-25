
public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static final double HIGHFACTOR = 0.75;
    private static final double lOWFACTOR = 0.25;


    public ArrayDeque() {
        items = (T[])new Object[8];
        nextFirst = 4;
        nextLast = 5;
    }

    private void resizeAdd(){
        if (this.size() > this.items.length * HIGHFACTOR) {
            T[] temp = (T[])new Object[this.items.length * 2];
            int pos = this.nextFirst;
            int i;
            for(i = 0;i < this.size();i++){
                pos = (pos + 1) % this.items.length;
                temp[i] = this.items[pos];
            }
            items = temp;
            this.nextFirst = this.items.length - 1;
            this.nextLast = i;
        }
    }
    
    private void resizeRemove(){
        if (this.size() <= this.items.length * lOWFACTOR) {
            T[] temp = (T[])new Object[this.items.length / 2];
            int pos = this.nextFirst;
            int i;
            for(i = 0;i < this.size();i++){
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
        nextLast = (
            nextLast + 1) % this.items.length;
        resizeAdd();
    }

    public boolean isEmpty() {
        if ((nextFirst + 1) % items.length == nextLast) {
            return true;
        }    
        return false;
    }

    public int size() {
        if (nextFirst < nextLast) {
            return nextLast - nextFirst - 1;
        } else {
            return Math.abs((nextFirst + 1) % items.length - nextLast);
        }
    }

    public void printDeque() {
        int pos = this.nextFirst;
        for(int i = 0;i < this.size();i++){
            pos = (pos - 1 + this.items.length) % this.items.length;
            System.out.print(this.items[pos]);
        }
    }

    public T removeFirst() {
        nextFirst = (nextFirst + 1) % this.items.length;
        T t = this.items[nextFirst];
        resizeRemove();
        return t;
    }

    public T removeLast() {
        nextLast = (nextLast - 1 + this.items.length) % this.items.length;
        T t = this.items[nextLast];
        resizeRemove();
        return t;
    }

    public T get(int index) {
        if (index > this.size() || index < 0) {
            return null;
        }
        int pos = this.nextFirst;
        int i;
        for(i = 0;i < this.size();i++){
            pos = (pos + 1) % this.items.length;
        }
        return items[pos];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        System.out.println(ad.size());
        ad.addFirst(123);
        ad.addLast(333);
        System.out.println(ad.size());
        System.out.println(ad.items);
    }
}

public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static final double HIGHFACTOR = 0.75;
    private static final double LOWFACTOR = 0.25;
    private static final int INIT_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[])new Object[INIT_CAPACITY];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /**
     * 将原数组中的元素重新放置在新数组中，原数组第一个元素放置在下标为0的位置
     * nextFirst下标为items.length - 1
     * nextLast下标为元素组的大小
     * @param cpapcity
     */
    private void resizeHelper(int cpapcity) {
        T[] temp = (T[])new Object[cpapcity];
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
     * 当数组放置的元素超过了数组长度 * 最大装载因子，将数组长度扩大一倍
     */
    private void resizeAdd() {
        if (this.size() > this.items.length * HIGHFACTOR) {
            resizeHelper(this.items.length * 2);
        }
    }
    
    /**
     * 当数组放置的元素小于了数组长度 * 最小装载因子，将数组缩小一倍
     * 保证数组的大小最少为8
     */
    private void resizeRemove() {
        if (this.items.length > 8 && this.size() <= this.items.length * LOWFACTOR) {
            resizeHelper(this.items.length * 2);
        }
    }

    public void addFirst(T item) {
        this.items[nextFirst] = item;
        // 计算nextFirst的下一位置
        nextFirst = (nextFirst - 1 + this.items.length) % this.items.length;
        size++;
        resizeAdd();
    }

    public void addLast(T item) {
        this.items[nextLast] = item;
        // 计算nextLast的下一位置
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
        // 计算移除后nextFirst的位置
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
        // 计算移除后nextLast的位置
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

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        System.out.println(ad.size());
        ad.addFirst(1);
        ad.addLast(20);
        ad.addFirst(2);
        
        ad.addFirst(3);
        
        ad.addFirst(4);
        
        ad.addFirst(5);
        
        ad.addFirst(6);
        ad.addFirst(7);
        
        
        ad.addFirst(8);
        ad.addFirst(9);
        // ad.addFirst(10);
        // ad.addLast(333);
        System.out.println("output");
        ad.printDeque();
        System.out.println(ad.size());
        // System.out.println(ad.removeLast());
        System.out.println(ad.get(4));
        // System.out.println(ad.items.length);
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        // ad.removeLast();
        // System.out.println();
        System.out.println(ad.size());
    }
}

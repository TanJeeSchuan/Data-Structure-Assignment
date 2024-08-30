
package adt;

/*
 * @param <T>
 */
public class ArrayList<T> implements List{
    protected T[] array;
    protected static final int DEFAULT_CAPACITY = 2;
    protected int maxSize;
    protected int entries = 0;
    
    public ArrayList(){
        array = (T[])new Object[DEFAULT_CAPACITY];
        maxSize = DEFAULT_CAPACITY;
    }
    

    @Override
    public boolean add(Object object) {
        if(isFull())
            expandArray();
        
        array[entries] = (T)object;
        entries++;
        
        return true;
    }
    
    public boolean add(int index, Object object) {
        if(isFull())
            expandArray();
        
        if(index == entries){
            array[entries] = (T)object;
            entries++;
        } else {
            makeSpace(index);
            array[index] = (T)object;
        }
        return true;
    }


    @Override
    public Object get(int index) throws ArrayIndexOutOfBoundsException{
        if(index > entries)
            throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }
    
    @Override
    public int indexOf(Object object){
        for(int i = 0; i < entries; i++){
            if(object.equals(array[i]))
                return i;
        }
        
        return -1;
    }


    @Override
    public boolean remove(Object object) {
        for(int i = 0; i < entries; i++){
            if (array[i].equals(object)){
                entries--;
                shiftArray(i);
                return true;
            }
        }
        
        return false;
    }

    @Override
    public int size() {
        return entries;
    }
    
    protected void shiftArray(int empty){
        for (int i = empty; i < entries; i++){
            array[i] = array[i+1];
        }
    }
    
    protected void expandArray(){
        T[] newArr = (T[])new Object[maxSize * maxSize];
        
        for (int i = 0; i < maxSize; i++){
            newArr[i] = array[i];
        }
        
        maxSize *= maxSize;
        array = newArr;
    }
    
    protected void makeSpace(int index){
        if(entries+1 > maxSize)
            expandArray();
                
        for (int i = entries-1; i >= index; i--){
            array[i+1] = array[i];
        }
        entries++;
        array[index] = null;
    }
    
    @Override
    public boolean contains(Object anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < entries); index++) {
          if (anEntry.equals(array[index])) {
            found = true;
          }
        }
        return found;
    }
    
    public boolean isFull(){
        return (entries == maxSize);
    }
    
    @Override
    public boolean isEmpty(){
        return (entries == 0);
    }
}

public class MinrrayList {
	Object[] list;
	int capacity, size;
	
	public MinrrayList() {
		capacity = 100;
		size = 0;
		list = new Object[capacity];
	}

	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size==capacity;
	}
	
	public int size() {
		return size;
	}
	
	public void add(Object o) {
		if(isFull()) {
			sizeUp();
		}
		list[size++] = o;
	}
	
	public Object get(int index) {
		if(index < size) {
			return list[index];
		} else {
			return false;
		}
	}
	
	public void delete(int index) {
		if(index < size ) {
			size--;
			for(int i=index; i<size; i++) {
				list[i] = list[i-1];
			}
		}
	}
	
	public String toString() {
		return toString(0, size);
	}

	private String toString(int startIndex, int endIndex) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=startIndex; i<endIndex; i++) {
			sb.append(list[i]).append(" ");
		}
		return sb.toString();
	}
	
	public void sizeUp() {
		capacity *= 2;
		Object[] temp = new Object[capacity];
		for(int i=0; i<size; i++) {
			temp[i] = list[i];
		}
		list = new Object[capacity];
		for(int i=0; i<size; i++) {
			list[i] = temp[i];
		}
	}
}

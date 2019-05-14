package tree;

public class QuadraticProbingHashTable<AnyType> {
	private static final int DEFAULT_TABLE_SIZE = 11;
	private HashEntry<AnyType>[] array;
	private int currentSize;

	public QuadraticProbingHashTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuadraticProbingHashTable(int currentSize) {
		super();
		this.currentSize = currentSize;
	}

	public void makeEmpty() {

	}

	public boolean contains(AnyType x) {
		return false;
	}

	public void insert() {

	}

	public void remove() {

	}

	private int myhash(AnyType element) {
		int hashValue = element.hashCode() % array.length;
		if (hashValue < 0)
			hashValue += array.length;
		return hashValue;
	}

	private static class HashEntry<AnyType> {
		public AnyType element; // the Element
		public boolean isActive; // false if marked deleted

		public HashEntry(AnyType e) {
			this(e, true);
		}

		public HashEntry(AnyType element, boolean isActive) {
			this.element = element;
			this.isActive = isActive;
		}
		
	}

}

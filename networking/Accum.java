class Accum {
	private int counter = 0;
	private static Accum a =new Accum();
	public int getCount() {
		return counter;
	}
	
	public static Accum getAccum() {
		return a;
	}

	public void updateCounter(int add) {
		counter += add;
	}
}
		

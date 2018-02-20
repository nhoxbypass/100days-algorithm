int firstDuplicate(int[] a) {
	int[] b = new int[a.length];
	for(int i = 0; i < a.length; i++) {
		if(a[i] == b[a[i] - 1])
			return a[i];
		else
			b[a[i] - 1] = a[i];
	}
	
	return -1;
}

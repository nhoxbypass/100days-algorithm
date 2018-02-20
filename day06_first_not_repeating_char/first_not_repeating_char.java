char firstNotRepeatingCharacter(String s) {
	Map<Character, Integer> counts = new LinkedHashMap<>();
		
	for(int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		Integer a = counts.get(c);
		if(a != null)
			counts.put(s.charAt(i), a+1);
		else
			counts.put(s.charAt(i), 0);
	}
		
	for(char key : counts.keySet()) {
		System.out.println(counts);
		int count = counts.get(key);
			
		if (count == 0)
			return key;
	}
	
	return '_';
}
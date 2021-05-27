public class Palindrome {
    
	public Deque<Character> wordToDeque(String word){
		Deque<Character> deque = new LinkedListDeque<>();
		for(int i = 0;i < word.length();i++) {
			deque.addLast(word.charAt(i));
		}
		return deque;
	}
	
	//method isPalindrome use loop
//	public boolean isPalindrome(String word) {
//		Deque<Character> deque = wordToDeque(word);
//		while(!deque.isEmpty()) {
//			if(deque.size() == 1)
//				return true;
//			if(deque.removeFirst() != deque.removeLast())
//				return false;
//		}
//		return true;
//	}
	
	private boolean isPalindromeHelper(Deque<Character> dq) {
		if(dq.size() == 0 || dq.size() == 1)
			return true;
		if(dq.removeFirst() != dq.removeLast())
			return false;
		else 
			return isPalindromeHelper(dq);
	}
	
	public boolean isPalindrome(String word) {
		return isPalindromeHelper(wordToDeque(word));
	}
	
	public boolean isPalindrome(String word, CharacterComparator cc) {
		Deque<Character> deque = wordToDeque(word);
		while(!deque.isEmpty()) {
			if(deque.size() == 1)
				return true;
			if(!cc.equalChars(deque.removeFirst(), deque.removeLast()))
				return false;
		}
		return true;
	}
}

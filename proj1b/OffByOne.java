public class OffByOne implements CharacterComparator{

	@Override
	public boolean equalChars(char x, char y) {
		// TODO Auto-generated method stub
		int diff = Math.abs(x - y);
		return diff == 1 ? true : false;
	}
    
}

class MyStringDriver{
	public static void main(String[] args) {
		MyString str = new MyString("123#chair");
		// System.out.println(str.charAt(6));
		System.out.println(str.codePointBefore(0));
		

		// MyString str = new MyString("kk");
		// System.out.println(str.charAt(0));

		// MyString str = new MyString ("kk");
		// System.out.println(str.isEmpty());

		// MyString str = new MyString("khagesh");
		// System.out.println(str.length());

		// MyString str1 = new MyString("asFCa#s21aaD");
		// MyString upperCaseStr = str1.toUpperCase();
		// MyString lowerCaseStr = upperCaseStr.toLowerCase();
		// System.out.println(upperCaseStr);
		// System.out.println(lowerCaseStr);

		// System.out.println(str.toLowerCase());
	}
}

@SuppressWarnings("serial")
class MyStringIndexOutOfBoundsException extends RuntimeException{
	public MyStringIndexOutOfBoundsException(String message){
		super(message);
	}
}

final class MyString{
	char [] arr;

	public MyString(){
		arr = new char[0];
	}
	public MyString (String str){
		arr = new char [str.length()];
		for(int i=0;i<str.length();i++)
			arr[i]= str.charAt(i);
	}
	public MyString(StringBuffer sb){
		this(sb.toString());
	}
	public MyString(StringBuilder sb){
		arr = new char[sb.length()];
		for(int i=0;i<arr.length;i++)
			arr[i] = sb.charAt(i);
	}
	public MyString(char[] arr){
		this.arr = arr.clone();
	}
	public MyString(char[] arr, int start, int count){			// used to create String from a character array, where the start points to the first element to be added in the string and count denotes the number of elements to be added in the string from the char [] array.
		if((start + count)>arr.length)
			throw new MyStringIndexOutOfBoundsException 
			("INVALID["+start+","+start+"+"+count+ "] out of bounds for lenght "+ arr.length);

		this.arr = new char[count];	
		for(int i=start,j=0;i<(start+count);i++,j++)
			this.arr[j] = arr[i];

	}

	@Override
	public String toString(){
		String str = "";
		for(char ele : arr) str+=ele;

		return str;
	}
	public int length(){
		return arr.length;
	}
	public boolean isEmpty(){
		return arr.length==0;
	}
	public char charAt(int indx){	
		if(indx<0 || indx>=arr.length)
			throw new MyStringIndexOutOfBoundsException ("Index "+indx+" out of bounds for length"+arr.length);
		return arr[indx];
	}

	public int codePointAt(int indx){		// in this method we're returning the element at the index indx, but the return type of method is int, so the element is getting typecasted to int rather than char, so that's why it's returing the UNICODE or ASCII value.
		System.out.println("From MyString class");
		if(indx<0 || indx >= arr.length)
			throw new MyStringIndexOutOfBoundsException
			("Index "+indx+" out of bounds for length "+arr.length);

		return arr[indx];
	}
	public int codePointBefore(int indx){
		return codePointAt(indx-1);
	}
	public int codePointCount(int start , int end){
		if(start>end || start<0 || end<0 || start>=arr.length || end>=arr.length)
			throw new IndexOutOfBoundsException("Range ["+start+","+end
				+"] out of bounds for length"+ arr.length);
		return end - start;
	}
	public MyString toUpperCase(){
		char[] newArr = new char[arr.length];

		for(int i=0;i<arr.length;i++){
			if(arr[i]>=97 && arr[i]<=122)
				newArr[i] = (char)(arr[i]-32);
			else
				newArr[i] = arr[i];
		}
		return new MyString(newArr);
	}
	public MyString toLowerCase(){
		char[] newArr = new char[arr.length];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>=65 && arr[i]<=90)
				newArr[i] = (char)(arr[i]+32);
			else
				newArr[i] = arr[i];
		}
		return new MyString(newArr);
	}
}
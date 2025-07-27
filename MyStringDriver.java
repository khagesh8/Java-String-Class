class MyStringDriver{
	public static void main(String[] args) {

		

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
		this(sb.toString());
	}
	public MyString(char[] arr){
		this.arr = new char[arr.length];
		for(int i=0;i<arr.length;i++)
			this.arr[i] = arr[i];
	}
	public MyString(char[] arr, int start, int count){
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

	public int codePointAt(int indx){
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

		for(int i=0;i<newArr.length;i++){
			char ch = arr[i];
			newArr[i] = (ch>=97 && ch<=122) ? (char)(ch-32) : ch;
		}
		return new MyString(newArr);
	}
	public MyString toLowerCase(){
		char[] newArr = new char[arr.length];
		for(int i=0;i<newArr.length;i++){
			char ch = arr[i];
			newArr[i] = (ch>=65 && ch<=90) ? (char)(ch+32) : ch;
		}
		return new MyString(newArr);
	}
}
import java.util.Arrays;
class MyStringDriver{
	public static void main(String[] args) {
		String str = new String("khagesh");
		char[] chars = str.toCharArray();
		System.out.println(Arrays.toString(chars)); 

		MyString str1 = new MyString("khagesh");
		char[] chars1 = str1.toCharArray();
		System.out.println(Arrays.toString(chars1));





		// String s1 = new String("hello  how  are you");
		// System.out.println(Arrays.toString(s1.split("h")));

		// MyString s2 = new MyString("hello  how  are you");
		// System.out.println(Arrays.toString(s2.split(new MyString("h"))));


		// String s1 = new String("hello heie");
		// System.out.println(s1.replaceAll("he","ye"));

		// MyString s2 = new MyString("hello heie");
		// System.out.println(s2.replaceAll(new MyString("he"),new MyString("ye")));

		// String s1 = new String("hello hie");
		// System.out.println(s1.substring(2,9));

		// MyString s2 = new MyString("hello hie");
		// System.out.println(s2.substring(2,8));


		// String s1 = new String("hello hie");
		// System.out.println(s1.replace('h','y'));

		// MyString s2 = new MyString("hello hiee");
		// System.out.println(s2.replace('h','y'));


		// String s1 = new String("HelLo ").trim();
		// String s2 = "HelLo";
		// System.out.println(s1.equalsIgnoreCase(s2));

		// MyString s3 = new MyString("HelLlo");
		// MyString s4 = new MyString("HelLlo ").trim();
		// System.out.println(s3.equalsIgnoreCase(s4));



		// String s1 = new String("hello");
		// String s2 = "hello ";
		// System.out.println(s1.contentEquals(s2));

		// MyString s3 = new MyString("helloo");
		// StringBuffer s4 = new StringBuffer("helloo");
		// System.out.println(s3.contentEquals(s4));


		// String s1 = new String("hello");
		// String s2 = new String(" hello");
		// System.out.println(s1.equals(s2));

		// MyString s3 = new MyString("helloo");
		// MyString s4 = new MyString(" helloo").trim();
		// System.out.println(s3.equals(s4));




		// String s1 = new String("hello hie how are you");
		// System.out.println(s1.endsWith(" you"));

		// MyString s2 = new MyString("hello hie how are you");
		// System.out.println(s2.endsWith(new MyString(" you")));


		// String s1 = new String("hello hie how are you");
		// System.out.println(s1.startsWith("hello hie"));

		// MyString s2 = new MyString("hello hie how are you");
		// System.out.println(s2.startsWith(new MyString("hello hie ")));


		// MyString str = new MyString("hea");
		// System.out.println(str.codePointAt(2));



		// String str1 = new String ("123#chair");
		// MyString str = new MyString("hello ");
		// MyString str2 = new MyString("hie ");
		// System.out.println(str2.concat(str));





		// MyString str = new MyString("123#chair");
		// System.out.println(str.indexOf('a'));
		// System.out.println(str.indexOf('a',3));
		

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
	public int indexOf(int ascii){
		return indexOf(ascii, 0);
	}
	public int indexOf(int ascii, int start){
		for(int i=start;i<arr.length;i++){
			if(arr[i]==ascii) return i;
		}
		return -1;
	}

	public MyString concat(MyString merge){
		char [] newArr = new char[arr.length+merge.length()];
		int indx = 0;
		for(char ele : arr){
			newArr[indx++] = ele;
		}
		for(int i=0;i<merge.length();i++){
			newArr[indx++] = merge.charAt(i);
		}
		return new MyString(newArr);
	}
	public boolean startsWith(MyString prefix){
		return startsWith(prefix, 0);
	}
	public boolean startsWith(MyString prefix, int start){
		if(arr.length<prefix.length() || start>=arr.length) return false;

		for(int i=start;i<prefix.length();i++){
			if(arr[i] != prefix.charAt(i)) return false;
		}
		return true;
	}
	public boolean endsWith(MyString suffix){
		if(arr.length<suffix.length()) return false;

		for(int i=suffix.length()-1,j=arr.length-1;i>=0;i--,j--){
			if(arr[j]!=suffix.charAt(i)) return false;
		}
		return true;
	}

	@Override
	public boolean equals (Object obj){
		if(!(obj instanceof MyString)) return false;
		MyString str = (MyString)obj;

		if(arr.length!=str.length()) return false;

		for(int i=0;i<str.length();i++)
			if(arr[i]!=str.charAt(i)) return false;

		return true;
	}

	public boolean contentEquals(StringBuffer sb){
		MyString obj = new MyString(sb);
		return this.equals(obj);
	}
	public boolean equalsIgnoreCase(MyString str){
		return this.toLowerCase().equals(str.toLowerCase());
	}
	public MyString replace(char oldChar, char newChar)
	{
		char[] newArr = arr.clone();
		for(int i=0;i<arr.length;i++){
			if(newArr[i]==oldChar)
				newArr[i]=newChar;
		}

		return new MyString(newArr);
	}

	public MyString substring(int start, int end){
		if(start > end || start<0||end<0||end>arr.length)
			throw new MyStringIndexOutOfBoundsException("Range ["+start+", "+end+" ) out of bounds for length "+arr.length);
		char [] newArr = new char[end-start];
		for(int i=0;i<newArr.length;i++){
			newArr[i] = arr[start++];
		}
		return new MyString(newArr);
	}
	public MyString substring(int offset){
		if(offset==0) return new MyString(arr);
		return substring(offset, arr.length);
	}
	public MyString trim(){
		int left = 0, right =0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==' ') left++;
			else break;
		}
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]==' ') right++;
			else break;
		}
		return substring(left,(arr.length)-right);
	}

	public MyString[] split(MyString regex){
		int count = 0;
		for(int i=0;i<arr.length;i++)
			if(arr[i]==regex.charAt(0)) count++;

		MyString [] newArr = new MyString[count+1];
		int indx = 0;

		MyString str = new MyString("");
		for(char ele : arr){
			if(ele != ' '){
				str = str.concat(new MyString(ele+""));
			}
			else{
				newArr[indx++] = str;
				str = new MyString("");
			}
		}
		newArr[indx] = str;
		return newArr;
	}

	public MyString replaceAll(MyString searchStr, MyString repStr){
		MyString [] newArr = new MyString(arr).split(new MyString (" "));
		System.out.println(Arrays.toString(newArr));
		MyString op = new MyString("");
		int indx = 0;
		for(MyString ele : newArr){
			if(ele.equals(searchStr))
				newArr[indx] = repStr;

			op = op.concat(new MyString(newArr[indx++]+" "));
		}
		return op.trim();
	}
	public char[] toCharArray() {
	    char[] copy = new char[arr.length];
	    for (int i = 0; i < arr.length; i++) {
	        copy[i] = arr[i];
	    }
    	return copy;
	}	
}















// lastIndexOf
// lastIndexOf
// contains
// replaceFirst
// split
// toCharArray
// intern

public class Convertstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n1 = "11";
		int num1 = Integer.parseInt(n1);
		double num2 = Double.parseDouble(n1);
		float num3 = Float.parseFloat(n1);
		Long num4 = Long.parseLong(n1);
		Byte num5 = Byte.parseByte(n1);
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		
//		怎么把字符串转成字符 -> 含义是指把字符串的第一个字符取到
//		解读：s5.
		System.out.println(n1.charAt(0));
		
	}

}

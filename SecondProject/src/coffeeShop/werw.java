package coffeeShop;

public class werw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 967532;
		int sum =0;
		while( i>0) {
			
			sum = sum + i%10;
			System.out.println(i);
			i=i/10;
		}
		System.out.println(sum);
	}

}

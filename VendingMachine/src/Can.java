public class Can {
	//멤버필드
	public static final int PRODUCT_CNT = 5;
	private String productNm;
	private int productPrice;	
	public final static String[] productNmArray = {"콜라", "사이다", "식혜", "환타", "칸타타"};
	public final static int[] productPriceArray = {500, 600, 700, 800, 900};
	
	//생성자
	public Can(int i) {
		if(i >= 0 && i < PRODUCT_CNT) {
			this.productNm = productNmArray[i];
			this.productPrice = productPriceArray[i];	
		}
	}
	
	//오버라이딩
	@Override
	public String toString() {
		return String.format("%s (%,d)", this.productNm, this.productPrice);
	}
}

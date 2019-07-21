public class Can {
	//멤버필드
	public static final int PRODUCT_CNT = 6;
	public final static String[] productNmArray = {"콜라", "사이다", "식혜", "환타", "칸타타", "펩시"};
	public final static int[] productPriceArray = {700, 600, 700, 800, 900, 1000};
		
	public final String productNm;
	public final int productPrice;		
	
	//생성자
	public Can(int i) {
		if(i >= 0 && i < PRODUCT_CNT) { //0~4
			this.productNm = productNmArray[i];
			this.productPrice = productPriceArray[i];	
		} else {
			this.productNm = null;
			this.productPrice = 0;
		}
	}
	
	//오버라이딩
	@Override
	public String toString() {
		return String.format("%s (%,d)", this.productNm, this.productPrice);
	}
}

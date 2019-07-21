import java.util.ArrayList;
import java.util.List;

public class VendingMachine2 {
	private final int INIT_QTY = 10;
	private int price;
	private List<Can>[] products = new ArrayList[Can.PRODUCT_CNT];
	
	//생성자
	public VendingMachine2() {
		for(int i=0; i<Can.PRODUCT_CNT; i++) { //제품 구분
			List<Can> list = new ArrayList(); 
			products[i] = list;
			
			for(int z=0; z<INIT_QTY; z++) {	//재고 (10개씩)			
				Can c = new Can(i);				
				list.add(c);
			}			
		}
	}
	
	//제품 리스트
	public void displayProductList() {
		System.out.println("제품번호\t제품명\t금액\t재고");
		System.out.println("----------------------------");
		String stockTitle;
		for(int i=0; i<Can.PRODUCT_CNT; i++) {
			int stock = getProductQty(i);
			if(stock > 0) {
				stockTitle = "O";
			} else {
				stockTitle = "X";
			}
			System.out.printf("%d \t %s \t %,d \t %s\n"
					, (i+1), Can.productNmArray[i], Can.productPriceArray[i], stockTitle);
		}
	}
	
	//잔액 표시
	public void displayChange() {
		System.out.printf("남은 금액 : %,d\n", this.price);
	}
	
	//개별 제품 재고 수량
	public int getProductQty(int i) {
		if(i < products.length && i >= 0) {
			return products[i].size();
		} 
		return 0;
	}
	
	//금액 주입
	public void insertPrice(int price) {
		this.price = price;
	}
		
		
	//return true(구매 성공), false(재고 없음)
	public boolean puchase(int i) {
		int qty = getProductQty(i);		
		if(qty > 0) {
			Can c = products[i].get(0);
			products[i].remove(c);
			price -= c.productPrice;
			return true;
		}		
		return false;
	}
	
}

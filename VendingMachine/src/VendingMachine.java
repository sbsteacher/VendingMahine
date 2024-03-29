import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private final int INIT_QTY = 10;
	private int price;
	//private List[] products = new ArrayList[Can.PRODUCT_CNT];
	
	List<Can> colaList = new ArrayList(); //0
	List<Can> cidaList = new ArrayList(); //1
	List<Can> sikList = new ArrayList(); //2
	List<Can> fantaList = new ArrayList(); //3
	List<Can> cantataList = new ArrayList(); //4
		
	//생성자
	public VendingMachine() {
		for(int i=0; i<Can.PRODUCT_CNT; i++) { //제품 구분			
			for(int z=0; z<INIT_QTY; z++) {	//재고 (10개씩)			
				Can c = new Can(i);				
				switch(i) {
					case 0:
						colaList.add(c);
						break;
					case 1:
						cidaList.add(c);
						break;
					case 2:
						sikList.add(c);
						break;
					case 3:
						fantaList.add(c);
						break;
					case 4:
						cantataList.add(c);
						break;						
				}
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
		switch(i) {
			case 0:
				return colaList.size();			
			case 1:
				return cidaList.size();			
			case 2:
				return sikList.size();			
			case 3:
				return fantaList.size();			
			case 4:
				return cantataList.size();		
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
			Can c = null;
			switch(i) {
				case 0:
					c = colaList.get(0);
					colaList.remove(c);
					break;
				case 1:
					c = cidaList.get(0);
					cidaList.remove(c);
					break;
				case 2:
					c = sikList.get(0);
					sikList.remove(c);
					break;
				case 3:
					c = fantaList.get(0);
					fantaList.remove(c);
					break;
				case 4:
					c = cantataList.get(0);
					cantataList.remove(c);
					break;						
			}
			
			price -= c.productPrice;
			return true;
		}		
		return false;
	}
	
	//기본 생성자
	/*
	public VendingMachine() {
		for(int i=0; i<Can.PRODUCT_CNT; i++) {
			List<Can> pList = new ArrayList();			
			Can c = new Can(i);			
			pList.add(c);			
			products[i] = pList;
		}
	}
	*/
}

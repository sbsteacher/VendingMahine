import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		VendingMachine2 vm = new VendingMachine2();
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 주입해 주세요 : ");
		int price = scan.nextInt();		
		vm.insertPrice(price);		
		
		while(true) {
			vm.displayProductList();
			System.out.print("구매할 제품번호를 입력해 주세요(종료: 0) :");
			int choice = scan.nextInt();
			
			if(choice == 0) {
				vm.displayChange();
				break;
			} else if(choice > Can.PRODUCT_CNT || choice < 0) {
				System.out.println("잘 못 선택하셨습니다.");
				continue;
			}
			//true: 구매완료, false: 재고 없음
			boolean result = vm.puchase(choice-1);
			if(result == false) {
				System.out.println("재고가 없습니다.");
			}
			
			vm.displayChange();
		}
		
		scan.close();
		
	}

}

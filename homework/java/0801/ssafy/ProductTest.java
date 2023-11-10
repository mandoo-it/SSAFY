package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductMgr pt = ProductMgr.getInstance();
		try {
			pt.add(new Refrigerator(11,"삼성냉장고",300000,11,100));
			pt.add(new Refrigerator(22,"엘지냉장고",300000,11,100));
			pt.add(new Tv(66,"이마트티비",300000,11,10,"아몰레"));
			pt.add(new Tv(44,"엘지티비",300000,11,10,"아몰레"));
			pt.add(new Tv(00,"삼성티비",300000,11,10,"반도체"));
		} catch (DuplicateException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		System.out.println("-------------전체 검색----------------");
		for(Product p:pt.allProduct()) {
			System.out.println(p.toString());
		}
		System.out.println();
		System.out.println("-------------상품 번호로 검색----------------");
		try {
			System.out.println(pt.findBySn(90).toString());
		} catch (CodeNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		System.out.println();
		
		System.out.println("-------------상품명으로 검색----------------");
		if(pt.findByName("삼성").size() > 0) {
			for(Product p:pt.findByName("삼성")) {
				System.out.println(p.toString());
			}
		}
		else 
			System.out.println("검색 결과 없음");
		System.out.println();
		
		System.out.println("-------------TV만 검색----------------");
		if(pt.findTv().size() > 0) {
			for(Product p:pt.findTv()) {
				System.out.println(p.toString());
			}
		}
		else 
			System.out.println("검색 결과 없음");
		System.out.println();
		
		System.out.println("-------------냉장고만 검색----------------");
		if(pt.findRefrigerator().size() > 0) {
			for(Product p:pt.findRefrigerator()) {
				System.out.println(p.toString());
			}
		}
		else 
			System.out.println("검색 결과 없음");
		System.out.println();
		
		System.out.println("------------상품 삭제 후----------------");
		for(Product p:pt.deleteProduct(44)) {
				if(p != null)
					System.out.println(p.toString());
		}
		
		System.out.println();	
		System.out.println("-------------재고들의 합----------------");
		System.out.println(pt.sum());
		
		System.out.println("-------------400L 이상의 냉장고 검색----------------");
			try {
				for(Product p:pt.findRefrigeratorByVolume()) {
					System.out.println(p.toString());
				}
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
		
		System.out.println("-------------50인치 이상의 티비만 검색---------------");
		try {
			for(Product p:pt.findTvByInch()) {
				System.out.println(p.toString());
			}
			
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		System.out.println();
		
		pt.changePrice(55, 900000);
		
		System.out.println("-------------전체 검색----------------");
		for(Product p:pt.allProduct()) {
			System.out.println(p.toString());
		}
		pt.close();

		
		

	}
}



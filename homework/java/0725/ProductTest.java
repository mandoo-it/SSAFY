package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductMgr pt = new ProductMgr();
		pt.add(new Refrigerator(11,"삼성냉장고",300000,11,100));
		pt.add(new Refrigerator(22,"엘지냉장고",300000,11,100));
		pt.add(new Refrigerator(33,"이마트냉장고",300000,11,100));
		pt.add(new Tv(44,"엘지티비",300000,11,80,"아몰레"));
		pt.add(new Tv(55,"삼성티비",300000,11,72,"반도체"));
		
		System.out.println("-------------전체 검색----------------");
		for(Product p:pt.allProduct()) {
			System.out.println(p.toString());
		}
		System.out.println();
		System.out.println("-------------상품 번호로 검색----------------");
		System.out.println(pt.findBySn(33).toString());
		System.out.println();
		
		System.out.println("-------------상품명으로 검색----------------");
		if(pt.findByName("삼성").length > 0) {
			for(Product p:pt.findByName("삼성")) {
				System.out.println(p.toString());
			}
		}
		else 
			System.out.println("검색 결과 없음");
		System.out.println();
		
		System.out.println("-------------TV만 검색----------------");
		if(pt.findTv().length > 0) {
			for(Product p:pt.findTv()) {
				System.out.println(p.toString());
			}
		}
		else 
			System.out.println("검색 결과 없음");
		System.out.println();
		
		System.out.println("-------------냉장고만 검색----------------");
		if(pt.findRefrigerator().length > 0) {
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
		System.out.println("-------------재고----------------");
		System.out.println(pt.sum());

	}
}



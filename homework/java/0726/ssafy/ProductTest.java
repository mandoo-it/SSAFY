package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductMgr pt = new ProductMgr();
		pt.add(new Refrigerator(11,"삼성냉장고",300000,11,100));
		pt.add(new Refrigerator(22,"엘지냉장고",300000,11,100));
		pt.add(new Tv(66,"이마트티비",300000,11,100,"아몰레"));
		pt.add(new Tv(44,"엘지티비",300000,11,80,"아몰레"));
		pt.add(new Tv(55,"삼성티비",300000,11,72,"반도체"));
		
		System.out.println("-------------전체 검색----------------");
		for(Product p:pt.allProduct()) {
			System.out.println(p.toString());
		}
		System.out.println();
		System.out.println("-------------상품 번호로 검색----------------");
		System.out.println(pt.findBySn(44).toString());
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
		System.out.println("-------------재고들의 합----------------");
		System.out.println(pt.sum());
		
		System.out.println("------------타입별 재고 금액(객체 파라미터)----------------");
		System.out.println(pt.getPriceByType(new Tv(55,"삼성티비",300000,11,72,"반도체")));
		
		System.out.println("------------타입별 재고 금액(문자열 파라미터)----------------");
		System.out.println(pt.getPriceByType("냉장고"));
		
		System.out.println("------------타입별 재고 수량(객체 파라미터)----------------");
		System.out.println(pt.getStockByType(new Tv(55,"삼성티비",300000,11,72,"반도체")));
		
		System.out.println("------------타입별 재고 수량(문자열 파라미터)----------------");
		System.out.println(pt.getStockByType("tv"));
		
		System.out.println("------------tv 재고 인치의 합----------------");
		System.out.println(pt.getAverageInch());
		
		System.out.println("------------냉장고 용량 합계----------------");
		System.out.println(pt.getTotalVolume());
		
		System.out.println("------------상품명, 가격으로 검색----------------");
		if(pt.lowerPriceProduct("티비", 600000).length > 0) {
			for(Product p:pt.lowerPriceProduct("티비", 600000)) {
				System.out.println(p.toString());
			}
		}
		else 
			System.out.println("검색 결과 없음");
		
		

	}
}



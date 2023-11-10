package com.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class CustomerTest {

    public static void main(String[] args) {
        String conf = "res/Configuration.xml";
        Reader reader;

        try {
            reader = Resources.getResourceAsReader(conf);//read conf xml file 
            //1. SqlSessionFactoryBuilder 객체 : 환경파일을 읽어와서 build()를 이용해서 sqlsessionfactory에 객체 생성
            //2. sqlsessionFactory : SqlSession 객체를 생성해주는 factory 객체
            //opensession() 메소드로 sqlsession객체를 얻을 수 있음
            //3. sqlsession 객체 : 여러가지 쿼리를 실행할 수 있는 메소드를 가지고 있음(mapper file에 등록된 sql을 실행시켜주긴 위한 api 제공)
            //selectOne() : 한개의 결과를 리턴/selectList() : 여러개의 결과를 리턴/insert()/delete()/update()
            
        
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            SqlSession session = factory.openSession();
            List<Customer> list;

            try {
            	//1. select all data:
            	//selectList: 여러개의 데이터 가져올때
            	list = session.selectList("selectAllCustomers");//파라미터가 xml에서 설정한 id
            	list = session.selectList("Customer.selectAllCustomers");
                for(Customer rec : list) {
                    System.out.println(rec.getNum()+"--"+rec.getName()+"--"+rec.getAddress());
                }

            	//2. select one data
            	Customer vo = (Customer) session.selectOne("selectCustomer", "111");
                System.out.println(vo.getName()+"--"+vo.getAddress());


//            	//3. insert data
//            	Customer insert = new Customer("999", "geene", "la");
//                session.insert("insert", insert);
//                list = session.selectList("Customer.selectAllCustomers");
//                System.out.println("after insert------------------------");
//                for(Customer rec : list) {
//                    System.out.println(rec.getNum()+"--"+rec.getName()+"--"+rec.getAddress());
//                }

            	//4. update data
                /*HashMap<String, String> map = new HashMap<String, String>();
                map.put("address","firenze");
                map.put("num","111");
                session.update("updateCustomer", map);*/
                
                session.delete("delete", "9990.....................................................................................................................");
                session.commit();
              
               //5. select all data
                list = session.selectList("selectAllCustomers");
                for(Customer rec : list) {
                   System.out.println(rec.getNum()+"--"+rec.getName()+"--"+rec.getAddress());
                }
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

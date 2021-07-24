package codingTest.TestSerialize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            String path = Test.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.

            File fileInSamePackage = new File(path + "objectfile.ser");
            // 객체를 직렬화하여 파일에 저장
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileInSamePackage));
            oos.writeObject(new Member("excode", "excode@gmail.com", 20));

            // 파일로부터 객체를 읽어 객체 생성
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileInSamePackage));
            Member member = (Member) ois.readObject();  // Object로 리턴되므로 명시적 형변환 필요
            System.out.println("생성경로: " + path);
            System.out.println(member);

            ////////////////////////////////////////////////
            // ArrayList에 담아 직렬화
            List<Member> memberList = new ArrayList<>();
            memberList.add(new Member("excode1", "excode1@gmail.com", 21));
            memberList.add(new Member("excode2", "excode2@gmail.com", 22));
            memberList.add(new Member("excode3", "excode3@gmail.com", 23));
            oos.writeObject(memberList);
            System.out.println(ois.readObject());


            //////////////////////////////////////////////
            // Object to Json && Json to Object
            //<dependency>
            //    <groupId>com.fasterxml.jackson.core</groupId>
            //    <artifactId>jackson-databind</artifactId>
            //    <version>2.11.1</version>
            //</dependency>
//            ObjectMapper mapper = new ObjectMapper();
//
//            // object to json
//            mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
//            mapper.writeValue(new File(path+"test.json"), memberList);

            // json to object
//            mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
//            mapper.writeValue(new File(path+ "test.json"), memberList);
//            System.out.println(mapper.readValue(new File(path+"test.json"), new ArrayList<Member>().getClass()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

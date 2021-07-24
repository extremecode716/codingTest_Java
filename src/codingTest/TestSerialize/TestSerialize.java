package codingTest.TestSerialize;

import java.io.*;
import java.util.Base64;

public class TestSerialize {
    public static void main(String[] args) {
        Member member = new Member("excode", "excode@gmail.com", 20);
        byte[] serializedMember;
        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos)
        ) {
            oos.writeObject(member);
            // serializedMember -> 직렬화된 member 객체
            serializedMember = baos.toByteArray();
            // 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
            System.out.println(Base64.getEncoder().encodeToString(serializedMember));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

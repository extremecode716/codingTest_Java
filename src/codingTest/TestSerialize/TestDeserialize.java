package codingTest.TestSerialize;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

public class TestDeserialize {
    public static void main(String[] args) {
        // 직렬화 예제에서 생성된 base64 데이터
        String base64Member = "rO0ABXNyAB9jb2RpbmdUZXN0LlRlc3RTZXJpYWxpemUuTWVtYmVy5r7pMbVhvC8CAANJAANhZ2VMAAVlbWFpbHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABG5hbWVxAH4AAXhwAAAAFHQAEGV4Y29kZUBnbWFpbC5jb210AAZleGNvZGU=";
        byte[] serializedMember = Base64.getDecoder().decode(base64Member);
        try (
                ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember);
                ObjectInputStream ois = new ObjectInputStream(bais)
        ) {
            // 역직렬화된 Member 객체를 읽어온다.
            Object objectMember = ois.readObject();
            Member member = (Member) objectMember;
            System.out.println(member);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

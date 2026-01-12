package 코딩페스티벌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G12904A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();

        String str2 = br.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str2.length(); i++) {
            list.add(String.valueOf(str2.charAt(i)));
        }


        while (str1.length() < list.size()) {
            if (list.get(list.size() - 1).equals("A")) {
                list.remove(list.size() - 1);
            } else if (list.get(list.size() - 1).equals("B")) {
                list.remove(list.size() - 1);
                Collections.reverse(list);
            }
        }

        String answer = "";
        for (String a : list) {
            answer += a;
        }

        if (answer.equals(str1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        // A 추가
        // 뒤집고 B추가
        // AB -> BAB / ABA -> 어떠한 연산을 하더라도 ABB는 못만듦
        // B -> BA -> ABB -> ABBA (가능)
    }
}

package level2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class One뉴스클러스터링 {

    private static List<String> intersection = new ArrayList<>();
    private static List<String> union = new ArrayList<>();

    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        final int MULTIPLY = 65536;

        List<String> str1Elements = getElements(str1);
        List<String> str2Elements = getElements(str2);

        Collections.sort(str1Elements);
        Collections.sort(str2Elements);

        operateSet(str1Elements, str2Elements);

        return (int) (calculateJ(intersection.size(), union.size()) * MULTIPLY);
    }

    private List<String> getElements(String str) {

        List<String> elements = new ArrayList<>();
        int start = 0;
        int end = 2;

        while (end <= str.length()) {

            String element = str.substring(start++, end++);

            if (checkAlphabet(element.charAt(0)) && checkAlphabet(element.charAt(1)))
                elements.add(element);
        }

        return elements;
    }

    private boolean checkAlphabet(char charaterToCheck) {

        if ('a' <= charaterToCheck && charaterToCheck <= 'z')
            return true;

        return false;
    }

    private void operateSet(List<String> str1Elements, List<String> str2Elements) {

        for (String element : str1Elements) {

            if (str2Elements.remove(element))
                intersection.add(element);

            union.add(element);
        }

        for (String element : str2Elements) {

            union.add(element);
        }
    }

    private List<String> getUnion(List<String> str1Elements, List<String> str2Elements) {

        List<String> union = new ArrayList<>();

        for (String element : str1Elements) {

            union.add(element);
        }

        for (String element : str2Elements) {

            if (!union.contains(element))
                union.add(element);
        }

        return union;
    }

    private double calculateJ(int intersectionSize, int unionSize) {

        if (unionSize == 0)
            return 1.0;

        return (double) intersectionSize / (double) unionSize;
    }
}

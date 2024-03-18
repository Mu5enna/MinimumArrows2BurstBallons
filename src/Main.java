import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int commaCounter(String input){
        int commaCount=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==','){
                commaCount++;
            }
        }
        return commaCount;
    }

    public static void main(String[] args) {
        int arrowCount=0;
        Vector<Pair> points = new Vector<>();
        Vector<Integer> nums = new Vector<>();
        System.out.println("Example Input Format : [1,3], [5,7], [2,6]");
        System.out.println("Enter points as shown in example (First index should be the smaller one");
        Scanner scnObj = new Scanner(System.in);
        String input = scnObj.nextLine();
        int commaCount = commaCounter(input);
        Pattern pattern=Pattern.compile("\\d+");
        Matcher matcher=pattern.matcher(input);
        while(matcher.find()){
            nums.add(Integer.parseInt(matcher.group()));
        }
        for(int i=0;i<((commaCount+1)/2);i++){
            Pair temp = new Pair();
            temp.setFirst(nums.getFirst());
            nums.removeFirst();
            temp.setSecond(nums.getFirst());
            nums.removeFirst();
            points.add(temp);
        }
        Vector<Pair> tempPoints = new Vector<>(points);
        while(!tempPoints.isEmpty()){
            System.out.println(tempPoints.lastElement().getFirst() + " " + tempPoints.lastElement().getSecond());
            tempPoints.removeLast();
        }
        while(!points.isEmpty()){
            for(int i=1;i<points.size();i++){
                if((points.firstElement().getFirst()<=points.elementAt(i).getSecond() && points.firstElement().getFirst()>=points.elementAt(i).getFirst()) || (points.firstElement().getSecond()<=points.elementAt(i).getSecond() && points.firstElement().getSecond()>=points.elementAt(i).getFirst())) {
                    points.removeElementAt(i);
                }
            }
            points.removeFirst();
            arrowCount++;
        }
        System.out.println("Minimum arrow needed : " + arrowCount);
    }
}
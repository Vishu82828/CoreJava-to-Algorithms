import java.util.*;
class StringBuilderSmall{
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder("Order Report : ");
        ArrayList <String> item = new ArrayList<>();
        item.add("Item 01");
        item.add("Item 02");
        item.add("Item 03");
        for(String s : item){
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString());
        sb.insert(0, "URGENT : ");
        System.out.println(sb.toString());
        sb.reverse();
        System.out.println(sb);
    }
}

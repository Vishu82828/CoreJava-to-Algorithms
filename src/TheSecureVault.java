import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class TheSecureVault {
    public static void main(String [] args){
        HashMap<String, Member> members = new HashMap<>();
        members.put("E101",new Member("Vishu1", 3));
        members.put("E102",new Member("Vishu2", 4));
        members.put("E103",new Member("Vishu3", 5));

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter ID : ");
        String id = input.nextLine();

        try{
            if(! members.containsKey(id)){
                throw new IllegalArgumentException(" Unauthorize ID : "+id);
            }
            Member foundMember = members.get(id);
            System.out.println("Welcome : "+ foundMember.getName()+", Access Level : "+ foundMember.getAccessLevel());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }

        HashSet<String> loggedIDs = new HashSet<>();
        loggedIDs.add("E103");
        loggedIDs.add("E101");
        loggedIDs.add("E103");
        for(String s : loggedIDs){
        System.out.println("Welcome : "+ s);
        }

        ArrayList <Member> allMembers = new ArrayList<>();
        allMembers.add(new Member("Vishu10", 10));
        allMembers.add(new Member("Vishu2", 2));
        allMembers.add(new Member("Vishu5", 5));
        Collections.sort(allMembers);
        for(Member m1 : allMembers){
            System.out.println(m1.getName());
        }
    }
}

class Member implements Comparable<Member>{
    private String name;
    protected int accessLevel;
    public Member(String name, int accessLevel){
        this.name = name;
        this.accessLevel = accessLevel;
    }
    public String getName(){ return name; }
    public int getAccessLevel(){ return accessLevel; }

    @Override
    public int compareTo(Member other){
        return this.accessLevel - other.accessLevel;
    }
}
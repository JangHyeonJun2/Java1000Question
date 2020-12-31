package 컬렉션프레임웍.HashMapEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx3 {
    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구","이자바","010-1111-2222");
        addPhoneNo("친구","김자바","010-2222-3333");
        addPhoneNo("친구","김자바","010-3333-4444");
        addPhoneNo("회사","김대리","010-4444-5555");
        addPhoneNo("회사","박대리","010-5555-6666");
        addPhoneNo("회사","강대리","010-6666-7777");
        addPhoneNo("세탁","042-111-2222");

        printList();
    }
    //그룹에 전화번호를 추가하는 메서드
    static void addPhoneNo(String groupName, String name, String tel){
        addGroup(groupName);
        HashMap group = (HashMap)phoneBook.get(groupName);
        group.put(tel,name);//이름은 중복이 될 수 있으니 전화번호를 key로 저장한다.
    }
    //그룹을 추가하는 메서드
    static void addGroup(String groupName){
        if(!phoneBook.containsKey(groupName))
            phoneBook.put(groupName, new HashMap());
    }
    static void addPhoneNo(String name, String tel){
        addPhoneNo("기타",name,tel);
    }

    static void printList(){
        Set set = phoneBook.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry map = (Map.Entry)it.next();

            Set subSet = ((HashMap)map.getValue()).entrySet();
            Iterator subIt = subSet.iterator();

            System.out.println(" * "+map.getKey()+"["+subSet.size()+"]");

            while(subIt.hasNext()){
                Map.Entry subE = (Map.Entry)subIt.next();
                String telNo = (String)subE.getKey();
                String name = (String)subE.getValue();
                System.out.println(name +" ,"+telNo);
            }
            System.out.println();
        }
    }
}

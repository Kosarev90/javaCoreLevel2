package Lesson_3.HomeWork_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook  implements Book{


    @Override
    public void add(String lastname, String phoneNumber) {
       Set<String> phones =  phoneByLastname.get(lastname);
       if(phones == null){
           Set<String> phoneSet = new HashSet<>();
           phoneSet.add(phoneNumber);
           phoneByLastname.put(lastname, phoneSet);
       }else {
           phones.add(phoneNumber);
           phoneByLastname.put(lastname, phones);
       }
    }

    @Override
    public Set<String> get(String lastName) {
        return this.phoneByLastname.get(lastName);
    }

    public Set<String> getAllLastnames(){
        return this.phoneByLastname.keySet();

    }

    Map<String, Set<String>> phoneByLastname = new HashMap<>();


}

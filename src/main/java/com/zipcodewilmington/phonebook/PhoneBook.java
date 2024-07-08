package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {


    private final Map<String, List<String>> phonebook;


    public Map<String, List<String>> getPhonebook() {
        return phonebook;
    }

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }

    public PhoneBook() {
        Map<String, List<String>> map = new LinkedHashMap<>();
        this.phonebook = map;
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> arrayList = new ArrayList<>();
       List<String> storedPhoneNumbers = phonebook.getOrDefault(name, arrayList);
       storedPhoneNumbers.add(phoneNumber);
       phonebook.put(name, storedPhoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> newList = new ArrayList<>();
        List<String> currentList = phonebook.getOrDefault(name, newList);
        for(String newNumber: phoneNumbers) {
            currentList.add(newNumber);
        }
        // currentList.addAll(Arrays.asList(phoneNumbers)); can do like this too
        phonebook.put(name, currentList);

    }

//    public void remove(String name) {
//        return phonebook.values(name);
//    }

    public Boolean hasEntry(String name, String number) {
        return phonebook.containsKey(name) || phonebook.containsValue(number);
    }


    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String lookupNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(lookupNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

//    public List<String> getAllContactNames() {
//        return phonebook;
//    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }

    public List<String> getAllContactNames() {
        List<String> listString = new ArrayList<String>();
        for (String key : phonebook.keySet()){
            listString.add(key);
        }
      // return Arrays.asList(phonebook);
       return listString;
    }

    public void remove(String name) {
        phonebook.remove(name);
    }
}

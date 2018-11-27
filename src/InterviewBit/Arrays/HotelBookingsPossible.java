package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookingsPossible {
    public static void main(String[] args){
        HotelBookingsPossible a = new HotelBookingsPossible();
        ArrayList<Integer> arrival = new ArrayList<>();
        arrival.add(1);arrival.add(3);arrival.add(6);
        ArrayList<Integer> depart = new ArrayList<>();
        depart.add(2);depart.add(4);depart.add(8);
        System.out.println(a.hotel(arrival, depart, 1));
    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K){

        Collections.sort(arrive);
        Collections.sort(depart);
        int i = 0 , j = 0 , roomsRequired = 0;
        while (i < arrive.size() && j < depart.size() && roomsRequired<= K){
            if(arrive.get(i) < depart.get(j)){
                roomsRequired++;
                i++;
            }else if(arrive.get(i) > depart.get(j)) {
                roomsRequired--;
                j++;
            }
            else {
                i++;
                j++;
            }

        }
        if(roomsRequired <=K) {
            return true;
        } else{
            return false;
        }


    }
}

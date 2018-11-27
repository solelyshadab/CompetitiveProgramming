package Google.CodeJam2018Practice;

import java.util.*;
import java.io.*;

public class SenateEvacuation {

    public static void main(String[] args) {
        SenateEvacuation senateEvacuation = new SenateEvacuation();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int totalMembersLeft = 0;
        for (int i = 1; i <= t; i++) {
            int noOfParties = in.nextInt();
            char partySymbol = 'A';
            ArrayList<Party> partyList = new ArrayList<>();
            for(int j =0; j< noOfParties; j++){
                if(j!=0){
                    int charValue = partySymbol + 1;
                    partySymbol = (char) charValue;
                }

                int members = in.nextInt();
                totalMembersLeft += members;
                SenateEvacuation.Party party = senateEvacuation.new Party(members, partySymbol );
                partyList.add(party);

            }
            String ans = "";
            while (totalMembersLeft > 0) {

                Collections.sort(partyList, new Comparator<Party>() {
                    @Override
                    public int compare(Party o1, Party o2) {
                        if (o1.membersLeft > o2.membersLeft) return -1;
                        if (o1.membersLeft < o2.membersLeft) return 1;
                        return 0;
                    }
                });

                if(totalMembersLeft == 3 ){

                    ans += partyList.get(0).partySymbol;
                    partyList.get(0).membersLeft -= 1;
                    ans += " ";
                    totalMembersLeft -=1;
                    continue;

                }
                if(totalMembersLeft == 1 ){

                    ans += partyList.get(0).partySymbol;
                    partyList.get(0).membersLeft -= 1;
                    ans += " ";
                    totalMembersLeft -=1;

                    continue;

                }

                    ans += partyList.get(0).partySymbol;
                    ans += partyList.get(1).partySymbol;
                    ans += " ";

                    partyList.get(0).membersLeft -= 1;
                    partyList.get(1).membersLeft -= 1;
                    totalMembersLeft -= 2;


            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    public class Party{
        int membersLeft;
        char partySymbol;

        public Party(int membersLeft, char partySymbol){
            this.membersLeft = membersLeft;
            this.partySymbol = partySymbol;
        }
    }
}

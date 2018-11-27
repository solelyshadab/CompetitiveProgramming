package com.topcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Aaagmnrs {
    public static void main(String[] args){
        //String[] phrases = {"q", "q"};
        //String[] phrases = {"q", "Q"};
        //String[] phrases = { "Aaagmnrs", "TopCoder", "anagrams", "Drop Cote" };
        //String[] phrases = { "SnapDragon vs tomek", "savants groped monk", "Adam vents prongs ok" };
        //String[] phrases ={ "Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" };
        //String[] phrases = {"wPpgWXmvGlGYOUDDvPQnV ICwEkcNL CgnxGGNDlWUzPDzuCN", "iWvwuwgCQdGzGoPd gPUCV geNlyncGLmVNCPpzlw NXUxdNkD", "qINcxGVpxCU YWwPUdNw cGLNM KCdnlgpNgPVUwGdozLzVeGd", "qnpgpNElgUOcgNCVPDdvwCDvGmUzncXYgguWzw lxPWnikdl", "uNcuIzCODXdWgVkLzGgnu W lQGPYXEVpVDGcnlwC wdNpnMgP", "snT m EWNGKJkjQuQgDHnIXH kyemuenZ kaDhPe", "dZwpQII"};
        String[] phrases = 	{"HkQtVatNmKS hPu OYJAE keIgFMtiOZrCZPxNE Elh", "ZizJxplHOMiEmQAeCStFHNY NKTKHRAkvUTeeOgP", "CrcGk GcVon JkBLKoBSqrFeiiotmVfkRlCyPjGNeVk ", "fslOO GEOKfyB IMecRrQGcGvVJnBrknCKcijL KPV Tk", "FHgsoTKEMnqZEuKXivNch IEHKraaMe pPyTl tzJO", " oCZTrtLNKYKPIkfPvHAAN EQ XEEHosMzIuEhgTmJ", "CtdecQKdQ CReyyISPtWFCoSuDFGBIYhIAk LbnNfR", "khCaIZUVAE YfMEo e eNkm t K NXPIljotrqP GHsT Hz", "gRFeBNcVKioBgsvj MrKOFckKTICGJePNyOCqlRlkV", "RiaUTmDCkVRtZ nsH BiaZkfSW", "yYD tJpsEIxUXi z MCWkrDJWDUPNQFNRn e", "rrTWTfM ZIBHkivUsNdkCAsaZ"};
        Aaagmnrs a = new Aaagmnrs();
        System.out.println(Arrays.toString(a.anagrams(phrases)));
    }
// mySolution: Working fine as well. All tests passed.
    public String[] anagrams(String[] phrases){
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Integer> ignoreList = new ArrayList<>();

        for(int i = 0; i < phrases.length; i ++){
            for(int j = 0; j < i ; j++){
                if(i==j)
                    continue;
                String s1 = phrases[i];
                s1 = s1.replaceAll("\\s+","");

                String s2 = phrases[j];
                s2 = s2.replaceAll("\\s+","");

                if(isAnagram(s1.toLowerCase(), s2.toLowerCase())){
                    if(!ignoreList.contains(phrases[j])) {
                        ignoreList.add(i);
                    }
                }

            }
        }


        for(int i =0; i < phrases.length; i++){

           if(!ignoreList.contains(i))
               ans.add(phrases[i]);
        }
        String[] ansArray = new String[ans.size()];
    return ans.toArray(ansArray);
    }


    public boolean isAnagram(String s1, String s2){
        boolean isAnagram = false;

        if (s1.length() == s2.length()) {
            char[] s1AsChar = s1.toCharArray();
            char[] s2AsChar = s2.toCharArray();
            Arrays.sort(s1AsChar);
            Arrays.sort(s2AsChar);
            isAnagram = Arrays.equals(s1AsChar, s2AsChar);
        }
        return isAnagram;

    }



//TopCoder Solution.
//    public String[] anagrams(String[] p) {
//        ArrayList ret = new ArrayList();
//        String[] copy = new String[p.length];
//        for(int k=0; k < p.length; k++){
//            String s = p[k].toLowerCase();
//            char[] b = s.toCharArray();
//            Arrays.sort(b);
//            s = new String(b);
//            s = s.trim();
//            copy[k] = s;
//        }
//        ret.add(p[0]);
//        for(int k=1; k < p.length; k++){
//            boolean keep = true;
//            for(int j=0; j < k; j++){
//                if (copy[j].equals(copy[k])){
//                    keep = false;
//                }
//            }
//
//            if (keep){
//                ret.add(p[k]);
//            }
//        }
//        copy = (String[]) ret.toArray(new String[0]);
//        return copy;
//    }

}

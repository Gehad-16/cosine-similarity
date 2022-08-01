//import java.io.File;  // Import the File class
//import java.io.FileNotFoundException;  // Import this class to handle errors
//import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.Math;
public class Main {

    public static Double Cosine_similarity (List<Integer>Vec_1, List<Integer>Vec_2 ) {

        Integer Dot_product=0;
        for(int i=0;i<Vec_1.size();i++){
            Dot_product=Dot_product+(Vec_1.get(i)*Vec_2.get(i));
        }
        //Mag_Doc_1
        Integer Doc_1_SQR_sum=0;
        for(int i=0;i<Vec_1.size();i++){
            Doc_1_SQR_sum=Doc_1_SQR_sum+(Vec_1.get(i));
        }Double Doc_1_SQR_sum_mag= Math.sqrt(Doc_1_SQR_sum);

        //Mag_Doc_2
        Integer Doc_2_SQR_sum=0;
        for(int i=0;i<Vec_2.size();i++){
            Doc_2_SQR_sum=Doc_2_SQR_sum+(Vec_2.get(i));
        }Double Doc_2_SQR_sum_mag= Math.sqrt(Doc_2_SQR_sum);


        Double Cos_similarity= Dot_product/(Doc_1_SQR_sum_mag*Doc_2_SQR_sum_mag);
        return(Cos_similarity);
    }

//=================================Sort_Dictionary==========================================

    public static void Sort_Dictionary(Map<String, Double> dic)
    {
        System.out.println("Unsorted : " + dic);

        LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
        dic.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("\nIn ascending  order   : " + sortedMap);

        LinkedHashMap<String, Double> reverseSortedMap = new LinkedHashMap<>();
        dic.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("\nIn descending order   : " + reverseSortedMap);
    }

//====================================Reading files===========================================================================

    public static void main(String[] args) {

        Set<String> Total_Docs = new HashSet<>();

        //======================================Doc_1===================================================
        Scanner s_1 = null;
        try {s_1 = new Scanner(new File("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\100.txt"));}
        catch (FileNotFoundException e) {throw new RuntimeException(e);}
        Set<String> Doc_1 = new HashSet<>();
        while (s_1.hasNext()) {
            String sss = s_1.next().replaceAll("\\p{Punct}", "");
            Doc_1.add(sss.replaceAll("[0-9]", ""));
            Total_Docs.add(sss.replaceAll("[0-9]", ""));}
        s_1.close();

        //======================================Doc_2=============================================================


        Scanner s_2 = null;
        try {s_2 = new Scanner(new File("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\101.txt"));}
        catch (FileNotFoundException e) {throw new RuntimeException(e);}
        Set<String> Doc_2 = new HashSet<>();
        while (s_2.hasNext()) {
            String sss = s_2.next().replaceAll("\\p{Punct}", "");
            Doc_2.add(sss.replaceAll("[0-9]", ""));
            Total_Docs.add(sss.replaceAll("[0-9]", ""));}
        s_2.close();


        //======================================Doc_3=============================================================


        Scanner s_3 = null;
        try {s_3 = new Scanner(new File("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\102.txt"));}
        catch (FileNotFoundException e) {throw new RuntimeException(e);}
        Set<String> Doc_3 = new HashSet<>();
        while (s_3.hasNext()) {
            String sss = s_3.next().replaceAll("\\p{Punct}", "");
            Doc_3.add(sss.replaceAll("[0-9]", ""));
            Total_Docs.add(sss.replaceAll("[0-9]", ""));}
        s_3.close();


        //======================================Doc_2=============================================================


        Scanner s_4 = null;
        try {s_4 = new Scanner(new File("E:\\Level_4\\second term\\IR\\ass\\ASS_2\\docs\\103.txt"));}
        catch (FileNotFoundException e) {throw new RuntimeException(e);}
        Set<String> Doc_4 = new HashSet<>();
        while (s_4.hasNext()) {
            String sss = s_4.next().replaceAll("\\p{Punct}", "");
            Doc_4.add(sss.replaceAll("[0-9]", ""));
            Total_Docs.add(sss.replaceAll("[0-9]", ""));}
        s_4.close();


//###################################### prints #############################################

        System.out.println("len_Doc_1 :"+ Doc_1.size()+"\n");
        System.out.println("len_Doc_2 :"+ Doc_2.size()+"\n");
        System.out.println("len_Doc_3 :"+ Doc_3.size()+"\n");
        System.out.println("len_Doc_4 :"+ Doc_4.size()+"\n");

        System.out.println("Total_Docs :"+ Total_Docs.size());

//##################################### Calculations ##############################################

//Convert from set to list :

        List<String> Total_Docs_list = new ArrayList<>(Total_Docs);

        //------------------------------VEC_1-------------------------------------

        List<Integer> Vec_1 = new ArrayList<Integer>(Collections.nCopies(Total_Docs.size(), 0));
        for (String D_1: Doc_1) {
            if (Total_Docs_list.indexOf(D_1) > -1)
            {Vec_1.set(Total_Docs_list.indexOf(D_1), 1);}}


        //------------------------------VEC_2-------------------------------------

        List<Integer> Vec_2 = new ArrayList<Integer>(Collections.nCopies(Total_Docs.size(), 0));
        for (String D_2: Doc_2) {
            if (Total_Docs_list.indexOf(D_2) > -1)
            {Vec_2.set(Total_Docs_list.indexOf(D_2), 1);}}


        //------------------------------VEC_3-------------------------------------

        List<Integer> Vec_3 = new ArrayList<Integer>(Collections.nCopies(Total_Docs.size(), 0));
        for (String D_3: Doc_3) {
            if (Total_Docs_list.indexOf(D_3) > -1)
            {Vec_3.set(Total_Docs_list.indexOf(D_3), 1);}}


        //------------------------------VEC_4-------------------------------------

        List<Integer> Vec_4 = new ArrayList<Integer>(Collections.nCopies(Total_Docs.size(), 0));
        for (String D_4: Doc_4) {
            if (Total_Docs_list.indexOf(D_4) > -1)
            {Vec_4.set(Total_Docs_list.indexOf(D_4), 1);}}


//################################# cosine similarity ####################################################

        Map<String, Double> Cosine_similarity_Dic = new HashMap<>();

        //---------------------------cosine similarity 1 ,2 ------------------------

        Cosine_similarity_Dic.put("D1 and D2 cosine similarity : " , Cosine_similarity(Vec_1, Vec_2));

        //---------------------------cosine similarity 1 ,3 ------------------------

        Cosine_similarity_Dic.put("D1 and D3 cosine similarity : " , Cosine_similarity(Vec_1, Vec_3));

        //---------------------------cosine similarity 1 ,4 ------------------------

        Cosine_similarity_Dic.put("D1 and D4 cosine similarity : " , Cosine_similarity(Vec_1, Vec_4));

        //---------------------------cosine similarity 2 ,3 ------------------------

        Cosine_similarity_Dic.put("D2 and D3 cosine similarity : " , Cosine_similarity(Vec_2, Vec_3));

        //---------------------------cosine similarity 2 ,4 ------------------------

        Cosine_similarity_Dic.put("D2 and D4 cosine similarity : " , Cosine_similarity(Vec_2, Vec_4));

        //---------------------------cosine similarity 3 ,4 ------------------------

        Cosine_similarity_Dic.put("D3 and D4 cosine similarity : " , Cosine_similarity(Vec_3, Vec_4));

        System.out.println("\n\n\n---------------------------- Cosine Similarity ----------------------- \n\n");


        Sort_Dictionary(Cosine_similarity_Dic);



//################################# cosine similarity ####################################################

        Map<String, Double> angle_Dic = new HashMap<>();

        //---------------------------cosine similarity 1 ,2 ------------------------

        angle_Dic.put("D1 and D2 Angle : " , Math.acos(Cosine_similarity(Vec_1, Vec_2))*(180/Math.PI));

        //---------------------------cosine similarity 1 ,3 ------------------------

        angle_Dic.put("D1 and D3 Angle : " , Math.acos(Cosine_similarity(Vec_1, Vec_3))*(180/Math.PI));

        //---------------------------cosine similarity 1 ,4 ------------------------

        angle_Dic.put("D1 and D4 Angle : " , Math.acos(Cosine_similarity(Vec_1, Vec_4))*(180/Math.PI));

        //---------------------------cosine similarity 2 ,3 ------------------------

        angle_Dic.put("D2 and D3 Angle : " , Math.acos(Cosine_similarity(Vec_2, Vec_3))*(180/Math.PI));

        //---------------------------cosine similarity 2 ,4 ------------------------

        angle_Dic.put("D2 and D4 Angle : " , Math.acos(Cosine_similarity(Vec_2, Vec_4))*(180/Math.PI));

        //---------------------------cosine similarity 3 ,4 ------------------------

        angle_Dic.put("D3 and D4 Angle : " , Math.acos(Cosine_similarity(Vec_3, Vec_4))*(180/Math.PI));

        System.out.println("\n\n\n---------------------------- Angle between the vectors -----------------------\n\n ");


        Sort_Dictionary(angle_Dic);


    }


}


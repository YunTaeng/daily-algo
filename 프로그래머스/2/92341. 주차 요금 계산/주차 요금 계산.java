import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inMap = new HashMap<>();
        TreeMap<String, Integer> totalMap = new TreeMap<>();
        for (String r : records){
            String[] record = r.split(" ");
            String hhmm = record[0];
            String carNum =record[1];
            String history=record[2];
            
            if (history.equals("IN")){
                inMap.put(carNum,timecalc(hhmm));
            }//IN일경우
            
            else{
                int intime=inMap.get(carNum);
                inMap.remove(carNum);
                int outtime=timecalc(hhmm);
                totalMap.put(carNum,totalMap.getOrDefault(carNum,0)+outtime-intime);
            }//OUT일경우
        }
        for (String carNum : inMap.keySet()) {
            int intime = inMap.get(carNum);
            int outtime = timecalc("23:59");
            totalMap.put(carNum, totalMap.getOrDefault(carNum, 0) + (outtime - intime));
        }
        int[] answer = new int[totalMap.size()];
        int idx = 0;

        for (int totalTime : totalMap.values()) {//누적시간 -> 요금
            int fee = fees[1];
            if (totalTime > fees[0]) {
                fee += Math.ceil((double)(totalTime - fees[0]) / fees[2]) * fees[3];
            }
            answer[idx++] = fee;
        }
        return answer;
    }//main
    
    public int timecalc(String hhmm){
        String[] part = hhmm.split(":");
        int hh = Integer.parseInt(part[0]);
        int mm = Integer.parseInt(part[1]);
        return hh*60+mm;
    }//timecalc
    
}//class
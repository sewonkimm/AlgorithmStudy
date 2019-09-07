import java.util.*;


//bfs로햇는데 1번 테케 틀려서
//dfs로 다시 해봐야겠다..!
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        int allCnt = 0;
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[1];
                final String time2 = entry2[1];
                return time1.compareTo(time2);
            }
        });

        Queue<String[]> q = new LinkedList<>();
        boolean[] check = new boolean[tickets.length];
        int c = 0;
        loop:for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                for(int j=0; j<tickets.length; j++){
                    if(tickets[i][1].equals(tickets[j][0])){
                        q.add(tickets[i]);
                        allCnt ++;
                        c = i;
                        break loop;
                    }
                }
            }
        }

        int cnt = 0;
        while(!q.isEmpty()){
            String[] a = q.remove();
            check[c] = true;
            answer[cnt] = a[0];

            loop:for(int i=0; i<tickets.length; i++){
                if(check[i] == false && a[1].equals(tickets[i][0])){
                    if(allCnt == tickets.length-1){
                        q.add(tickets[i]);
                        check[i] = true;
                        cnt++;
                        break loop;
                    }
                    for(int j=0; j<tickets.length; j++){
                        if(check[j] == false && tickets[i][1].equals(tickets[j][0])){
                            q.add(tickets[i]);
                            check[i] = true;
                            cnt++;
                            allCnt++;
                            break loop;
                        }
                    }
                }
            }


            if(q.isEmpty()){
                answer[cnt] = a[0];
                answer[cnt+1] = a[1];
            }
        }

        return answer;
    }
}
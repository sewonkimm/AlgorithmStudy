public class week1_4 {
    public static int answer = 0;
    public static void dfs(int[] numbers, int target, int index, int num){
        if(index == numbers.length){
            if(num == target) answer++;
        }else{
            dfs(numbers, target, index+1, num+numbers[index]);
            dfs(numbers, target, index+1, num-numbers[index]);
        }
    }
    public static int solution(int[] numbers, int target){
        dfs(numbers, target, 0, 0);

        return answer;
    }
    public static void main(String[] args){
        int[] arr = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(arr, target));
    }
}
public class week3_6 {
    public static int solution(int[] nums){
        int answer = 0;
        int check[] = new int[200001];
        int count = 0;

        int i = 0;
        while(count != nums.length/2 && i<nums.length){
            if(check[nums[i]]==0){
                count++;
                answer++;
                check[nums[i]]++;
            }
            i++;
        }

        return answer;
    }
    public static void main(String[] args){
        int[] arr = {3,3,3,2,2,4};
        System.out.println(solution(arr));
    }
}
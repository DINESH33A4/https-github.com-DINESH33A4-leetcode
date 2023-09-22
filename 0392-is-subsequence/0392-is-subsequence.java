class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0;
        int n = t.length() , m = s.length(); 
        char ss[] = s.toCharArray();
        char tt[] = t.toCharArray();

        if(m < 1)   return true;

        while(i < n){
        if(tt[i] == ss[j]){
            j++;
        }
        i++;
        if(j==m)    return true;
        }
        return false;
    }
}

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         int i, j;
//         boolean check = false;
//         i = j = 0;
//         for( ;i<s.length(); i++){
//             for( ;j<t.length(); j++){
//                 if(s.charAt(i) == t.charAt(j)){
//                     check = true;
//                     j++;
//                     break;
//                 }
//             }
//             if(check == true && j < t.length() + 1){
//                 check = false;
//             }
//             else{
//                 return false;
//             }
//         }
//         System.out.println(i + " " + j);
//         if(i!=s.length()){
//             return false;
//         }
//         return true;
//     }
// }
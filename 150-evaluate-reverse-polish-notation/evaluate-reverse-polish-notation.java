class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int a,b,c;
        for(int i = 0; i<tokens.length; i++){
            System.out.print(tokens[i] + "    ");
            switch(tokens[i]){
                case "+" : a = stk.pop();   b = stk.pop();  stk.push(a+b);  break;
                case "-" : a = stk.pop();   b = stk.pop();  stk.push(b-a);  break;
                case "*" : a = stk.pop();   b = stk.pop();  stk.push(a*b);  break;
                case "/" : a = stk.pop();   b = stk.pop();  stk.push(b/a);  break;
                default : stk.push(Integer.parseInt(tokens[i]));
            }
        }
        return stk.pop();
    }
}
public static int valley(String s, int n){
        int step = 0;
        int count = 0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'u' || ch == 'U'){
                step++;
                if(step == 0){
                    count++;
                }
            }
            if(ch == 'd' || ch == 'D'){
                step--;
            }
        }
        return count;
    }
